package org.sezavar.cj.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoogleCodeJamUtil {

	public final static Scanner getReaderFor(InputOutputType inputOutputType,
			String problemName) {
		InputStream input = GoogleCodeJamUtil.class.getResourceAsStream("/"
				+ problemName + "/" + inputOutputType.getInputName());
		Scanner reader = new Scanner(input);
		return reader;
	}

	public final static FileWriter getWriterFor(
			InputOutputType inputOutputType, String problemName) {
		URL url = GoogleCodeJamUtil.class.getResource("/" + problemName + "/");
		try {
			return new FileWriter(new File(url.getPath() + "../../resources/"
					+ problemName + "/" + inputOutputType.getOutputName()),
					false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final static int[] lineToInts(String line, String seperator) {
		String[] tokenized = line.split(seperator);
		int[] result = new int[tokenized.length];
		for (int i = 0; i < tokenized.length; i++) {
			result[i] = Integer.parseInt(tokenized[i].trim());
		}
		return result;
	}

	public final static List<Integer> lineToListOfIntegers(String line, String seperator) {
		String[] tokenized = line.split(seperator);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < tokenized.length; i++) {
			result.add(Integer.parseInt(tokenized[i].trim()));
		}
		return result;
	}

}
