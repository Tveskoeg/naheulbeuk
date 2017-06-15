package com.meujeu.julien.naheulbeuk.table.items;

import com.meujeu.julien.naheulbeuk.commons.Constants;

/**
 * Created by Julien on 14/06/2017.
 */

public class Arme extends Stuff {
    public Arme(String nom, String prix, String protection, String malus, String bonus, String rupture, int subcat) {
        super(nom, prix, protection, malus, bonus, rupture, subcat);
        this.categorie = Constants.CAT_ARMES;
        this.prOuDgts = "DGTS : " + prOuDgts;
    }
}
