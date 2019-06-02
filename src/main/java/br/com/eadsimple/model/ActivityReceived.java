package br.com.eadsimple.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ActivityReceived extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private ActivityAssigned activityAssigned;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userActivity;

    private ActivityAssigned getActivityAssigned() {
        return activityAssigned;
    }

    private void setActivityAssigned(ActivityAssigned activityAssigned) {
        this.activityAssigned = activityAssigned;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUserActivity() {
        return userActivity;
    }

    public void setUserActivity(User userActivity) {
        this.userActivity = userActivity;
    }
}
