package Models;

import java.sql.*;

public class Random {
    public Random(){
        System.out.println("MADE IT HERE");
        try{

            System.out.println("Step 0");

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Step 1");

            Connection con = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306", "sql2375559", "yZ5*gB3*");

            System.out.println("Step 2");

            Statement stmt = con.createStatement();

            System.out.println("Step 3");

            ResultSet rs = stmt.executeQuery("select * from random");

            System.out.println("Step 4");

            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getInt(2));
            }
            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
