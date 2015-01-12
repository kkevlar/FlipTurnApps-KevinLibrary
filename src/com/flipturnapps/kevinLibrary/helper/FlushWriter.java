package com.flipturnapps.kevinLibrary.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FlushWriter extends PrintWriter {

	public FlushWriter(Writer out) {
		super(out);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(OutputStream out) {
		super(out);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(String fileName) throws FileNotFoundException {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(File file) throws FileNotFoundException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(Writer out, boolean autoFlush) {
		super(out, autoFlush);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(String fileName, String csn)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(fileName, csn);
		// TODO Auto-generated constructor stub
	}

	public FlushWriter(File file, String csn) throws FileNotFoundException,
			UnsupportedEncodingException {
		super(file, csn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void println()
	{
		super.println();
		super.flush();
	}
	@Override
	public void print(String s)
	{
		super.print(s);
		super.flush();
	}
	@Override
	public void println(String s)
	{
		super.println(s);
		super.flush();
	}

}
