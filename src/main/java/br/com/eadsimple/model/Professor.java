package br.com.eadsimple.model;

import javax.persistence.Entity;

@Entity
public class Professor extends AbstractEntity {
    String name;
    String matricula;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
