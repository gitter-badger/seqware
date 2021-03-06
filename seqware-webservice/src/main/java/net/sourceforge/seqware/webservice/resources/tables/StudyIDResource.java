/*
 * Copyright (C) 2011 SeqWare
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.seqware.webservice.resources.tables;

import net.sf.beanlib.CollectionPropertyName;
import net.sf.beanlib.hibernate3.Hibernate3DtoCopier;
import net.sourceforge.seqware.common.business.StudyService;
import net.sourceforge.seqware.common.factory.BeanFactory;
import net.sourceforge.seqware.common.model.Study;
import net.sourceforge.seqware.common.util.xmltools.JaxbObject;
import net.sourceforge.seqware.common.util.xmltools.XmlTools;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * <p>
 * StudyIDResource class.
 * </p>
 *
 * @author mtaschuk
 * @version $Id: $Id
 */
public class StudyIDResource extends DatabaseIDResource {

    /**
     * <p>
     * Constructor for StudyIDResource.
     * </p>
     */
    public StudyIDResource() {
        super("studyId");
    }

    /**
     * <p>
     * getXml.
     * </p>
     */
    @Get
    public void getXml() {
        authenticate();
        StudyService ss = BeanFactory.getStudyServiceBean();
        Study study = testIfNull(ss.findBySWAccession(getId()));
        Hibernate3DtoCopier copier = new Hibernate3DtoCopier();
        JaxbObject<Study> jaxbTool = new JaxbObject<>();
        CollectionPropertyName<Study>[] createCollectionPropertyNames = CollectionPropertyName.createCollectionPropertyNames(Study.class,
                new String[] { "studyAttributes" });
        Study dto = copier.hibernate2dto(Study.class, study, new Class<?>[] {}, createCollectionPropertyNames);

        Document line = XmlTools.marshalToDocument(jaxbTool, dto);
        getResponse().setEntity(XmlTools.getRepresentation(line));
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    @Put
    public Representation put(Representation entity) {
        Representation representation = null;
        try {
            JaxbObject<Study> jo = new JaxbObject<>();
            String text = entity.getText();
            Study p = null;
            try {
                p = (Study) XmlTools.unMarshal(jo, new Study(), text);
            } catch (SAXException ex) {
                throw new ResourceException(Status.CLIENT_ERROR_UNPROCESSABLE_ENTITY, ex);
            }

            if (p.getOwner() == null) {
                p.setOwner(registration);
            }

            // persist object
            StudyService service = BeanFactory.getStudyServiceBean();
            Study study = testIfNull(service.findByID(p.getStudyId()));

            if (null != p.getStudyAttributes()) {
                // SEQWARE-1577 - AttributeAnnotator cascades deletes when annotating
                StudyIDResource.mergeAttributes(study.getStudyAttributes(), p.getStudyAttributes(), study);
            }

            String title = p.getTitle();
            String description = p.getDescription();
            String alias = p.getAlias();
            String accession = p.getAccession();
            String status = p.getStatus();
            String abstractStr = p.getAbstractStr();
            String newType = p.getNewType();
            String centerName = p.getCenterName();
            String centerProjectName = p.getCenterProjectName();
            Integer projectId = p.getProjectId();
            Boolean isSelected = p.getIsSelected();
            Boolean isHasFile = p.getIsHasFile();
            String html = p.getHtml();
            Integer existingTypeInt = p.getExistingTypeInt();

            if (null != title) {
                study.setTitle(title);
            }
            if (null != description) {
                study.setDescription(description);
            }
            if (null != alias) {
                study.setAlias(alias);
            }
            if (null != accession) {
                study.setAccession(accession);
            }
            if (null != status) {
                study.setStatus(status);
            }
            if (null != abstractStr) {
                study.setAbstractStr(abstractStr);
            }
            if (null != newType) {
                study.setNewType(newType);
            }
            if (null != centerName) {
                study.setCenterName(centerName);
            }
            if (null != centerProjectName) {
                study.setCenterProjectName(centerProjectName);
            }
            if (null != projectId) {
                study.setProjectId(projectId);
            }
            if (null != isSelected) {
                study.setIsSelected(isSelected);
            }
            if (null != isHasFile) {
                study.setIsHasFile(isHasFile);
            }
            if (null != html) {
                study.setHtml(html);
            }
            if (null != existingTypeInt) {
                study.setExistingTypeInt(existingTypeInt);
            }
            service.update(study);

            Hibernate3DtoCopier copier = new Hibernate3DtoCopier();
            Study detachedStudy = copier.hibernate2dto(Study.class, study);

            Document line = XmlTools.marshalToDocument(jo, detachedStudy);
            representation = XmlTools.getRepresentation(line);
            getResponse().setEntity(representation);
            getResponse().setLocationRef(getRequest().getRootRef() + "/studies/" + detachedStudy.getSwAccession());
            getResponse().setStatus(Status.SUCCESS_CREATED);
        } catch (SecurityException e) {
            getResponse().setStatus(Status.CLIENT_ERROR_FORBIDDEN, e);
        } catch (Exception e) {
            e.printStackTrace();
            getResponse().setStatus(Status.SERVER_ERROR_INTERNAL, e);
        }
        return representation;
    }
}
