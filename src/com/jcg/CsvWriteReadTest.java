package com.jcg;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class CsvWriteReadTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      java.util.Date d=new java.util.Date();
      Calendar c = new GregorianCalendar(); 
      c.setTime(d);
      String dia, mes, annio, hora = null, minuto = null, segundo = null;  
        
       dia = Integer.toString(c.get(Calendar.DATE));
       mes = Integer.toString(c.get(Calendar.MONTH)+1);
       annio = Integer.toString(c.get(Calendar.YEAR));
       
        
        
       // String fileName = System.getProperty("user.dir")+"/"+annio+"0"+mes+"02070.txt";
		String fileName = ("C:\\siaf\\Siaf_Vfp\\planillas")+"/PLL001102"+annio+"0"+mes+"01030.txt";
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);
		
                BodyInterfaz x=new BodyInterfaz();
                
                //System.out.println("numero de planilla :"+x.getPlanilla());
//		System.out.println("\nRead CSV file:");
//		CsvFileReader.readCsvFile(fileName);
    }
    
}