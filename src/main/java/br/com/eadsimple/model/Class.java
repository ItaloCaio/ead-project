package br.com.eadsimple.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Class extends AbstractEntity {

    private String name;
    private String Description;
    @OneToMany(mappedBy = "aClass")
    private List<Stream> streams;
    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private User professor;
    @OneToMany(mappedBy = "aClass")
    private List<Video> videos;
    @OneToMany(mappedBy = "aClassActivity")
    private List<ActivityAssigned> activityAssigneds;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<ActivityAssigned> getActivityAssigneds() {
        return activityAssigneds;
    }

    public void setActivityAssigneds(List<ActivityAssigned> activityAssigneds) {
        this.activityAssigneds = activityAssigneds;
    }
}

