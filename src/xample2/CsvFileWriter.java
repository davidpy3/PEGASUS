package xample2;
import com.jcg.*;
import entidad.BodyInterfaz;
import entidad.ObjetoConexion;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");

	//CSV file header
  //  private static final String FILE_HEADER = "001102,2015,03,02,07,0055,170,33567.65,9875.66,3409.77,0.00,0.00,0.22";

    public static void writeCsvFile(String fileName) {

        Statement stmt = null;
        ResultSet rs = null;

        ObjetoConexion oc = new ObjetoConexion();
        Connection con = oc.conectarSQL();
        try {

            // Build an SQL String 
            String sqlQuery ="SELECT * from lista_plani";

            // Create a Statement object
            stmt = con.createStatement();

            // Execute SQL and get obtain the ResultSet object
            rs = stmt.executeQuery(sqlQuery);
//            ArrayList<BodyInterfaz> employees = new ArrayList<>();
//            // Process the result set - print Employees
            
            String dnianterior = null;
            BodyInterfaz empleadoanterior = new BodyInterfaz();
            Double sumamonto = 0.0;
            Double sumamontoRecontratotal = 0.0;
            String texto = "";
            String textotemp = "";
            DecimalFormat f=new DecimalFormat("0.00");
            
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
    //        textotemp += FILE_HEADER.toString();
            //Add a new line separator after the header
            textotemp += NEW_LINE_SEPARATOR;
            //Write a new student object list to the CSV file
                
                
                 java.util.Date d=new java.util.Date();
      Calendar c = new GregorianCalendar(); 
      c.setTime(d);
      String dia, mes, annio, hora = null, minuto = null, segundo = null;  
        
       dia = Integer.toString(c.get(Calendar.DATE));
       mes = Integer.toString(c.get(Calendar.MONTH)+1);
       annio = Integer.toString(c.get(Calendar.YEAR));

            
            
            while (rs.next()) {
                BodyInterfaz currentEmp = new BodyInterfaz();
                
                if(dnianterior == null){dnianterior = rs.getString("DNI");}
                if(!dnianterior.equals(rs.getString("DNI"))){
                  //  textotemp += ">>";
                    textotemp += empleadoanterior.getTipo_doc();
                    textotemp += COMMA_DELIMITER;
                    textotemp += empleadoanterior.getDni();
                    textotemp += COMMA_DELIMITER;
                    textotemp += empleadoanterior.getFuente_financ();
                    textotemp += COMMA_DELIMITER;
                    
                    textotemp +="9";
                    textotemp += COMMA_DELIMITER;
                    textotemp +="9999";
                    textotemp += COMMA_DELIMITER;
                    
//                    textotemp += empleadoanterior.getInd();
//                    textotemp += COMMA_DELIMITER;
                    textotemp += empleadoanterior.getDescripcion();
                    textotemp += COMMA_DELIMITER;
                    textotemp += String.valueOf(f.format(sumamonto));// COMMA_DELIMITER;
                    textotemp += NEW_LINE_SEPARATOR;
                    
                    sumamonto = 0.0;
                }
                
                
                    currentEmp.setTipo_doc(rs.getString("Tipo_Doc"));
                    currentEmp.setDni(rs.getString("DNI"));
                    currentEmp.setFuente_financ(rs.getString("Fuente_Financ"));
                    currentEmp.setInd(rs.getString("Ind"));
                    currentEmp.setCodigo(rs.getString("Codigo"));
                    currentEmp.setDescripcion(rs.getString("Descripcion"));
                    currentEmp.setMonto(rs.getDouble("Monto"));
                    currentEmp.setPlanilla(rs.getString("Planilla"));
                    
                
                try {
                    textotemp += currentEmp.getTipo_doc();
                    textotemp += COMMA_DELIMITER;
                    textotemp += currentEmp.getDni();
                    textotemp += COMMA_DELIMITER;
                    textotemp += currentEmp.getFuente_financ();
                    textotemp += COMMA_DELIMITER;
                    textotemp += currentEmp.getInd();
                    textotemp += COMMA_DELIMITER;
                    textotemp += currentEmp.getCodigo();
                    textotemp += COMMA_DELIMITER;
                    textotemp += currentEmp.getDescripcion();
                    textotemp += COMMA_DELIMITER;
                    textotemp += String.valueOf(f.format(currentEmp.getMonto()));// COMMA_DELIMITER;
                    textotemp += NEW_LINE_SEPARATOR;
                } catch (Exception e) {
                    System.out.println("Error in CsvFileWriter !!!");
                    e.printStackTrace();
                } finally {
                    
                }
                
                if(rs.getString("Ind").equals("1")){
                    sumamonto += rs.getDouble("Monto");
                    sumamontoRecontratotal += rs.getDouble("Monto");
                }
                else
                if(rs.getString("Ind").equals("2")){
                    sumamonto -= rs.getDouble("Monto");
                    sumamontoRecontratotal -= rs.getDouble("Monto");
                }
                
                dnianterior = rs.getString("DNI");
                empleadoanterior = currentEmp;
            }
            
     //       textotemp += ">>";
            textotemp += empleadoanterior.getTipo_doc();
            textotemp += COMMA_DELIMITER;
            textotemp += empleadoanterior.getDni();
            textotemp += COMMA_DELIMITER;
            textotemp += empleadoanterior.getFuente_financ();
            textotemp += COMMA_DELIMITER;
            textotemp += "9";
            textotemp += COMMA_DELIMITER;
            textotemp += "9999";
            textotemp += COMMA_DELIMITER;
//            textotemp += empleadoanterior.getInd();
//            textotemp += COMMA_DELIMITER;
            textotemp += empleadoanterior.getDescripcion();
            textotemp += COMMA_DELIMITER;
            textotemp += String.valueOf(f.format(sumamonto));// COMMA_DELIMITER;
            textotemp += NEW_LINE_SEPARATOR;

//            fileWriter.append("@@>>"+String.valueOf(sumamontoRecontratotal));
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            fileWriter.append(textotemp);
                       
            fileWriter.append("001102;"+annio+";"+mes+";02;07;"+
                    empleadoanterior.getPlanilla().substring(4,8)+";"
                    +String.valueOf(f.format(sumamontoRecontratotal)));
            fileWriter.append("////"+rs.next());
         //   fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(textotemp);

            
            sumamonto = 0.0;
            
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        } catch (Exception se) {
            System.out.println("SQLError: " + se.getMessage() + " code: ");
        }

    }
}
