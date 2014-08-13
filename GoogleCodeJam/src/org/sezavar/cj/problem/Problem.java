package org.sezavar.cj.problem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.sezavar.cj.util.GoogleCodeJamUtil;
import org.sezavar.cj.util.InputOutputType;

public abstract class Problem {
	Scanner reader;
	FileWriter writer;
	StringBuffer rs;

	public void solveFor(InputOutputType inputOutputType) {
		String fullClassName = this.getClass().getName();
		String className = fullClassName.substring(fullClassName
				.lastIndexOf(".") + 1);
		this.reader = GoogleCodeJamUtil
				.getReaderFor(inputOutputType, className);
		this.writer = GoogleCodeJamUtil
				.getWriterFor(inputOutputType, className);
		this.rs = new StringBuffer();
		this._solve();
		try {
			writer.append(rs.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected abstract void _solve();

}
