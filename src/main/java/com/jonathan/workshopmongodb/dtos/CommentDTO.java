package com.jonathan.workshopmongodb.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    private String text;
    private Date dare;
    private AuthorDTO author;

    public CommentDTO(){}

    public CommentDTO(String text, Date dare, AuthorDTO author) {
        this.text = text;
        this.dare = dare;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDare() {
        return dare;
    }

    public void setDare(Date dare) {
        this.dare = dare;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
