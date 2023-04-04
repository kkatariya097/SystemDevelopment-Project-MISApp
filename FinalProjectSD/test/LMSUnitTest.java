/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import FinalProject.Controller;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author rober
 */
public class LMSUnitTest {
    Controller controller = Controller.getInstance();
    
    public LMSUnitTest() {}
    //===== Test cases to test book methods =====
    @Test
    public void testSearchBooksSN1() {
        String result = controller.searchBookSN(123456);
        String expected = "123456, Clean Code, Robert Martin, Pearson, 31.19, 3, 2, 2012-04-02 01:42:37";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksSN2() {
        String result = controller.searchBookSN(223456);
        String expected = "No book found with that SN.";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksTitle1() {
        String result = controller.searchBookTitle("Clean Code");
        String expected = "123456, Clean Code, Robert Martin, Pearson, 31.19, 3, 2, 2012-04-02 01:42:37";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksTitle2() {
        String result = controller.searchBookTitle("Web development");
        String expected = "No books with that title.";
        assertEquals(expected, result);
    }

    @Test
    public void testSearchBooksAuthor1() {
        String result = controller.searchBookAuthor("Web development");
        String expected = "No book found with that author.";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksPublisher1() {
        String result = controller.searchBookPublisher("McCain");
        String expected = "No book found with that publisher.";
        assertEquals(expected, result);
    }
    
     @Test
    public void testAddBook1() {
        String result = controller.saveNewBook(489465,"Test case","Roberto", "Pearson","Education","2017-04-02 01:42:37");
        String expected = "Book saved successfully.";
        assertEquals(expected, result);
    }

    
    // ===== Test cases to test student methods =====
    @Test
    public void testSearchStudentId1() {
        String result = controller.searchStudent(111);
        String expected = "111, Roberto Beniz, 5148123456";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchStudentId2() {
        String result = controller.searchStudent(222);
        String expected = "Not student found with that ID.";
        assertEquals(expected, result);
    }
    
     @Test
    public void testAddStudent1() {
        String result = controller.addNewStudent(852,"Kavya","7596893526");
        String expected = "Student saved successfully.";
        assertEquals(expected, result);
    }
    
  
    // ===== Test cases to test issued books  methods =====
    @Test
    public void testSearchIssuedBooks1() {
        String result = controller.searchIssuedBooks();
        String expected = "2, 654321, 111, Borrowed, 2023-04-04 10:04:50\n";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchIssuedBooksID1() {
        String result = controller.searchIssuedBooksID(456);
        String expected = "1, 123456, 456, Borrowed, 2021-12-23 10:04:50\n";
        assertEquals(expected, result);
    }
    
     @Test
    public void testSearchIssuedBooksID2() {
        String result = controller.searchIssuedBooksID(789);
        String expected = "No issued books found with that id.";
        assertEquals(expected, result);
    }
    
     @Test
    public void testReturnIssuedBooks1() {
        String result = controller.returnIssueBook(1);
        String expected = "Book returned successfully.";
        assertEquals(expected, result);
    }
    
    @Test
    public void testAddIssueBook1() {
        String result = controller.saveIssueBook(654321,111, "Borrowed", "2023-04-04 10:04:50");
        String expected = "Issue book saved successfully.";
        assertEquals(expected, result);
    }
    
    // ===== Test cases to test book sell methods =====
    @Test
    public void testSearchBooksSellSN1() {
        String result = controller.searchBookSellSN(654321);
        String expected = "654321, Pragmatic Programmer, David Thomas, Addison Wesley Professional, Education, 10";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksSellSN2() {
        String result = controller.searchBookSellSN(223456);
        String expected = "No selled books found with that SN.";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksSellTitle1() {
        String result = controller.searchBookSellTitle("Pragmatic Programmer");
        String expected = "654321, Pragmatic Programmer, David Thomas, Addison Wesley Professional, Education, 10";
        assertEquals(expected, result);
    }
    
    @Test
    public void testSearchBooksSellTitle2() {
        String result = controller.searchBookSellTitle("Web development");
        String expected = "No selled books with that title.";
        assertEquals(expected, result);
    }
    
    @Test
    public void testAddBookSell1() {
        String result = controller.addNewBooktoSell(195673,"Test methods","Roberto", "Dawson Co","Education",13);
        String expected = "Book to sell saved successfully.";
        assertEquals(expected, result);
    }

    
}
