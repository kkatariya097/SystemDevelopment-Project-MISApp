/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author hashemim
 */
public class Student extends User{
    private String Contact;
    private ArrayList<Student> studentsRegistered = new ArrayList<>();
    
    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public void setId(int StudentId) {
        super.id = StudentId;
    }

    @Override
    public void setName(String Name) {
        super.name = Name;
    }
    
    @Override
    public String getName() {
        return super.name;
    }
    
    @Override
    public void setContact(String Contact) {
        super.contact = Contact;
    }

    @Override
    public String getContact() {
        return super.contact;
    }


      public String addNewStudent(int id, String name, String contact) {
        Connection connection = null;
        String result = "";
        String sql = "INSERT INTO Students VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, contact);
            pstmt.executeUpdate();
            result= "Student saved successfully.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public String searchStudent(int id) {
        String info = "Not student found with that ID.";
        //Connection conn = null;
        String sql = "SELECT * FROM students WHERE studentId = ?";
        int n = id;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,n);
            //
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                info = rs.getString("StudentId") + ", " + rs.getString("Name") + ", " + rs.getString("Contact");
            }
            return info;
   
            }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return info;
        }

}
