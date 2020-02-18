package com.example.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity                  // for persistence java class
@Table(name = "note")    //annotation is used to provide the details of the table that this entity will be mapped to
@EntityListeners(AuditingEntityListener.class)  //annotation is used for automated population
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
//annotation used for Serializing and Deserializing Java objects to and from JSON

// table note model
//id        : Primary Key with Auto Increment.
//title     : The title of the Note. (NOT NULL field)
//content   : Note’s content. (NOT NULL field)
//createdAt : Time at which the Note was created.
//updatedAt : Time at which the Note was updated.


public class Note implements Serializable {

    @Id  //annotation is used to define the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") //annotation used to define the column name
    private Long id;

    @NotBlank  // annotation used to validate that the annotated field in not null or empty
    @Column(name = "title")
    private String title;

    @NotBlank  // annotation used to validate that the annotated field in not null or empty
    @Column(name = "content")
    private String content;

    @Column(name = "createat", nullable = false, updatable = true) //annotation used to provide properties of column.
    @Temporal(TemporalType.TIMESTAMP)
    //annotation used to converts the date and time values from Java Object to compatible database type and vice versa.
    @CreatedDate
    private Date createdat;

    @Column(name = "updateat", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedat;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
}
