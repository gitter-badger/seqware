package net.sourceforge.seqware.pipeline.workflowV2.engine.oozie.object;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import net.sourceforge.seqware.pipeline.workflowV2.model.AbstractJob;
import net.sourceforge.seqware.pipeline.workflowV2.model.Command;

public class OozieBashJob extends OozieJob {

  public OozieBashJob(AbstractJob job, String name, String oozie_working_dir, boolean useSge, File seqwareJar,
                      String threadsSgeParamFormat, String maxMemorySgeParamFormat) {
    super(job, name, oozie_working_dir, useSge, seqwareJar, threadsSgeParamFormat, maxMemorySgeParamFormat);
  }

  protected Element createSgeElement() {

    File jobScript = emitJobScript();
    File runnerScript = emitRunnerScript(jobScript);
    File optionsFile = emitOptionsFile();

    Element sge = new Element("sge", SGE_XMLNS);
    add(sge, "script", runnerScript.getAbsolutePath());
    add(sge, "options-file", optionsFile.getAbsolutePath());

    return sge;
  }

  protected Element createJavaElement() {
    File jobScript = emitJobScript();

    Element java = new Element("java", WF_XMLNS);
    add(java, "job-tracker", "${jobTracker}");
    add(java, "name-node", "${nameNode}");

    Element config = add(java, "configuration");
    addProp(config, "mapred.job.queue.name", "${queueName}");
    addProp(config, "oozie.launcher.mapred.job.map.memory.mb", jobObj.getMaxMemory());
    addProp(config, "oozie.launcher.mapred.job.reduce.memory.mb", jobObj.getMaxMemory());
    addProp(config, "oozie.launcher.mapreduce.map.memory.physical.mb", jobObj.getMaxMemory());
    addProp(config, "oozie.launcher.mapreduce.reduce.memory.physical.mb", jobObj.getMaxMemory());

    add(java, "main-class", "net.sourceforge.seqware.pipeline.runner.Runner");
    for (String arg : runnerArgs(jobScript)) {
      add(java, "arg", arg);
    }

    return java;
  }

  public static String scriptFileName(String jobName){
    return jobName + ".sh";
  }

  private File emitJobScript() {
    File file = file(scriptsDir, scriptFileName(name), true);

    StringBuilder contents = new StringBuilder("#!/usr/bin/env bash\n\n");
    contents.append("cd ");
    contents.append(oozie_working_dir);
    contents.append("\n");
    for (String arg : jobObj.getCommand().getArguments()) {
      contents.append(arg);
    }
    contents.append("\n");

    write(contents.toString(), file);
    return file;
  }

  private File emitRunnerScript(File jobScript) {
    File file = file(scriptsDir, runnerFileName(name), true);

    ArrayList<String> args = new ArrayList<String>();
    args.add("java");
    args.add("-classpath");
    args.add(seqwareJarPath);
    args.add("net.sourceforge.seqware.pipeline.runner.Runner");
    args.addAll(runnerArgs(jobScript));

    StringBuilder contents = new StringBuilder("#!/usr/bin/env bash\n\n");
    for (String arg : args) {
      contents.append(arg);
      contents.append(" ");
    }

    write(contents.toString(), file);
    return file;
  }

  private List<String> runnerArgs(File jobScript) {
    List<String> args = runnerMetaDataArgs();
    args.add("--module");
    args.add("net.sourceforge.seqware.pipeline.modules.GenericCommandRunner");
    args.add("--");

    Command cmd = jobObj.getCommand();
    if (cmd.isGcrSkipIfMissing()){
      args.add("--gcr-skip-if-missing");
    }
    if (cmd.isGcrSkipIfOutputExists()){
      args.add("--gcr-skip-if-output-exists");
    }
    if(cmd.getGcrOutputFile() != null){
      args.add("--gcr-output-file");
      args.add(cmd.getGcrOutputFile());
    }

    args.add("--gcr-algorithm");
    args.add(jobObj.getAlgo());
    args.add("--gcr-script");
    args.add(jobScript.getAbsolutePath());
    return args;
  }

}
