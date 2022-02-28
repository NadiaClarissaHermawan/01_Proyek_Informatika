package ProIF01.mainClass.model;

import javax.persistence.*;

@Entity
@Table(name="trains")
public class train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.AUTO = auto increment
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "distanceBetweenStop")
    private String distanceBetweenStop;
    @Column(name = "maxSpeed")
    private String maxSpeed;
    @Column(name = "sharingTracks")
    private boolean sharingTracks;
    @Column(name = "gradeCrossing")
    private boolean gradeCrossing;
    @Column(name = "trainFrequency")
    private String trainFrequency;
    @Column(name = "amenities")
    private String amenities;

    //must-have empty constructor
    public train(){}

    public train(String name, String description, String distanceBetweenStop, String maxSpeed, boolean sharingTracks, boolean gradeCrossing, String trainFrequency, String amenities){
        this.name = name;
        this.description = description;
        this.distanceBetweenStop = distanceBetweenStop;
        this.maxSpeed = maxSpeed;
        this.sharingTracks = sharingTracks;
        this.gradeCrossing = gradeCrossing;
        this.trainFrequency = trainFrequency;
        this.amenities = amenities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isSharingTracks() {
        return sharingTracks;
    }

    public void setSharingTracks(boolean sharingTracks) {
        this.sharingTracks = sharingTracks;
    }

    public boolean isGradeCrossing() {
        return gradeCrossing;
    }

    public void setGradeCrossing(boolean gradeCrossing) {
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
