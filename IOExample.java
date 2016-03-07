package org.cloudwick.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExample {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			String sCurrentLine;
			int count = 0;
			br = new BufferedReader(new FileReader("G:/pg2600.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] words = sCurrentLine.split(" ");
				int arraylength = words.length;
				for(int n = 0; n < arraylength; n++){
					if(words[n].equals("the")){
						count++;
					}
				}
			}
			System.out.println("Number f occurance of 'THE' = " + count);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
