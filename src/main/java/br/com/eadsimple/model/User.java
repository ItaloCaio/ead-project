package br.com.eadsimple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    @OneToMany(mappedBy = "professor")
    private List<Class> classList;
    @OneToMany(mappedBy = "user")
    private List<Stream> streamList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private List<Class> getClassList() {
        return classList;
    }

    private void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    private List<Stream> getStreamList() {
        return streamList;
    }

    private void setStreamList(List<Stream> streamList) {
        this.streamList = streamList;
    }
}
