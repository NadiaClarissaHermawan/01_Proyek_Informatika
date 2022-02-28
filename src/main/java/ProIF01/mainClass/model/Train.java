package ProIF01.mainClass.model;

import javax.persistence.*;

@Entity
@Table(name="trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.AUTO = auto increment
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "distance_between_stop")
    private String distance_between_stop;
    @Column(name = "max_speed")
    private String max_speed;
    @Column(name = "sharing_tracks")
    private boolean sharing_tracks;
    @Column(name = "grade_crossing")
    private boolean grade_crossing;
    @Column(name = "train_frequency")
    private String train_frequency;
    @Column(name = "amenities")
    private String amenities;

    //must-have empty constructor
    public Train(){}

    public Train (String name, String description, String distance_between_stop, String max_speed, boolean sharing_tracks, boolean grade_crossing, String train_frequency, String amenities){
        this.name = name;
        this.description = description;
        this.distance_between_stop = distance_between_stop;
        this.max_speed = max_speed;
        this.sharing_tracks = sharing_tracks;
        this.grade_crossing = grade_crossing;
        this.train_frequency = train_frequency;
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

    public String getDistance_between_stop() {
        return distance_between_stop;
    }

    public void setDistance_between_stop(String distance_between_stop) {
        this.distance_between_stop = distance_between_stop;
    }

    public String getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(String max_speed) {
        this.max_speed = max_speed;
    }

    public boolean isSharing_tracks() {
        return sharing_tracks;
    }

    public void setSharing_tracks(boolean sharing_tracks) {
        this.sharing_tracks = sharing_tracks;
    }

    public boolean isGrade_crossing() {
        return grade_crossing;
    }

    public void setGrade_crossing(boolean grade_crossing) {
        this.grade_crossing = grade_crossing;
    }

    public String getTrain_frequency() {
        return train_frequency;
    }

    public void setTrain_frequency(String train_frequency) {
        this.train_frequency = train_frequency;
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
                ", distance_between_stop='" + distance_between_stop + '\'' +
                ", max_speed='" + max_speed + '\'' +
                ", sharing_tracks=" + sharing_tracks +
                ", grade_crossing=" + grade_crossing +
                ", train_frequency='" + train_frequency + '\'' +
                ", amenities='" + amenities + '\'' +
                '}';
    }
}
