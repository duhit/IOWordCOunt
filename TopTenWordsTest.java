package org.cloudwick.IO;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TopTenWordsTest {
	
	@Test
	public void fileExistTest(){
		File file = new File("G:/pg2600.txt");
		assertTrue(file.exists());
	}
	
	@Test
	public void fileFormatTest(){
		String fileXtension = ".txt";
		File file = new File("G:/pg2600" + fileXtension);
		assertEquals(fileXtension, ".txt");
	}
	
	 public static void assertReaders(BufferedReader expected,
	          BufferedReader actual) throws IOException {
	    String line;
	    while ((line = expected.readLine()) != null) {
	      assertEquals(line, actual.readLine());
	    }

	    assertNull("Actual had more lines then the expected.", actual.readLine());
	    assertNull("Expected had more lines then the actual.", expected.readLine());
	  }
}
