package utilities;

import java.sql.*;

public class DBUtils {

    //connection
    //statement
    //con ve statement kapatma

    //com.mysql.jdbc.Driver
//oracle.jdbc.driver.OracleDriver
//org.postgresql.Driver
//com.microsoft.sqlserver.jdbc.SQLServerDrive
//org.sqlite.JDBC

    private static Connection connection;
    private static Statement statement;

    //1. adim connection olusturma

    public static Connection connectionOlustur(String hostname, String databaseismi, String username, String password){

        //1.adim drivere kaydol
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //connection olustur

        //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi
        String url="jdbc:postgresql://"+hostname+":5432/"+databaseismi;

        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    public static Statement statementOlustur (){

        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
    public static void connectionStatementKapat(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
