package br.com.eadsimple.model.game.to.operate;

import br.com.eadsimple.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Question extends AbstractEntity {

    private String question;
    private String corretAnswer;
    @OneToMany(mappedBy = "question")
    private List<Answers> answers;
    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String getCorretAnswer() {
        return corretAnswer;
    }

    public void setCorretAnswer(String corretAnswer) {
        this.corretAnswer = corretAnswer;
    }

    private Level getLevel() {
        return level;
    }

    private void setLevel(Level level) {
        this.level = level;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}

