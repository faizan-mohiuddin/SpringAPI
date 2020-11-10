package Models;

import java.sql.*;

public class Random {
    Connection con;
    Statement stmt;
    PreparedStatement prestmt;
    String insert_sql = "INSERT INTO random (ColA, ColB) VALUES (?, ?)";

    public Random(){
        try{

            this.con = DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2375559", "sql2375559", "yZ5*gB3*");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public ResultSet getAll(){
        try {
            this.stmt = this.con.createStatement();
            ResultSet rs = this.stmt.executeQuery("select * from random");
            return rs;
        }catch(Exception e){
            ResultSet rs = null;
            return rs;
        }
    }

    public String insert(String ColA, int ColB){
        // Insert into the DB
        try{
            this.prestmt = this.con.prepareStatement(this.insert_sql);
            this.prestmt.setString(1, ColA);
            this.prestmt.setInt(2, ColB);

            int rows = this.prestmt.executeUpdate();
            if(rows > 0){
                return "Row added to 'random'";
            }else{
                throw new Exception("Nothing added to DB");
            }
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
            return "An error occured, nothing has been added to 'random' table";
        }
    }

    public void shutdown(){
        try{
        con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
