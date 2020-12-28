package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConUtil {
    public static String message="";
    public static String re="";
       public static void mySqlCon(String dbUserName,String dbPassword,String dbName)
       {

           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
           Connection con=null;
           String url="jdbc:mysql://localhost:3306/"+dbName+"?characterEncoding=utf8&allowMultiQueries=true&serverTimezone=CST";
           try {
               con= DriverManager.getConnection(url,dbUserName,dbPassword);
               message= String.valueOf(con.getCatalog());
               re="1";
           } catch (SQLException throwables) {
               message=throwables.getMessage();
               re="0";
               throwables.printStackTrace();
           }

       }
}
