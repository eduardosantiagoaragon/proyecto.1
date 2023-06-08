package org.example;

import java.sql.*;

import org.sqlite.JDBC;

public class DemoConexion {
    public static void main(String[] args) {
        String db_url = "jdbc:sqlite:JDBCDE.db";
        Connection conexion = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(db_url);
            Statement stm = conexion.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM DEPORTES EXTREMOS;");
            while (rst.next()){
                System.out.println(rst.getString(1) + "" + rst.getString(2));
            }
            conexion.close();
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
