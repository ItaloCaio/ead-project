package br.com.eadsimple.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ActivityAssigned extends AbstractEntity{

    @OneToMany(mappedBy = "activityAssigned")
    private List<ActivityReceived> activityReceiveds;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class aClassActivity;

    public List<ActivityReceived> getActivityReceiveds() {
        return activityReceiveds;
    }

    public void setActivityReceiveds(List<ActivityReceived> activityReceiveds) {
        this.activityReceiveds = activityReceiveds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Class getaClassActivity() {
        return aClassActivity;
    }

    private void setaClassActivity(Class aClassActivity) {
        this.aClassActivity = aClassActivity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
