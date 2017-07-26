package com.testtask.conference.model;
import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "scedule"
        ,
        uniqueConstraints= @UniqueConstraint(columnNames={"datetime", "room_id"})
)
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    //@Column(name = "lecture_id")
     @OneToOne
    @JoinColumn(name = "id")
    private Lecture lecture;
    //@Column(name = "room_id")
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "datetime")
    private String datetime;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "lecture=" + lecture +
                "room=" + room +
                ", datetime=" + datetime +
                '}';
    }
}
