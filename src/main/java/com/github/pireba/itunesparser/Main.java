package com.github.pireba.itunesparser;

import java.io.File;
import java.net.URL;

public class Main {
	
	public static void main(String[] args) throws Exception {
		URL url = Main.class.getResource("/iTunes Library.xml");
		File file = new File(url.toURI());
		Parser parser = new Parser(file);
		parser.parse();
	}
}