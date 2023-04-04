/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import FinalProject.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kavya
 */
public class Books_Sell {
    
    private int SN;
    private String Title;
    private String Author;
    private String Publisher;
    private String Genre;
    private int QuantityforSell;
    private ArrayList<Books> BooksRegistered = new ArrayList<>();

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

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setQuantityforSell(int QuantityforSell) {
        this.QuantityforSell = QuantityforSell;
    }
    
    public int getSN() {
        return SN;
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

    public int getQuantityforSell() {
        return QuantityforSell;
    }
    
    
    //to add a new book information in Books_Sell Table
    public String addNewBooktoSell(int sn, String title, String author, String publisher, String genre, int quantityforsell)
    {
        this.SN = sn;
        this.Title= title;
        this.Author = author;
        this.Publisher = publisher;
        this.Genre = genre;
        this.QuantityforSell= quantityforsell;
        String result = "";
        Connection connection = null;
        String sql = "INSERT INTO Books_Sell VALUES (?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
           pstmt.setInt(1,sn);
           pstmt.setString(2, title);
           pstmt.setString(3, author);
           pstmt.setString(4, publisher);
           pstmt.setString(5, genre);
           pstmt.setInt(6, quantityforsell);
           pstmt.executeUpdate();
           result= "Book to sell saved successfully.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
   
        //to search for a Book with Title of the book from Books table
    public String searchBookSellTitle(String title) {
        String info = "No selled books with that title.";
        String sql = "SELECT * FROM Books_Sell WHERE Title = ?";
        String n = title;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1,n);
        
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                info = rs.getString("SN") + ", " + rs.getString("Title") + ", " + rs.getString("Author") + ", " + rs.getString("Publisher") + ", " + rs.getString("Genre") + ", " + rs.getString("QuantityforSell");
            }
            return info;
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }
        return info;
    }
    
    public String searchBookSellSN(int id) {
        String info = "No selled books found with that SN.";
        String sql = "SELECT * FROM Books_Sell WHERE SN = ?";
        int n = id;
        try (
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,n);
        
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next())
            {
                info = rs.getString("SN") + ", " + rs.getString("Title") + ", " + rs.getString("Author") + ", " + rs.getString("Publisher") + ", " + rs.getString("Genre") + ", " + rs.getString("QuantityforSell");
            }
            return info;
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return info;
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
