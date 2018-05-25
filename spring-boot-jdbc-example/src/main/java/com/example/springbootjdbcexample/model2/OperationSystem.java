package com.example.springbootjdbcexample.model2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TESTERSJOURNAL_OPERATION_SYSTEM")
@JsonIgnoreType
public class OperationSystem extends RootObject {
    private static final long serialVersionUID = -9038497424476588580L;

    @Column(name = "NAME", nullable = false)
    protected String name;

//    @Lob рамс
    @Column(name = "DESCRIPTION")
    protected String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "OperationSystem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}