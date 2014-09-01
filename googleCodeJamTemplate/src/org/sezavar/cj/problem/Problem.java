package org.sezavar.cj.problem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.sezavar.cj.util.GcjUtil;

public abstract class Problem {
	Scanner reader;
	FileWriter writer;
	StringBuffer rs;

	public void solveAllSetsFor(String inputFileName) {
		this.reader = GcjUtil.getReaderFor(inputFileName);
		this.writer = GcjUtil.getWriterFor(inputFileName);
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

	protected abstract StringBuffer _solveEachSet();

}
