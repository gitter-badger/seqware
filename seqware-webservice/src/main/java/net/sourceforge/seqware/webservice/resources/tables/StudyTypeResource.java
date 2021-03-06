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

import java.util.ArrayList;
import java.util.List;
import net.sf.beanlib.hibernate3.Hibernate3DtoCopier;
import net.sourceforge.seqware.common.business.StudyTypeService;
import net.sourceforge.seqware.common.factory.BeanFactory;
import net.sourceforge.seqware.common.model.StudyType;
import net.sourceforge.seqware.common.model.lists.StudyTypeList;
import net.sourceforge.seqware.common.util.xmltools.JaxbObject;
import net.sourceforge.seqware.common.util.xmltools.XmlTools;
import org.apache.log4j.Logger;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.w3c.dom.Document;

/**
 * <p>
 * ExperimentResource class.
 * </p>
 * 
 * @author boconnor
 * @version $Id: $Id
 */
public class StudyTypeResource extends DatabaseResource {

    private Logger logger;

    /**
     * <p>
     * Constructor for ExperimentResource.
     * </p>
     */
    public StudyTypeResource() {
        super("study_type");
        logger = Logger.getLogger(StudyTypeResource.class);
    }

    /** {@inheritDoc} */
    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        authenticate();
    }

    /**
     * <p>
     * getXml.
     * </p>
     */
    @Get
    public void getXml() {
        StudyTypeService ss = BeanFactory.getStudyTypeServiceBean();
        logger.debug("registration: " + registration);

        List<StudyType> objects = (List<StudyType>) testIfNull(ss.list());
        logger.debug("study_types: " + objects.size() + " " + objects);
        Hibernate3DtoCopier copier = new Hibernate3DtoCopier();
        JaxbObject<StudyTypeList> jaxbTool = new JaxbObject<>();

        StudyTypeList list = new StudyTypeList();
        list.setList(new ArrayList());

        for (StudyType obj : objects) {
            StudyType dto = copier.hibernate2dto(StudyType.class, obj);
            list.add(dto);
        }

        Document line = XmlTools.marshalToDocument(jaxbTool, list);

        getResponse().setEntity(XmlTools.getRepresentation(line));
    }

}
