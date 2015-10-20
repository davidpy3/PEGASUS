package com.jcg;

import entidad.ObjetoConexion;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CsvFileWriter {

     //Delimiter used in CSV file
    private static final String DELIMITADOR = ";";
    private static final String SALTO_LINEA = System.getProperty("line.separator");
    //CSV file header
    private static final String FILE_HEADER = "001102,2015,03,02,07,0055,170,33567.65,9875.66,3409.77,0.00,0.00,0.22";
    
    public static void writeCsvFile(String fileName) {

        Statement stmt = null;
        ResultSet rs = null;

        ObjetoConexion oc = new ObjetoConexion();
        Connection con = oc.conectarSQL();
        try {
            // Build an SQL String sdsds
            String sqlQuery ="SELECT     '01' AS Tipo_Doc, Planilla_Detalle.DNI, Planilla.Fuente_Financ, Planilla_Detalle.Ind, Planilla_Detalle.Codigo, 'cap' AS Descripcion, \n" +
"                      Planilla_Detalle.Monto,Planilla_Detalle.N_Expediente AS Planilla\n" +
"FROM         Planilla INNER JOIN\n" +
"                      Planilla_Detalle ON Planilla.N_Expediente = Planilla_Detalle.N_Expediente INNER JOIN\n" +
"                      Planilla_Trab ON Planilla.N_Expediente = Planilla_Trab.N_Expediente AND Planilla.Ano_eje = Planilla_Trab.Ano_eje AND \n" +
"                      Planilla_Detalle.N_Expediente = Planilla_Trab.N_Expediente AND Planilla_Detalle.Ano_eje = Planilla_Trab.Ano_eje AND \n" +
"                      Planilla_Detalle.DNI = Planilla_Trab.DNI\n" +
"WHERE     (Planilla.Ano_eje = '2015') AND (Planilla_Detalle.N_Expediente = '10000196')";
                    
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
            
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            
            DecimalFormat f=new DecimalFormat("####.00",simbolos);
            //String texto = "";
            String textocuerpo = "";
            
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            //textotemp += FILE_HEADER.toString();
            //Add a new line separator after the header
            //textotemp += NEW_LINE_SEPARATOR;
            //Write a new student object list to the CSV file
                                
      java.util.Date d=new java.util.Date();
      Calendar c = new GregorianCalendar(); 
      c.setTime(d);
      String dia, mes, annio, hora = null, minuto = null, segundo = null;  
        
       dia = Integer.toString(c.get(Calendar.DATE));
       mes = Integer.toString(c.get(Calendar.MONTH)+1);
       annio = Integer.toString(c.get(Calendar.YEAR));
       
       
       
       
       
       BodyInterfaz x=new BodyInterfaz();
           
            while (rs.next()) {
                BodyInterfaz currentEmp = new BodyInterfaz();
                
                if(dnianterior == null){dnianterior = rs.getString("DNI");}
                
                        if(!dnianterior.equals(rs.getString("DNI"))){
                            
                            //textocuerpo += ">>";
                            textocuerpo += empleadoanterior.getTipo_doc();
                            textocuerpo += DELIMITADOR;
                            textocuerpo += empleadoanterior.getDni();
                            textocuerpo += DELIMITADOR;
                            textocuerpo += empleadoanterior.getFuente_financ();
                            textocuerpo += DELIMITADOR;
                            textocuerpo += "9";
                            textocuerpo += DELIMITADOR;
                            textocuerpo += "9999";
                            textocuerpo += DELIMITADOR;
                            textocuerpo += empleadoanterior.getDescripcion();
                            textocuerpo += DELIMITADOR;
                            textocuerpo += String.valueOf(f.format(sumamonto));
                            //textocuerpo += String.valueOf((sumamonto));
                            textocuerpo += SALTO_LINEA;
                            sumamonto = 0.0;
                        }
                            currentEmp.setTipo_doc(rs.getString("Tipo_Doc"));
                            currentEmp.setDni(rs.getString("DNI"));
                            currentEmp.setFuente_financ(rs.getString("Fuente_Financ"));
                            currentEmp.setInd(rs.getString("Ind"));
                            currentEmp.setCodigo(rs.getString("Codigo"));
                            currentEmp.setDescripcion(rs.getString("Descripcion"));
                            currentEmp.setPlnailla(rs.getString("Planilla"));
                            currentEmp.setMonto(rs.getDouble("Monto"));

                                    try {
                                        textocuerpo += currentEmp.getTipo_doc();
                                        textocuerpo += DELIMITADOR;
                                        textocuerpo += currentEmp.getDni();
                                        textocuerpo += DELIMITADOR;
                                        textocuerpo += currentEmp.getFuente_financ();
                                        textocuerpo += DELIMITADOR;
                                        textocuerpo += currentEmp.getInd();
                                        textocuerpo += DELIMITADOR;
                                        textocuerpo += currentEmp.getCodigo();
                                        textocuerpo += DELIMITADOR;
                                        textocuerpo += currentEmp.getDescripcion();
                                        textocuerpo += DELIMITADOR;
                                        textocuerpo += String.valueOf(currentEmp.getMonto());// COMMA_DELIMITER;
                                        textocuerpo += SALTO_LINEA;
                                    } catch (Exception e) {
                                        System.out.println("Error in CsvFileWriter !!!");
                                        e.printStackTrace();
                                    } finally 
                                    {

                                    }
                
                if(rs.getString("Ind").equals("1")){
                    sumamonto += rs.getDouble("Monto");
                    sumamontoRecontratotal += rs.getDouble("Monto");
                }
                else
                if(rs.getString("Ind").equals("2")   ){
                    sumamonto -= rs.getDouble("Monto");
                    sumamontoRecontratotal -= rs.getDouble("Monto");
                }
                
                dnianterior = rs.getString("DNI");
                empleadoanterior = currentEmp;
            }

           //textocuerpo += ">>";
            textocuerpo += empleadoanterior.getTipo_doc();
            textocuerpo += DELIMITADOR;
            textocuerpo += empleadoanterior.getDni();
            textocuerpo += DELIMITADOR;
            textocuerpo += empleadoanterior.getFuente_financ();
            textocuerpo += DELIMITADOR;
            
            textocuerpo += "9";
            textocuerpo += DELIMITADOR;
            textocuerpo += "9999";
            textocuerpo += DELIMITADOR;
            textocuerpo += empleadoanterior.getDescripcion();
            textocuerpo += DELIMITADOR;
            textocuerpo += String.valueOf(f.format(sumamonto));
            textocuerpo += SALTO_LINEA;


            fileWriter.append("001102;"+annio+";0"+mes+";01;03;"+empleadoanterior.getPlanilla().substring(4,8)+";"+String.valueOf(f.format(sumamontoRecontratotal)));
//            fileWriter.append("ffffffhhhhhh");
            fileWriter.append("/////"+mes);
            fileWriter.append(SALTO_LINEA);
            fileWriter.append(textocuerpo);
            
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