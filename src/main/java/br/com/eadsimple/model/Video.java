package br.com.eadsimple.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Video extends AbstractEntity {

    private String video;
    private String title;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class aClass;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Class getaClass() {
        return aClass;
    }

    private void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
