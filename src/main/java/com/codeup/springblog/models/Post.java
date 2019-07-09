package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;
//
//    @Column(nullable = false, name = "author_email")
//    private String authorEmail;

    @ManyToOne
    @JoinColumn(name= "user_id", referencedColumnName = "id")
    private User author;

    public Post() { }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }

//    public String getAuthorEmail() {
//        return authorEmail;
//    }
//
//    public void setAuthorEmail(String authorEmail) {
//        this.authorEmail = authorEmail;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

