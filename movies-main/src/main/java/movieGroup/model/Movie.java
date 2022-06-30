package movieGroup.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {
    
    @Column
    private String name;

    @Column
    private String director;

    @Column
    private Integer duration;

    @Column
    private Integer year;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName(){
        return name;
    }
    public void setName(String name){ this.name = name; }

    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }

    public Integer getDuration(){ return duration; }
    public void setDuration(Integer duration){ this.duration = duration; }

    public Integer getYear(){ return year; }
    public void setYear(Integer year){ this.year = year; }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", id=" + id +
                '}';
    }
}
