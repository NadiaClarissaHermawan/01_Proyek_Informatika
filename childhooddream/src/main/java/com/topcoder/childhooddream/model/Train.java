package com.topcoder.childhooddream.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.AUTO = auto increment.
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "[distance-between-stop]")
    private String distancebetweenstop;
    @Column(name = "[max-speed]")
    private String maxspeed;
    @Column(name = "[sharing-tracks]")
    private Boolean sharingtracks;
    @Column(name = "[grade-crossing]")
    private Boolean gradecrossing;
    @Column(name = "[train-frequency]")
    private String trainfrequency;
    @Column(name = "amenities")
    private String amenities;

    //must-have empty constructor
    public Train(){}

    public Train(Long id, String name, String description, String distancebetweenstop, String maxspeed, Boolean sharingtracks, Boolean gradecrossing, String trainfrequency, String amenities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.distancebetweenstop = distancebetweenstop;
        this.maxspeed = maxspeed;
        this.sharingtracks = sharingtracks;
        this.gradecrossing = gradecrossing;
        this.trainfrequency = trainfrequency;
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", distancebetweenstop='" + distancebetweenstop + '\'' +
                ", maxspeed='" + maxspeed + '\'' +
                ", sharingtracks=" + sharingtracks +
                ", gradecrossing=" + gradecrossing +
                ", trainfrequency='" + trainfrequency + '\'' +
                ", amenities='" + amenities + '\'' +
                '}';
    }
}