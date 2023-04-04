/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.ArrayList;

/**
 *
 * @author hashemim
 */
public class Librarian extends User{

//    private Books booksModel;
//    private Student studentsModel;
//    private ArrayList<Student> studentsRegistered = new ArrayList<>();
//    private ArrayList<Books> booksRegistered = new ArrayList<>();
//
//    public Librarian(Books booksModel) {
//        this.booksModel = booksModel;
//    }
//    
//     public Librarian(Student studentsModel) {
//        this.studentsModel = studentsModel;
//    }
    
    String contact;
    String email;
    
    @Override
    public int getId() {
        return super.id;
    }
    
    @Override
    public void setId(int SupplierId) {
        super.id = SupplierId;
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
    public String getEmail() {
        return super.email;
    }
     
    @Override
    public void setEmail(String Email) {
        super.email = Email;
    }
    
     @Override
    public void setContact(String Contact) {
        super.contact = Contact;
    }

    @Override
    public String getContact() {
        return super.contact;
    }

}
