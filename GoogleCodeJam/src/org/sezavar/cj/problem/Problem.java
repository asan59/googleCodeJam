package org.sezavar.cj.problem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.sezavar.cj.util.GcjUtil;
import org.sezavar.cj.util.InputOutputType;

public abstract class Problem {
	Scanner reader;
	FileWriter writer;
	StringBuffer rs;

	public void solveFor(InputOutputType inputOutputType) {
		String fullClassName = this.getClass().getName();
		String className = fullClassName.substring(fullClassName
				.lastIndexOf(".") + 1);
		this.reader = GcjUtil.getReaderFor(inputOutputType, className);
		this.writer = GcjUtil.getWriterFor(inputOutputType, className);
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

	public void solveSetsFor(InputOutputType inputOutputType) {
		String fullClassName = this.getClass().getName();
		String className = fullClassName.substring(fullClassName
				.lastIndexOf(".") + 1);
		this.reader = GcjUtil.getReaderFor(inputOutputType, className);
		this.writer = GcjUtil.getWriterFor(inputOutputType, className);
		this.rs = new StringBuffer();
		int n = Integer.valueOf(this.reader.nextLine());
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			try {
				long setStartTime = System.currentTimeMillis();
				this.rs = new StringBuffer();
				String result = _solveEachSet().toString();
				writer.append("Case #" + (i + 1) + ": " + result + "\n");
				long setEndTime = System.currentTimeMillis();
				System.out.println("Case #" + (i + 1) + " ("
						+ (setEndTime - setStartTime) + "): " + result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time: " + (endTime - startTime));
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected int readInt() {
		return Integer.valueOf(this.reader.nextLine());
	}

	protected abstract StringBuffer _solve();

	protected abstract StringBuffer _solveEachSet();

}
