
 


package Logica;

import java.sql.Connection;
import java.sql.DriverManager;





public class ObjetoConexion {
     Connection  conet=null;
       
    public Connection conexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conet=DriverManager.getConnection("jdbc:sqlserver://192.168.10.10:1433;databaseName=pegasus;integratedSecurity=true");
           //JOptionPane.showMessageDialog(null,"conectado");
        }catch(Exception e) {
            e.printStackTrace();
           
        }
          return conet;
    }
}
///para visual fox     
    /*public Connection conexion(){
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conet=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Visual FoxPro Driver};SourceType=DBF;SourceDB=D:\\Data;");
           //JOptionPane.showMessageDialog(null,"conectado");
        } catch (Exception e) {
            e.printStackTrace();
           
        }
          return conet;
    }*/
    

