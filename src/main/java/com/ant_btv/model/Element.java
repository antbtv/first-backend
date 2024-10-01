package com.ant_btv.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "elements")
public class Element {

    @Id
    private String id;

    private boolean locked;
    private boolean selected;

    @Embedded
    private Coordinates coords;

    @Embedded
    private Dimensions dimensions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "element_id")
    private List<Port> ports;

    private int hour;
    private String voltageLevelId;
    private String substationId;
    private String transmissionLineId;
    private String libEquipmentId;
    private String name;

    @ElementCollection
    @CollectionTable(name = "fields", joinColumns = @JoinColumn(name = "element_id"))
    @MapKeyColumn(name = "field_name")
    @Column(name = "field_value")
    private Map<String, String> fields;

    public String getId() {
        return id;
    }

    public int getHour() {
        return hour;
    }

    public String getName() {
        return name;
    }
}

// Coordinates class
@Embeddable
class Coordinates {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

// Dimensions class
@Embeddable
class Dimensions {
    private int width;
    private int height;

}

