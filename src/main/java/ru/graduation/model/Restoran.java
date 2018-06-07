package ru.graduation.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table
public class Restoran extends AbstractNamedEntity {

    private String description;

    public Restoran() {
    }

    public Restoran(Integer id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
