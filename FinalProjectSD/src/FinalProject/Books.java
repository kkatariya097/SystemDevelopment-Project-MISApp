/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author hashemim
 */
public class Books {

    private int SN;
    private String Title;
    private String Author;
    private String Publisher;
    private String Genre;
    private int Quantity;
    private int Issued;
    private String Date;
    private ArrayList<Books> BooksRegistered = new ArrayList<>();

    
    //all Getters() and setters()
    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public void setPrice(String Genre) {
        this.Genre = Genre;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setIssued(int Issued) {
        this.Issued = Issued;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getGenre() {
        return Genre;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getIssued() {
        return Issued;
    }

    public String getDate() {
        return Date;
    }
    
    //to add a new book information in Books Table
    public String addNewBook(int sn, String title, String author, String publisher, String genre, String fDate)
    {
        this.SN = sn;
        this.Title= title;
        this.Author = author;
        this.Publisher = publisher;
        this.Genre= genre;
        this.Date= fDate;
        String result = "";
        Connection connection = null;
        String sql = "INSERT INTO Books VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
           pstmt.setInt(1,sn);
           pstmt.setString(2, title);
           pstmt.setString(3, author);
           pstmt.setString(4, publisher);
           pstmt.setString(5, genre);
           pstmt.setString(8,fDate);
           pstmt.executeUpdate();
           result= "Book saved successfully.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
   
     
    //to search for a Book with Title of the book from Books table
    public String searchBookTitle(String title) {
        String info = "No books with that title.";
        String sql = "SELECT * FROM books WHERE title = ?";
        String n = title;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1,n);
        
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                info = rs.getString("SN") + ", " + rs.getString("Title") + ", " + rs.getString("Author") + ", " + rs.getString("Publisher") + ", " + rs.getString("Price") + ", " + rs.getString("Quantity") + ", " + rs.getString("Issued") + ", " + rs.getString("AddedDate");
            }
            return info;
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }
        return info;
    }
    
    public String searchBookSN(int id) {
        String info = "No book found with that SN.";
        String sql = "SELECT * FROM books WHERE SN = ?";
        int n = id;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,n);
        
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                info = rs.getString("SN") + ", " + rs.getString("Title") + ", " + rs.getString("Author") + ", " + rs.getString("Publisher") + ", " + rs.getString("Price") + ", " + rs.getString("Quantity") + ", " + rs.getString("Issued") + ", " + rs.getString("AddedDate");
            }
            return info;
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return info;
        }
    
    public String searchBookAuthor(String author) {
        String info = "No book found with that author.";
        String completInfo = "";
        String sql = "SELECT * FROM books WHERE author = ?";
        String n = author;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1,n);
        
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                completInfo = completInfo + rs.getString("SN") + ", " + rs.getString("Title") + ", " + rs.getString("Author") + ", " + rs.getString("Publisher") + ", " + rs.getString("Price") + ", " + rs.getString("Quantity") + ", " + rs.getString("Issued") + ", " + rs.getString("AddedDate") + "\n";
                info =  completInfo;
            }
            return info;
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return info;
        }
    
    
    public String searchBookPublisher(String publisher) {
        String info = "No book found with that publisher.";
        String completInfo = "";
        String sql = "SELECT * FROM books WHERE publisher = ?";
        String n = publisher;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1,n);
        
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                completInfo = completInfo + rs.getString("SN") + ", " + rs.getString("Title") + ", " + rs.getString("Author") + ", " + rs.getString("Publisher") + ", " + rs.getString("Price") + ", " + rs.getString("Quantity") + ", " + rs.getString("Issued") + ", " + rs.getString("AddedDate") + "\n";
                info =  completInfo;
            }
            return info;
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return info;
        }
    
    
    
    
    
    
    
    
    
}
