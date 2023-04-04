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
import java.util.ArrayList;

/**
 *
 * @author hashemim
 */
public class Controller {

   
    private static Controller controllerObject;
    Student studentModel = new Student();
    Books booksModel = new Books();
    IssuedBooks issuedBooksModel=new IssuedBooks();
    Books_Sell bookSellModel =  new Books_Sell();
    
    private static Controller instance;
    private Controller() {
         
    }
    
    public static Controller getInstance() {
        if(controllerObject == null) {
           controllerObject = new Controller();
        }
         return controllerObject;
    }
    
    
    //connecting to database Library.db and making 3 tables - Books, Students and IssuedBooks
    public static void connectDB(){
          Connection connection = null;
        try
        {
          connection = DriverManager.getConnection("jdbc:sqlite:Library.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  

          statement.executeUpdate("DROP TABLE IF EXISTS Books");
          statement.executeUpdate("DROP TABLE IF EXISTS Students");
          statement.executeUpdate("DROP TABLE IF EXISTS IssuedBooks");
          statement.executeUpdate("DROP TABLE IF EXISTS Books_Sell");
//          statement.executeUpdate("DROP TABLE IF EXISTS Users");

          statement.executeUpdate("CREATE TABLE Books (SN INT PRIMARY KEY, Title STRING NOT NULL, Author STRING NOT NULL, Publisher STRING NOT NULL, Price FLOAT NOT NULL, Quantity INT, Issued INT, AddedDate DATE)");
          statement.executeUpdate("CREATE TABLE Students (StudentId int PRIMARY KEY, Name String NOT NULL, Contact String NOT NULL)");
          statement.executeUpdate("CREATE TABLE IssuedBooks (Id INTEGER PRIMARY KEY AUTOINCREMENT, SN INT, StId INT, Status String, IssueDate DATE, FOREIGN KEY (SN) REFERENCES Books(SN) ON DELETE CASCADE,FOREIGN KEY (StId) REFERENCES Students(StudentId) ON DELETE CASCADE)");
          statement.executeUpdate("CREATE TABLE Books_Sell (SN INT PRIMARY KEY, Title STRING NOT NULL, Author STRING NOT NULL, Publisher STRING NOT NULL, Genre String NOT NULL, QuantityforSell INT)");
          //          statement.executeUpdate("CREATE TABLE Users (UserId int PRIMARY KEY, User String NOT NULL, Password String NOT NULL)");
          
          statement.executeUpdate("INSERT INTO Books VALUES(123456,'Clean Code','Robert Martin','Pearson',31.19,3,2,'2012-04-02 01:42:37')");
          statement.executeUpdate("INSERT INTO Books VALUES(654321,'Pragmatic Programmer','David Thomas','Addison Wesley Professional',39.99,10,4,'2014-03-16 14:12:40')");
          statement.executeUpdate("INSERT INTO Books VALUES(987654,'Introduction to Algorithms','T Cormen','Third Edition',123.99,5,1,'2020-10-13 09:32:56')");
          statement.executeUpdate("INSERT INTO Books VALUES(753852,'Programming Concepts','T Cormen','Larousse',74.99,5,1,'2020-10-13 09:32:56')");
          statement.executeUpdate("INSERT INTO Books VALUES(456951,'Web services','D Rinfret','Pearson',75.99,3,1,'2022-10-13 09:32:56')");
          statement.executeUpdate("INSERT INTO Students VALUES(111,'Roberto Beniz','5148123456')");
          statement.executeUpdate("INSERT INTO Students VALUES(211,'Kavya Katariya','5146542365')");
          statement.executeUpdate("INSERT INTO Students VALUES(311,'Agrim Deshwal','4382347865')");
//          statement.executeUpdate("INSERT INTO Users VALUES(1,'Lib','123')");
//          statement.executeUpdate("INSERT INTO User VALUES(2,'Stu','456')");
//          statement.executeUpdate("INSERT INTO User VALUES(3,'Sup','789')");
          statement.executeUpdate("INSERT INTO IssuedBooks VALUES(1,123456,456,'Borrowed','2021-12-23 10:04:50')");
          //statement.executeUpdate("INSERT INTO IssuedBooks VALUES(2,654321,311,'Agrim Deshwal','4382347865','2022-03-14 08:34:42')"); 
          statement.executeUpdate("INSERT INTO Books_Sell VALUES(654321,'Pragmatic Programmer','David Thomas','Addison Wesley Professional','Education','10')");
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            System.err.println(e.getMessage());
          }
        }
    }
    
    
    
    
    public String addNewStudent(int id, String name, String contact) {  
        return studentModel.addNewStudent(id,name,contact);
    }
    
     public String saveNewBook(int sn,String title,String author,String pub,String genre,String fDate)
    {
       return booksModel.addNewBook(sn,title,author,pub,genre,fDate);
    }
     
     public String addNewBooktoSell(int sn,String title,String author,String pub,String genre,int quantity)
    {
       return bookSellModel.addNewBooktoSell(sn,title,author,pub,genre,quantity);
    }
    
    public String saveIssueBook(int SN,int StId, String status, String frmtDate) {
        return issuedBooksModel.addIssueBook(SN,StId, status,frmtDate);      
    }
    
    public String returnIssueBook(int id) {
        return issuedBooksModel.returnIssueBook(id);      
    }
    
     public String searchStudent(int id) {                                            
        return studentModel.searchStudent(id);
    }
    
     public String searchBookTitle(String title) {                                            
        return booksModel.searchBookTitle(title);
    }
     
    public String searchBookSN(int id) {                                            
        return booksModel.searchBookSN(id);
    }
    
    public String searchBookAuthor(String author) {                                            
        return booksModel.searchBookAuthor(author);
    }
    public String searchBookPublisher(String publisher) {                                            
        return booksModel.searchBookPublisher(publisher);
    }
     
    public String searchIssuedBooks() {                                            
        return issuedBooksModel.searchIssuedBooks();
    }
    
    public String searchIssuedBooksID(int id) {                                            
        return issuedBooksModel.searchIssuedBooksID(id);
    }
    
     public String searchBookSellTitle(String title) {                                            
        return bookSellModel.searchBookSellTitle(title);
    }
     
    public String searchBookSellSN(int id) {                                            
        return bookSellModel.searchBookSellSN(id);
    }
    
}