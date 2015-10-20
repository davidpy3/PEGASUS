package xample2;

import com.jcg.*;

/**
 * @author ashraf
 *
 */
public class CsvWriteReadTest {

	public static void main(String[] args) {
String fileName = System.getProperty("user.dir")+"/PLL1102201502070328.txt";
		
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);
		
//		System.out.println("\nRead CSV file:");
//		CsvFileReader.readCsvFile(fileName);
	}
}
