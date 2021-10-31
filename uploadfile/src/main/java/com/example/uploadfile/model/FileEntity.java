package com.example.uploadfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
    private Long id;

    private String name;

    private String type;

    private String description;

    private byte[] content;

    public FileEntity() {
    }

    public FileEntity(Long id, String name, String type, String description, byte[] content) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
    
    

}