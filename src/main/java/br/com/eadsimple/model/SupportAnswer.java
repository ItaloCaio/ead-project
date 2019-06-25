package br.com.eadsimple.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SupportAnswer extends AbstractEntity {

    private String answer;
    @ManyToOne
    @JoinColumn(name = "support_id", referencedColumnName = "id")
    private Support support;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userAnswer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public User getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(User userAnswer) {
        this.userAnswer = userAnswer;
    }
}
