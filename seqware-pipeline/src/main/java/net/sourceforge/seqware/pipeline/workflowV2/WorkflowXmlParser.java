package net.sourceforge.seqware.pipeline.workflowV2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import net.sourceforge.seqware.common.module.ReturnValue;
import net.sourceforge.seqware.common.util.Log;
import net.sourceforge.seqware.common.util.filetools.FileTools;
import net.sourceforge.seqware.common.util.freemarker.Freemarker;
import net.sourceforge.seqware.pipeline.workflowV2.model.Job;
import net.sourceforge.seqware.pipeline.workflowV2.model.SqwFile;
import net.sourceforge.seqware.pipeline.workflowV2.model.Workflow;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import freemarker.template.TemplateException;

public class WorkflowXmlParser {
	
	public ReturnValue parseXml(AbstractWorkflowDataModel wfdm, String file) {
		ReturnValue ret = new ReturnValue(ReturnValue.SUCCESS);
		//generate tmp xml file from FTL file
		File xml = null;
		try {
		    xml = FileTools.createFileWithUniqueName(new File("/tmp"), "xml");
		} catch (IOException e) {
		    e.printStackTrace();
		}

		try {
	         // Merge template with data
	         boolean changed = Freemarker.merge(file, xml.getAbsolutePath(), wfdm.getConfigs());

	         // While there are variables left, merge output file with hash
	         while (changed == true) {
	             changed = Freemarker.merge(xml.getAbsolutePath(), xml.getAbsolutePath(), wfdm.getConfigs());
	         }
	     } catch (IOException e) {
	         Log.error("IOException", e);
	            System.exit(ReturnValue.PROGRAMFAILED);
	     } catch (TemplateException e) {
	         // If we caught a template exception, warn and exit
	         Log.error("Freemarker threw an exception: " + e.getMessage());
	         System.exit(ReturnValue.FREEMARKEREXCEPTION);
	     }

		SAXBuilder builder = new SAXBuilder();
		try {
		    Document document = (Document) builder.build(xml);
		    Element root = document.getRootElement();
		    this.getWorkflowFromXml(wfdm, root);
		} catch (JDOMException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}		
		return ret;
	}
	
	private ReturnValue getWorkflowFromXml(AbstractWorkflowDataModel wfdm, Element root) {
		ReturnValue ret = new ReturnValue(ReturnValue.SUCCESS);
		//handle files
		Element filesE = root.getChild("files");
		if(filesE != null) {
			List<Element> fileES = filesE.getChildren();
			for(Element fe: fileES) {
				SqwFile file0 = new SqwFile();
				file0.setLocation(fe.getAttributeValue("location"));
				file0.setType(fe.getAttributeValue("type"));
				file0.setIsInput(Boolean.parseBoolean(fe.getAttributeValue("input")));
				if(fe.getAttribute("forcecopy") != null) {
					file0.setForceCopy(Boolean.parseBoolean(fe.getAttributeValue("forcecopy")));
				}
				wfdm.getFiles().put(fe.getAttributeValue("name"), file0); 
			}
		}
		//handle jobs
		Element jobsE = root.getChild("jobs");
		if(jobsE != null) {
			List<Element> jobES = jobsE.getChildren();
			for(Element je: jobES) {
				Job job = this.createJobFromElement(je, wfdm.getWorkflow());
			}
		}
		return ret;
	}

  
    private Job createJobFromElement(Element jobE, Workflow workflow) {
    	Job job = null;
    	String algo = jobE.getChildText("algorithm");
    	if(jobE.getAttribute("type") == null || jobE.getAttributeValue("type").equals("bash")) {
    		//bashJob
    		job = workflow.createBashJob(algo);
    	} else if(jobE.getAttributeValue("type").equals("java")) {
    		String cp = jobE.getAttributeValue("classpath");
    		String mainclass = jobE.getAttributeValue("main");
    		job = workflow.createJavaJob(algo, cp, mainclass);
    	} else if(jobE.getAttributeValue("type").equals("perl")) {
    		String script = jobE.getAttributeValue("main");
    		job = workflow.createPerlJob(algo, script);
    	} else if(jobE.getAttributeValue("type").toLowerCase().equals("javamodule")) {
    		job = workflow.createJavaModuleJob(algo);
    	}
    	return job;
    }
}