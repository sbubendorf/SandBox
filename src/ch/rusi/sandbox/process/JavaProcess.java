package ch.rusi.sandbox.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Running a Java Class as a Subprocess
 * ------------------------------------
 * This static function takes in the Class that you want to execute along with any JVM arguments and 
 * arguments that the class’s main method is expecting. Having access to both sets of arguments allows 
 * full control over the execution of the subprocess. For example, you might want to execute your 
 * class with a low heap space to see how it copes under memory pressure.
 * 
 * Note, for this to work, the class that you want to execute needs to have a main method. This is kind of important.
 * 
 * Sample call:
 * 
 * 		JavaProcess.exec(MyProcess.class, List.of("-Xmx200m"), List.of("argument"));
 * 
 * See also https://dzone.com/articles/running-a-java-class-as-a-subprocess?edition=486301&utm_source=Zone%20Newsletter&utm_medium=email&utm_campaign=java%202019-06-04
 * 
 */

public class JavaProcess {
	  private JavaProcess() {
	  }
	  public static int exec(Class<?> clazz, List<String> jvmArgs, List<String> args) throws IOException, InterruptedException {
	    String javaHome = System.getProperty("java.home");
	    String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
	    String classpath = System.getProperty("java.class.path");
	    String className = clazz.getName();
	    List<String> command = new ArrayList<>();
	    command.add(javaBin);
	    command.addAll(jvmArgs);
	    command.add("-cp");
	    command.add(classpath);
	    command.add(className);
	    command.addAll(args);
	    ProcessBuilder builder = new ProcessBuilder(command);
	    Process process = builder.inheritIO().start();
	    process.waitFor();
	    return process.exitValue();
	  }

}
