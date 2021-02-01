package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    // schema book(isbn, author, student_id)

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator =
            "book_generator")
    @SequenceGenerator(
            name="book_generator",
            sequenceName = "book_seq",
            allocationSize = 1)
    private long isbn;

    @Column
    private String author;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;


    public long getIsbn() {
        return isbn;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(final Student student) {
        this.student = student;
    }
}
