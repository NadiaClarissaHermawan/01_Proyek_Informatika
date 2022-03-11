package ProIF01.mainClass.model;

import javax.persistence.*;

@Entity
@Table(name="trains")
public class train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.AUTO = auto increment.
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "distanceBetweenStop")
    private String distanceBetweenStop;
    @Column(name = "maxSpeed")
    private String maxSpeed;
    @Column(name = "sharingTracks")
    private Boolean sharingTracks;
    @Column(name = "gradeCrossing")
    private Boolean gradeCrossing;
    @Column(name = "trainFrequency")
    private String trainFrequency;
    @Column(name = "amenities")
    private String amenities;

    //must-have empty constructor
    public train(){}

    public train(String name, String description, String distanceBetweenStop, String maxSpeed, Boolean sharingTracks, Boolean gradeCrossing, String trainFrequency, String amenities){
        this.name = name;
        this.description = description;
        this.distanceBetweenStop = distanceBetweenStop;
        this.maxSpeed = maxSpeed;
        this.sharingTracks = sharingTracks;
        this.gradeCrossing = gradeCrossing;
        this.trainFrequency = trainFrequency;
        this.amenities = amenities;
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

    public String getDistanceBetweenStop() {
        return distanceBetweenStop;
    }

    public void setDistanceBetweenStop(String distanceBetweenStop) {
        this.distanceBetweenStop = distanceBetweenStop;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Boolean getSharingTracks() {
        return sharingTracks;
    }

    public void setSharingTracks(Boolean sharingTracks) {
        this.sharingTracks = sharingTracks;
    }

    public Boolean getGradeCrossing() {
        return gradeCrossing;
    }

    public void setGradeCrossing(Boolean gradeCrossing) {
        this.gradeCrossing = gradeCrossing;
    }

    public String getTrainFrequency() {
        return trainFrequency;
    }

    public void setTrainFrequency(String trainFrequency) {
        this.trainFrequency = trainFrequency;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", distanceBetweenStop='" + distanceBetweenStop + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", sharingTracks=" + sharingTracks +
                ", gradeCrossing=" + gradeCrossing +
                ", trainFrequency='" + trainFrequency + '\'' +
                ", amenities='" + amenities + '\'' +
                '}';
    }
}
