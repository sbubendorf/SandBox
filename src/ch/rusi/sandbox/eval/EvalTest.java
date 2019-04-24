package ch.rusi.sandbox.eval;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.*;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;

public class EvalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    Foo foo = new Foo();
	    foo.setName("test");
	    System.out.println("Test with Foo named as " + foo.getName());
	    Map<String, Foo> context = new HashMap<>();
	    String expression = "foo.name == 'test'";
	    VariableResolverFactory functionFactory = new MapVariableResolverFactory(context);
	    context.put("foo",foo);
	    Boolean result = (Boolean) MVEL.eval(expression,functionFactory);
	    System.out.println(result);

	    Serializable compileExpression = MVEL.compileExpression(expression);
	    result = (Boolean) MVEL.executeExpression(compileExpression, context, functionFactory);
	    System.out.print(result);
		
	}
	
	private static class Foo {
		private String name = null;
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
	}

}
