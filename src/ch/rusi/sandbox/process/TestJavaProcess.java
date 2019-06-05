package ch.rusi.sandbox.process;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestJavaProcess {

	public static void main(String[] args) {
		
		List<String> jvmArguments = Arrays.asList("-Xmx200m");
		List<String> arguments = Arrays.asList("argument");
		
		try {
			JavaProcess.exec(JavaProcessClass.class, jvmArguments, arguments);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
