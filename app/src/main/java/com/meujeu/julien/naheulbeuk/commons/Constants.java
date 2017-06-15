package com.meujeu.julien.naheulbeuk.commons;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Julien on 11/06/2017.
 */

public class Constants {
    public static final Hashtable<Integer, String> SOUS_CATEGORIE = new Hashtable<Integer, String>() {{
        put(0, "Recuperation");
        put(1, "Lames courtes");
        put(2, "Lames 1 main");
        put(3, "Lames 2 mains");
        put(4, "Haches 1 main");
        put(5, "Haches de jet");
        put(6, "Haches 2 mains");
        put(7, "Marteaux et masses 1 main");
        put(8, "Marteaux 2 mains");
        put(9, "Lances et piques");
        put(10, "Javelots");
        put(11, "Arcs");
        put(12, "Fleches pour arc");
        put(13, "Arbaletes");
        put(14, "Carreaux arbaletes");
        put(15, "Armes bizarres");
        put(116, "Vestes, cottes matelassées (torse, bras)");
        put(117, "Plastrons cuir (torse)");
        put(118, "Plastrons métal (torse)");
        put(119, "Accessoires métal (bras ou jambes)");
        put(120, "Cottes de maille (torse, bras)");
        put(121, "Casques et heaumes (tête)");
        put(122, "Gantelets/Bracelets (mains, avant-bras)");
        put(123, "Bottes, chaussures (pieds)");
        put(124, "Armures complètes (métal)");
        put(125, "Armures complètes (cuir)");
        put(126, "Armures complètes (légères)");
        put(127, "Armures complètes (tissu)");
        put(128, "Boucliers");
        put(129, "Protections pour semi-homme");
        put(130, "Protections pour gnôme");
        put(131, "Protections pour ogre");

    }};

    public static final int CAT_ARMES = 0;
    public static final int CAT_ARMES_MAGES = 1;
    public static final int CAT_ARMES_PRETRES = 2;
    public static final int CAT_ARMURES = 3;
    public static final int CAT_ARMURES_MAGES = 4;
    public static final int CAT_ARMURES_PRETRES = 5;
    public static final int CAT_LIVRES = 6;
    public static final int CAT_POTIONS_ETC = 7;
    public static final int CAT_ACCESSOIRES_MAGIQUES = 8;
    public static final int CAT_ACCESSOIRES_MAGIQUES_MAGES = 9;
    public static final int CAT_ACCESSOIRES_MAGIQUES_PRETRES = 10;
    public static final int SUBCAT_RECUPERATION = 0;
    public static final int SUBCAT_LAMES_COURTES = 1;
    public static final int SUBCAT_LAMES_1_MAIN = 2;
    public static final int SUBCAT_LAMES_2_MAINS = 3;
    public static final int SUBCAT_HACHES_1_MAIN = 4;
    public static final int SUBCAT_HACHES_DE_JET = 5;
    public static final int SUBCAT_HACHES_2_MAINS = 6;
    public static final int SUBCAT_MARTEAUX_ET_MASSES_1_MAIN = 7;
    public static final int SUBCAT_MARTEAUX_2_MAINS = 8;
    public static final int SUBCAT_LANCES_ET_PIQUES = 9;
    public static final int SUBCAT_JAVELOTS = 10;
    public static final int SUBCAT_ARCS = 11;
    public static final int SUBCAT_FLECHES_POUR_ARC = 12;
    public static final int SUBCAT_ARBALETES = 13;
    public static final int SUBCAT_CARREAUX_ARBALETE = 14;
    public static final int SUBCAT_ARMES_BIZARRES = 15;
    public static final int SUBCAT_PLASTRONS_TISSU = 116;
    public static final int SUBCAT_PLASTRONS_CUIR = 117;
    public static final int SUBCAT_PLASTRONS_METAL = 118;
    public static final int SUBCAT_ACCESSOIRES_METAL = 119;
    public static final int SUBCAT_PLASTRONS_COTTES_DE_MAILLE = 120;
    public static final int SUBCAT_CASQUE = 121;
    public static final int SUBCAT_GANTS = 122;
    public static final int SUBCAT_BOTTES = 123;
    public static final int SUBCAT_ARMURE_COMPLETE_METAL = 124;
    public static final int SUBCAT_ARMURE_COMPLETE_CUIR = 125;
    public static final int SUBCAT_ARMURE_COMPLETE_LEGERE = 126;
    public static final int SUBCAT_ARMURE_COMPLETE_TISSU = 127;
    public static final int SUBCAT_BOUCLIERS = 128;
    public static final int SUBCAT_PROTECTION_HOBBITS = 129;
    public static final int SUBCAT_PROTECTION_GNOMES = 130;
    public static final int SUBCAT_PROTECTION_OGRES = 131;
    public HashMap<Integer, String> CATEGORIES = new HashMap<Integer, String>() {{
        put(CAT_ARMES, "Armes");
        put(CAT_ARMES_MAGES, "Armes de mages");
        put(CAT_ARMES_PRETRES, "Armes de prêtres/paladins");
        put(CAT_ARMURES, "Armures");
        put(CAT_ARMURES_MAGES, "Armures - Mages");
        put(CAT_ARMURES_PRETRES, "Armures - Prêtes/Paladins");
        put(CAT_LIVRES, "Livres");
        put(CAT_POTIONS_ETC, "Potions, poisons, antidotes");
        put(CAT_ACCESSOIRES_MAGIQUES, "Accessoires magiques");
        put(CAT_ACCESSOIRES_MAGIQUES_MAGES, "Accessoires magiques - Mages");
        put(CAT_ACCESSOIRES_MAGIQUES, "Accessoires magiques - Prêtes/Paladins");
    }};
}
