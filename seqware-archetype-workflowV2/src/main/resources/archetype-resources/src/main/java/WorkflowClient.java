/*
 * Copyright (C) 2012 SeqWare
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
package net.sourceforge.seqware;

import net.sourceforge.seqware.pipeline.workflowV2.WorkflowInterface;
import net.sourceforge.seqware.pipeline.workflowV2.model.Job;
import net.sourceforge.seqware.pipeline.workflowV2.model.Workflow;

public class WorkflowClient extends AbstractWorkflow {
    
    @Override
    public void beforeWorkflow() {
	
    }
    
    @Override
    public void generateWorkflow() {
	workflow.setName("Hello");
	Job job0 = workflow.createSeqwareModuleJob("test");
	job0.setCommand("mkdir data; mkdir bin; mkdir lib;");
    }
    
    @Override
    public void afterWorkflow() {
	
    }
}
