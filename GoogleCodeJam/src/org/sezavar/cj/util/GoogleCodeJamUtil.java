package org.sezavar.cj.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

}
