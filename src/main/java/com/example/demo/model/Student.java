package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(
            name = "id",
            updatable = false
    )
    @GeneratedValue
    private long id;

    private String name;

    @Transient
    private int age;

    @Column(
            name = "birth_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDate birthDate;

    private String email;

    @OneToMany(mappedBy = "student")
    private Collection<Book> books;


    public void addBook(final Book book) {
        books.add(book);
        book.setStudent(this);
    }


    public Student() {
    }

    public Student(final long id, final String name,
                   final LocalDate birthDate, final String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Student(final String name,
                   final LocalDate birthDate, final String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(final Collection<Book> books) {
        this.books = books;
    }


    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate dateOfBirth) {
        this.birthDate = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }
}
