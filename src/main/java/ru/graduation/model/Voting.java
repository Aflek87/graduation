package ru.graduation.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Voting extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, insertable=false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu", nullable = false, insertable=false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    private LocalDateTime operDate;

    public Voting() {
    }

    public Voting(Integer id, User user, Menu menu, LocalDateTime operDate) {
        super(id);
        this.user = user;
        this.menu = menu;
        this.operDate = operDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public LocalDateTime getOperDate() {
        return operDate;
    }

    public void setMenuDate(Date menuDate) {
        this.operDate = operDate;
    }
}
