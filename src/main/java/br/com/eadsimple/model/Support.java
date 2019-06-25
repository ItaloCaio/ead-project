package br.com.eadsimple.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Support extends AbstractEntity {

    private String question;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userSupport;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public User getUserSupport() {
        return userSupport;
    }

    public void setUserSupport(User userSupport) {
        this.userSupport = userSupport;
    }
}
