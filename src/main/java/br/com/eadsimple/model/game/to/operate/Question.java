package br.com.eadsimple.model.game.to.operate;

import br.com.eadsimple.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question extends AbstractEntity {

    private String question;
    private String a, b, c, d;
    private String corretAnswer;
    @ManyToOne
    @JoinColumn(name="level_id", referencedColumnName="id")
    private Level level;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getCorretAnswer() {
        return corretAnswer;
    }

    public void setCorretAnswer(String corretAnswer) {
        this.corretAnswer = corretAnswer;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}

