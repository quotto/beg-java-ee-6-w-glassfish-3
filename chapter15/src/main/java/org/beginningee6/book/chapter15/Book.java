package org.beginningee6.book.chapter15;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQuery(name=Book.FIND_ALL,query="SELECT b FROM Book b")
public class Book {
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String descripption) {
        this.description = descripption;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getNbOfPage() {
        return nbOfPage;
    }
    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }
    public Boolean getIllustrations() {
        return illustrations;
    }
    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }
    @Id @GeneratedValue
    private Long id;
    @Column(nullable=false)
    private String title;
    private Float price;
    @Column(length = 2000)
    private String description;
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustrations;

    public static final String FIND_ALL = "Book.findAllBooks";
}
