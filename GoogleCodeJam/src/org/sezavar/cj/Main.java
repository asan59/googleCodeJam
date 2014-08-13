package org.sezavar.cj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import org.sezavar.cj.util.GoogleCodeJamUtil;

public class Main {
	public static void main(String[] args) {
		InputStream input = GoogleCodeJamUtil.class
				.getResourceAsStream("/StoreCredit/"
						+ GoogleCodeJamUtil.SMALL_INPUT_FILE_NAME);
		Scanner reader = new Scanner(input);
		System.out.println(reader.nextLine());
		reader.close();
	}
}
