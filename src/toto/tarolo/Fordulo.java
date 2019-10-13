package toto.tarolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fordulo {
    private int ev;
    private int het;
    private int forduloAHeten;
    private LocalDate datum;
    private List<Talalat> talalatList;
    private List<Eredmeny> eredmenyList;

    public Fordulo() {
    }

    public int getEv() {
        return this.ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHet() {
        return this.het;
    }

    public void setHet(int het) {
        this.het = het;
    }

    public int getForduloAHeten() {
        return this.forduloAHeten;
    }

    public void setForduloAHeten(int forduloAHeten) {
        this.forduloAHeten = forduloAHeten;
    }

    public LocalDate getDatum() {
        return this.datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public List<Talalat> getTalalatList() {
        return this.talalatList;
    }

    public void setTalalatList(List<Talalat> talalatList) {
        this.talalatList = talalatList;
    }

    public List<Eredmeny> getEredmenyList() {
        return this.eredmenyList;
    }

    public void setEredmenyList(List<Eredmeny> eredmenyList) {
        this.eredmenyList = eredmenyList;
    }

    public void addEredmeny(Eredmeny eredmeny) {
        if (this.eredmenyList == null) {
            this.eredmenyList = new ArrayList();
        }

        this.eredmenyList.add(eredmeny);
    }

    public void addTalalat(Talalat talalat) {
        if (this.talalatList == null) {
            this.talalatList = new ArrayList();
        }

        this.talalatList.add(talalat);
    }
}