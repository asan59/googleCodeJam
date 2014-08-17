package org.sezavar.cj.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GcjUtil {
	static HashMap<Character, String> T9Map = new HashMap<>();
	{
		T9Map.put('a', "2");
		T9Map.put('b', "22");
		T9Map.put('c', "222");
		T9Map.put('d', "3");
		T9Map.put('e', "33");
		T9Map.put('f', "333");
		T9Map.put('g', "4");
		T9Map.put('h', "44");
		T9Map.put('i', "444");
		T9Map.put('j', "5");
		T9Map.put('k', "55");
		T9Map.put('l', "555");
		T9Map.put('m', "6");
		T9Map.put('n', "66");
		T9Map.put('o', "666");
		T9Map.put('p', "7");
		T9Map.put('q', "77");
		T9Map.put('r', "777");
		T9Map.put('s', "7777");
		T9Map.put('t', "8");
		T9Map.put('u', "88");
		T9Map.put('v', "888");
		T9Map.put('w', "9");
		T9Map.put('x', "99");
		T9Map.put('y', "999");
		T9Map.put('z', "9999");
		T9Map.put(' ', "0");
	}

	public final static Scanner getReaderFor(InputOutputType inputOutputType,
			String problemName) {
		InputStream input = GcjUtil.class.getResourceAsStream("/"
				+ problemName + "/" + inputOutputType.getInputName());
		Scanner reader = new Scanner(input);
		return reader;
	}

	public final static FileWriter getWriterFor(
			InputOutputType inputOutputType, String problemName) {
		URL url = GcjUtil.class.getResource("/" + problemName + "/");
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

	public final static int[] lineToArrayOfInts(String line, String seperator) {
		String[] tokenized = line.split(seperator);
		int[] result = new int[tokenized.length];
		for (int i = 0; i < tokenized.length; i++) {
			result[i] = Integer.parseInt(tokenized[i].trim());
		}
		return result;
	}

	public final static List<Integer> lineToListOfIntegers(String line,
			String seperator) {
		String[] tokenized = line.split(seperator);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < tokenized.length; i++) {
			result.add(Integer.parseInt(tokenized[i].trim()));
		}
		return result;
	}
	

}
