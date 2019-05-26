package br.com.eadsimple.model;

import br.com.eadsimple.model.AbstractEntity;
import br.com.eadsimple.model.Class;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stream extends AbstractEntity {

    String content;
    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class aClass;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Class getaClass() {
        return aClass;
    }

    private void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
