 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTestPublic {
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("Assign 5- Morse Code - For Students/howDoILoveThee.txt"); 
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	
	
	@Test
    public void testConvertToEnglishString2() {
        String morseCode = "--. .. ...- . / -- . / -.-- --- ..- .-. / .- -. ... .-- . .-. / -.. ---";
        String expected = "give me your answer do";
        String actual = MorseCodeConverter.convertToEnglish(morseCode);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToEnglishFile() {
        File file = new File("Assign 5- Morse Code - For Students/Daisy.txt");
        String expected = "give me your answer do";
        try {
            String actual = MorseCodeConverter.convertToEnglish(file);
            assertEquals(expected, actual);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found or another IO exception occurred");
        }
    }
    
    @Test
    public void testConvertToEnglishDaisyDaisyString() {
        String morseCode = ".. -- / .... .- .-.. ..-. / -.-. .-. .- --.. -.-- / .- .-.. .-.. / ..-. --- .-. / - .... . / .-.. --- ...- . / --- ..-. / -.-- --- ..-";
        String expected = "im half crazy all for the love of you";
        String actual = MorseCodeConverter.convertToEnglish(morseCode);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testConvertToEnglishFile3() {
        File file = new File("Assign 5- Morse Code - For Students/Daisy.txt");
        String expected = "give me your answer do";
        try {
            String actual = MorseCodeConverter.convertToEnglish(file);
            assertEquals(expected, actual);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found or another IO exception occurred");
        }
    }

}
