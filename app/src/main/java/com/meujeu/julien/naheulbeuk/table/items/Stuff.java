package com.meujeu.julien.naheulbeuk.table.items;

/**
 * Created by Julien on 11/06/2017.
 */

public class Stuff {
    protected String nom;
    protected String prix;
    protected String prOuDgts;
    protected String malus;
    protected String bonus;
    protected String rupture;
    protected int sousCategorie;
    protected int categorie;

    public Stuff(String nom, String prix, String protection, String malus, String bonus, String rupture, int subcat) {
        this.nom = nom;
        this.prix = prix + " PO";
        this.prOuDgts = protection;
        this.malus = malus;
        this.bonus = bonus;
        this.rupture = "RUP : " + rupture;
        this.sousCategorie = subcat;

    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPrOuDgts() {
        return prOuDgts;
    }

    public void setPrOuDgts(String prOuDgts) {
        this.prOuDgts = prOuDgts;
    }

    public String getMalus() {
        return malus;
    }

    public void setMalus(String malus) {
        this.malus = malus;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getRupture() {
        return rupture;
    }

    public void setRupture(String rupture) {
        this.rupture = rupture;
    }

    public int getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(int sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public String toString() {
        String str = nom + "\n" + prix + "\n" + prOuDgts + "\n" + malus + "\n" + bonus + "\n" + rupture;
        return str;
    }
}

