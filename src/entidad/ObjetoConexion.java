package entidad;

import java.sql.Connection;

public class ObjetoConexion {
    private static Conexion sql;
    private static Conexion mysql;
    private static Conexion oracle;

    public static Conexion getMysql() {
        return mysql;
    }
    public static Conexion getOracle() {
        return oracle;
    }
    public static Conexion getSql() {
        return sql;
    }
    public Connection conectarSQL() {
        try {
            sql = new Conexion("127.0.0.1","1433","pegaso","sa","Srp007","SQL");
            boolean estado=sql.conectarBD();
            if(estado){
            System.out.println("CONECTADO CORRECTAMENTE");
            return sql.getCnx();
            }else{
            System.out.println("ERROR AL CONECTAR");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getCause());
            return null;
        }
    }
    public  Connection conectarMYSQL() {
        try {
            mysql = new Conexion("127.0.0.1", "3306", "pegas", "root","", "MYSQL");
            boolean estado=mysql.conectarBD();
            if(estado){
            System.out.println("CONECTADO CORRECTAMENTE");
            return mysql.getCnx();
            }else{
            System.out.println("ERROR AL CONECTAR");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getCause());
            return null;
        }
    }
    public static Connection conectarORACLE() {
        try {
            oracle = new Conexion("127.0.0.1", "1521", "xe", "sys", "oracle", "ORACLE");
            boolean estado=oracle.conectarBD();
            if(estado){
            System.out.println("CONECTADO CORRECTAMENTE");
            return oracle.getCnx();
            }else{
            System.out.println("ERROR AL CONECTAR");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getCause());
            return null;
        }
    }
}
