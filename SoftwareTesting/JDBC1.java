package SoftwareTesting;

import java.util.*;
import java.sql.*;
class JDBC2 {
    Connection conn;
    Statement smt;
    ResultSet rs;
    public JDBC2() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void selectAll() {
        try {
            smt = conn.createStatement();
            rs = smt.executeQuery("Select * from Flight");
            while(rs.next()) {
                int id = rs.getInt(1);
                String fnum = rs.getString(2);
                String aline = rs.getString(3);
                String dairport = rs.getString(4);
                String aairport = rs.getString(5);
                String date = rs.getString(6);
                System.out.println("ID: "+id+", Flight Number: "+fnum+", Airline: "+aline+", Departure Airport: "+dairport+", Arrival Airport: "+aairport+", Departure Time: "+date);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void insert(int id,String fnum, String aline, String dairport, String aairport, String data) {
        System.out.println("Flight record inserted successfully.");
        try {
            PreparedStatement psmt = conn.prepareStatement("Insert into Flight(flight_id,flight_number,airline,departure_airport,arrival_airport,departure_time) values(?,?,?,?,?,?)");
            psmt.setInt(1,id);
            psmt.setString(2,fnum);
            psmt.setString(3,aline);
            psmt.setString(4,dairport);
            psmt.setString(5,aairport);
            psmt.setString(6,data);
            psmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        System.out.println("Flight record deleted successfully.");
        try {
            PreparedStatement psmt = conn.prepareStatement("Delete from Flight where id=?");
            psmt.setInt(1,id);
            psmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void update(int id,String fnum, String aline, String dairport, String aairport, String data) {
        System.out.println("Flight record updated successfully.");
        try {
            PreparedStatement psmt = conn.prepareStatement("UPDATE Flight SET flight_number=?, airline=?, departure_airport=?, arrival_airport=?, departure_time=? WHERE flight_id=?");
            psmt.setString(1,fnum);
            psmt.setString(2,aline);
            psmt.setString(3,dairport);
            psmt.setString(4,aairport);
            psmt.setString(5,data);
            psmt.setInt(6,id);
            psmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
class JDBC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JDBC2 obj = new JDBC2();
        int n = sc.nextInt();
        if(n == 3) {
            obj.selectAll();
        }
        else if(n == 1) {
            int id = sc.nextInt();
            sc.nextLine();
            String fnum = sc.nextLine();
            String aline = sc.nextLine();
            String dairport = sc.nextLine();
            String aairport = sc.nextLine();
            String date = sc.nextLine();
            obj.insert(id,fnum,aline,dairport,aairport,date);
            obj.selectAll();
        }
        else if(n == 2) {
            int id = sc.nextInt();
            sc.nextLine();
            String fnum = sc.nextLine();
            String aline = sc.nextLine();
            String dairport = sc.nextLine();
            String aairport = sc.nextLine();
            String date = sc.nextLine();
            obj.update(id,fnum,aline,dairport,aairport,date);
            obj.selectAll();
        }
        else if(n == 3) {
            int id = sc.nextInt();
            obj.delete(id);
            obj.selectAll();
        }
        else {
            System.out.print("Invalid operation number. Please try again.");
        }
    }
}