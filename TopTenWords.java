package org.cloudwick.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopTenWords {
	
	private static class Word implements Comparable<Word>{
		String word;
		int count;

		@Override
		public int hashCode(){
			return word.hashCode();
		}

		@Override
		public boolean equals(Object obj){
			return word.equals(((Word)obj).word);
		}

		@Override
		public int compareTo(Word word){
			return word.count - count;
		}
	}
	
	public static void main(String[] args) throws IOException {

		Map<String, Word> countMap = new HashMap<String, Word>();
		
		File file = new File("G:/top10.csv");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		BufferedReader reader = new BufferedReader(new FileReader("G:/pg2600.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] words = line.split("[^a-zA-Z]+");
			for (String word : words) {
				if ("".equals(word)) {
					continue;
				}

				Word wordObj = countMap.get(word);
				if (wordObj == null) {
					wordObj = new Word();
					wordObj.word = word;
					wordObj.count = 0;
					countMap.put(word, wordObj);
				}

				wordObj.count++;
			}
		}

		reader.close();

		SortedSet<Word> sortedWords = new TreeSet<Word>(countMap.values());
		int i = 0;
		for (Word word : sortedWords) {
			if (i > 10) {
				break;
			}
			System.out.println(word.count + "," + word.word);
			bw.write(word.count + "," + word.word);
			bw.newLine();
			bw.flush();
			i++;
		}
		bw.close();
	}
}
