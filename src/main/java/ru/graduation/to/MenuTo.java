package ru.graduation.to;

import ru.graduation.model.Menu;

import java.time.LocalDate;
import java.util.Map;

public class MenuTo extends BaseTo{

        private int restoranId;

        private LocalDate operdate;

        private Map<String, String> delishes;

        public MenuTo() {

        }

        public MenuTo(Integer id,  LocalDate operdate, Map<String, String> delishes) {
            super(id);
            this.operdate = operdate;
            this.delishes = delishes;
        }

        public Menu castToMenu(){
            return new Menu(this.id,  this.operdate, this.delishes);
        }

        public int getRestoranId() {
            return restoranId;
        }

        public void setRestoranId(int restoranId) {
            this.restoranId = restoranId;
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

