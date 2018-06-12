package ru.graduation.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table
public class Menu extends AbstractBaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restoran", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @NotNull
    private Restoran restoran;

    private LocalDate operdate;

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @CollectionTable(name = "dish", joinColumns = @JoinColumn(name = "menu", insertable=false, updatable=false))
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name="price")
    @MapKeyColumn(name="name")
    private Map<String, String> delishes;

    public Menu() {

    }

    public Menu(Integer id,  LocalDate operdate, Map<String, String> delishes) {
        super(id);
        this.operdate = operdate;
        this.delishes = delishes;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public LocalDate getOperdate() {
        return operdate;
    }

    public void setOperdate(LocalDate dateMenu) {
        this.operdate = dateMenu;
    }

    public Map<String, String> getDelishes() {
        return delishes;
    }

    public void setDelishes(Map<String, String> delishes) {
        this.delishes = delishes;
    }
}
