package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Koneksi {
    private Connection connect;
    private Statement db=null;
    private String database = "ilhambayu_07065";
    
    public Koneksi(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Class Driver Ditemukan");
            try{
               connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ilhambayu_07065","bayu");
               System.out.println("Koneksi Database Sukses");
            } catch (SQLException se){
                System.out.println("Koneksi Database Gagal : " + se);
            }
        } catch (ClassNotFoundException err){
            System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan pada :" + err);
        }
    }
       
    public ResultSet GetData(String sql){
        try{
            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println(sql);
            return db.executeQuery(sql);
        } catch (SQLException e){
            return null;
        }
    }
    
    public int ManipulasiData(String sql){
        try{
            System.out.println(sql);
            db = connect.createStatement();
            return db.executeUpdate(sql);
        } catch (SQLException e){
            return 0;
        }
    }

}
