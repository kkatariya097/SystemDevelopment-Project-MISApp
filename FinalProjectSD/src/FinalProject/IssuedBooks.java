/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author rober
 */
public class IssuedBooks {
    private int Id;
    private int SN;
    private int StudentId;
    private String Status;
    private String IssueDate;

    public int getId() {
        return Id;
    }

    public int getSN() {
        return SN;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String getStatus() {
        return Status;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public void setIssueDate(String IssueDate) {
        this.IssueDate = IssueDate;
    }

    public String addIssueBook(int SN, int StID, String status, String frmtDate) {
        String result = "";
        Connection connection = null;
        String sql = "INSERT INTO IssuedBooks(SN, StId, Status, IssueDate) VALUES (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, SN);
            pstmt.setInt(2, StID);
            pstmt.setString(3, status);
            pstmt.setString(4, frmtDate);
            pstmt.executeUpdate();
            result = "Issue book saved successfully.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
        
        }

    
     public String searchIssuedBooks() {
        String info = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            Statement st = conn.createStatement();
            st.setQueryTimeout(30);
            ResultSet rs  = st.executeQuery("SELECT * FROM IssuedBooks");
            while(rs.next())
            {
                info = rs.getString("Id") + ", " + rs.getString("SN") + ", " + rs.getString("StId") + ", " + rs.getString("Status") + ", " + rs.getString("IssueDate") + "\n";
            }
            return info;
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "No issued books found.";
        }
     
     public String searchIssuedBooksID(int id) {
        String info = "No issued books found with that id.";
        String completInfo = "";
        String sql = "SELECT * FROM IssuedBooks WHERE StId = ?";
        int n = id;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,n);
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                completInfo = completInfo + rs.getString("Id") + ", " + rs.getString("SN") + ", " + rs.getString("StId") + ", " + rs.getString("Status") + ", " + rs.getString("IssueDate") + "\n";
                info = completInfo;
            }
            return info;
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return info;
    }
     
     
     public String returnIssueBook(int id) {
        String result = "Book not returned.";
        Connection connection = null;
        String status = "Returned";
        String sql = "UPDATE IssuedBooks SET Status='"+status+"' WHERE Id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            result = "Book returned successfully.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    
    
}
