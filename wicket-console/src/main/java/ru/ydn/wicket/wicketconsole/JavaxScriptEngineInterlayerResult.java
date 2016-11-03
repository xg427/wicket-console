package ru.ydn.wicket.wicketconsole;

import java.io.StringReader;
import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

import org.apache.wicket.model.Model;

public class JavaxScriptEngineInterlayerResult implements IScriptEngineInterlayerResult{
	private static final long serialVersionUID = 1L;
	
	private transient ScriptContext ctx;
	private transient Object result;
	
	private String out;
	private String error;
	private transient IScriptEngineInterlayerResultRenderer renderer;

	public JavaxScriptEngineInterlayerResult() {
		this.ctx = new SimpleScriptContext();
		ctx.setWriter(new StringWriter());
		ctx.setErrorWriter(new StringWriter());
		ctx.setReader(new StringReader(""));
	}
	
	protected ScriptContext getScriptContext(){
		return ctx;
	}

	@Override
	public String getOut() {
		return out;
	}

	protected void setOut(String out) {
		this.out = out;
	}

	@Override
	public String getError() {
		return error;
	}

	protected void setError(String error) {
		this.error = error;
	}
	
	public void onUpdate(){
		out = getContentAndClear((StringWriter)ctx.getWriter());
		error = getContentAndClear((StringWriter)ctx.getErrorWriter()); 
	}
	
	private static String getContentAndClear(StringWriter writer)
	{
		StringBuffer buf = writer.getBuffer();
		String ret = buf.toString();
		buf.setLength(0);
		return ret;
	}

	@Override
	public Object getReturnedObject() {
		return result;
	}

	protected void setReturnedObject(Object result) {
		this.result = result;
	}
}
