package ru.graduation.model;


import ru.graduation.HasId;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity implements HasId {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    protected AbstractBaseEntity() {
    }

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), id);
    }

    public int hashCode() {
        return id == null ? 0 : id;
    }
}
