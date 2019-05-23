package br.com.eadsimple.model.game.to.operate;

import br.com.eadsimple.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Level extends AbstractEntity {

    private int number;
    private String name;
    @OneToMany(mappedBy = "level")
    private List<Question> myQuestions;
    private boolean complete;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<Question> getQuestions() {
        return myQuestions;
    }

    public void setQuestions(List<Question> questions) {
        this.myQuestions = myQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
