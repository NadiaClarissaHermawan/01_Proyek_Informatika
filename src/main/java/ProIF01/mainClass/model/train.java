package ProIF01.mainClass.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
