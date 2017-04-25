/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salaryonhand;

/**
 *
 * @author Soft
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SalaryOnHand {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Connection conn = null;
     String driverName = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaryOnHand.class.getName()).log(Level.SEVERE, null, ex);
        }
     String serverName = "HP-Pc";
     String serverPort = "1521";
     String sid = "XE";
     String url = "jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
     String userName = "Sangeethanan";
     String passWord = "2015084";
        try {
            conn = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Sucessfully connected to database");
        } catch (SQLException ex) {
            Logger.getLogger(SalaryOnHand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Company");
            while(rs.next()){
                String c_Name = rs.getString(1).toString();
                String c_Address = rs.getString(2).toString();
                String act = rs.getString(3).toString();
                String u_Name = rs.getString(4).toString();
                String p_Word = rs.getString(5).toString();
                System.out.println(c_Name+""+c_Address+""+act+""+u_Name+""+p_Word);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryOnHand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
