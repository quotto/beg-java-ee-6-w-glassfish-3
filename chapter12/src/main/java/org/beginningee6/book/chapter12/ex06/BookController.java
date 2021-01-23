package org.beginningee6.book.chapter12.ex06;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.beginningee6.book.chapter12.Book;
import org.beginningee6.book.chapter12.BookEJB;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ManagedBean(name = "myBookController06")
@RequestScoped
public class BookController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private BookEJB bookEJB;

    @ManagedProperty(value = "#{initController06.defaultBook}")
    private Book book = new Book();

    private List<Book> bookList = new ArrayList<Book>();

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doCreateBook() {
        book = bookEJB.createBook(book);
        bookList = bookEJB.findBooks();
        return "listBooks.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}