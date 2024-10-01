package com.ant_btv.model;

import javax.persistence.*;
import java.util.List;

// Port class
@Entity
@Table(name = "ports")
public class Port {
    @Id
    private String id;
    private boolean locked;
    private boolean selected;
    private String alignment;
    private String parentNode;

    @Embedded
    private Coordinates coords;

    @ElementCollection
    @CollectionTable(name = "links", joinColumns = @JoinColumn(name = "port_id"))
    private List<String> links;

    private String libId;

    // Getters and Setters
}
