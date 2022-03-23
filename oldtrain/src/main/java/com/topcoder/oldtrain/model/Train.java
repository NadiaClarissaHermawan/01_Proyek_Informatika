package com.topcoder.oldtrain.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;


@Entity
@Table(name="trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "[distance-between-stop]")
    @JsonProperty(value="distance-between-stop")
    private String distancebetweenstop;
    @Column(name = "[max-speed]")
    @JsonProperty(value="max-speed")
    private String maxspeed;
    @Column(name = "[sharing-tracks]")
    @JsonProperty(value="sharing-tracks")
    private boolean sharingtracks;
    @Column(name = "[grade-crossing]")
    @JsonProperty(value="grade-crossing")
    private boolean gradecrossing;
    @Column(name = "[train-frequency]")
    @JsonProperty(value="train-frequency")
    private String trainfrequency;
    @Column(name = "amenities")
    private String amenities;

    //must-have empty constructor
    public Train(){}

    public Train(Long id, String name, String description, String distancebetweenstop, String maxspeed, boolean sharingtracks, boolean gradecrossing, String trainfrequency, String amenities) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistancebetweenstop() {
        return distancebetweenstop;
    }

    public void setDistancebetweenstop(String distancebetweenstop) {
        this.distancebetweenstop = distancebetweenstop;
    }

    public String getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(String maxspeed) {
        this.maxspeed = maxspeed;
    }

    public boolean isSharingtracks() {
        return sharingtracks;
    }

    public void setSharingtracks(boolean sharingtracks) {
        this.sharingtracks = sharingtracks;
    }

    public boolean isGradecrossing() {
        return gradecrossing;
    }

    public void setGradecrossing(boolean gradecrossing) {
        this.gradecrossing = gradecrossing;
    }

    public String getTrainfrequency() {
        return trainfrequency;
    }

    public void setTrainfrequency(String trainfrequency) {
        this.trainfrequency = trainfrequency;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}