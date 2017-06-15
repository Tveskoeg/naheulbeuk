package com.meujeu.julien.naheulbeuk;

import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meujeu.julien.naheulbeuk.adapters.StuffListAdapter;
import com.meujeu.julien.naheulbeuk.commons.Constants;
import com.meujeu.julien.naheulbeuk.table.items.Arme;
import com.meujeu.julien.naheulbeuk.table.items.Armure;
import com.meujeu.julien.naheulbeuk.table.items.Stuff;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends ExpandableListActivity implements ExpandableListView.OnChildClickListener {
    StuffListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fillDisplayList(-1);
        linkButtons();


    }

    private void linkButtons() {
        final Button buttonAll = findViewById(R.id.button_all);
        buttonAll.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View v) {
                                             fillDisplayList(-1);
                                         }
                                     }
        );
        final Button buttonWeapons = findViewById(R.id.button_weapons);
        buttonWeapons.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View v) {
                                                 fillDisplayList(Constants.CAT_ARMES);
                                             }
                                         }
        );
        final Button buttonArmor = findViewById(R.id.button_armor);
        buttonArmor.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               fillDisplayList(Constants.CAT_ARMURES);
                                           }
                                       }
        );
    }

    private void fillDisplayList(int categorie) {
        ArrayList<Stuff> stuffs = new ArrayList<Stuff>();
        fillItemList(stuffs);
        LinkedHashMap<String, List<Stuff>> hm = getHashmap(stuffs, categorie);
        final ExpandableListView yourListView = this.getExpandableListView();

// get data from the table by the ListAdapter

        mAdapter = new StuffListAdapter(this, new ArrayList<String>(hm.keySet()), hm);
        yourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFromList = (yourListView.getItemAtPosition(position).toString());

                Log.d("STATE", selectedFromList);
            }
        });
        yourListView.setAdapter(mAdapter);

    }

    private LinkedHashMap<String, List<Stuff>> getHashmap(ArrayList<Stuff> stuffs, int categorie) {
        LinkedHashMap<String, List<Stuff>> hm = new LinkedHashMap<String, List<Stuff>>();
        ArrayList<Integer> keys = new ArrayList<Integer>(Constants.SOUS_CATEGORIE.keySet());
        for (int i = Constants.SOUS_CATEGORIE.keySet().size() - 1; i >= 0; i--) {
            ArrayList<Stuff> tmp = new ArrayList<>();
            for (Stuff s : stuffs) {
                if (s.getSousCategorie() == (keys.get(i)) && (categorie == -1 || s.getCategorie() == categorie)) {
                    tmp.add(s);
                }
            }
            if (tmp.size() > 0)
                hm.put(Constants.SOUS_CATEGORIE.get(keys.get(i)), tmp);
        }
        return hm;
    }


    private void fillItemList(ArrayList<Stuff> stuff) {

        stuff.add(new Arme("Hache 2 mains grossière", "100", "1D+5", "AT-3 PRD-4", "", "1 à 3", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache 2 mains correcte", "200", "1D+6", "AT-2 PRD-4", "", "1 à 3", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache 2 mains bonne qualité", "400", "2D+2", "AT-2 PRD-3", "COU+1", "1 à 3", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache de combat cimérienne à double affûtage", "600", "2D+4", "AT-2 PRD-2", "COU+1 CHA+1", "1 à 2", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache 2 mains d'artisan renommé", "1000", "2D+5", "AT-2 PRD-2", "", "1 à 2", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache de Marave Moriaque", "1500", "2D+5", "AT-1 PRD-1", "", "1 à 2", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache 2 mains Durandil(TM)", "2000", "2D+5", "AT-1 PRD-1", "COU+2 CHA+2", "1 à 2", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache Monstrueuse des Berserkers", "3000", "2D+7", "AT-2 PRD-2", "COU+4", "Non", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache de Bataille Syldérienne", "3000", "2D+6", "AT-1 PRD-1", "COU+4", "Non", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache de Feu de Blizdand (ench.)", "5000", "2D+6 (feu)", "AT-1 PRD-1", "COU+2 CHA+3", "Non", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache Démoniaque de Makkedoh (relique)", "10000", "2D+8", "CHA-2", "COU+4", "Non", Constants.SUBCAT_HACHES_2_MAINS));
        stuff.add(new Arme("Hache d'Annihilation de Nyarlapalathep (ench.)", "25000", "2D+10", "CHA-4", "AT/PRD+3 COU+6", "Non", Constants.SUBCAT_HACHES_2_MAINS));

        stuff.add(new Arme("Bonne branche – gourdin – pied de chaise ", "0", "1D", "PRD-2 CHA-1", "", "1 à 4", Constants.SUBCAT_RECUPERATION));
        stuff.add(new Arme("Branche moisie   ", "0", "1D-2", "AT/PRD-3 CHA-2", "", "1 à 5", Constants.SUBCAT_RECUPERATION));
        stuff.add(new Arme("Manche de pioche  ", "0", "1D+1", "PRD-1", "", "1 à 3", Constants.SUBCAT_RECUPERATION));
        stuff.add(new Arme("Chaise – Tabouret  ", "0", "1D+1", "AT/PRD-3 CHA-1", "", "1 à 5", Constants.SUBCAT_RECUPERATION));
        stuff.add(new Arme("Chandelier du Colonel Moutarde  ", "0", "1D+2", "AT/PRD-2 CHA-1", "", "1 à 4", Constants.SUBCAT_RECUPERATION));
        stuff.add(new Arme("Tisonnier  ", "0", "1D+2", "AT/PRD-1", "", "1 à 3", Constants.SUBCAT_RECUPERATION));
        stuff.add(new Arme("Tisonnier chauffé au rouge  ", "0", "1D+4", "AT/PRD-2", "", "1 à 3", Constants.SUBCAT_RECUPERATION));

        stuff.add(new Arme("Couteau de poche du grand-père  ", "1", "1D", "AT/PRD-3 CHA-2", "", "1 à 5", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Couteau de qualité  ", "5", "1D", "AT/PRD-3 CHA-1", "", "1 à 4", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Poignard de base**  ", "10", "1D+1", "AT-2 PRD-4 CHA-1 AD-1*", "", "1 à 5", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Poignard de qualité**  ", "35", "1D+1", "AT-1 PRD-4", "", "1 à 3", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Poignard Durandil(TM)**  ", "400", "1D+2", "AT-1 PRD-3", "CHA+1 COU+1 AD+2*", "1 à 2", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Poignard d'Excellence de Mirfilu** (ench.) ", "500", "1D+2/1D+3*", "AT-1 PRD-3", "AD+4* CHA+1", "Non", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Poignard sacrificiel de Xeloss (ench.)  ", "500", "1D+2", "AT-1 PRD-3", "CHA+2 COU+2", "Non", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Dague de base  ", "15", "1D+2", "AT-1 PRD-2 CHA-1", "", "1 à 5", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Dague bonne qualité  ", "50", "1D+2", "PRD-2", "", "1 à 4", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Dague de luxe  ", "200", "1D+2", "PRD-2", "AT+1 CHA+1", "1 à 3", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Dague de Tzinntch (ench.)  ", "600", "1D+2", "PRD-2", "AT+1 CHA+1 +malédiction", "1 à 2", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Dague elfique des temps anciens (ench.) ", "700", "1D+3", "PRD-2", "AT+1 CHA+2 COU+2", "Non", Constants.SUBCAT_LAMES_COURTES));
        stuff.add(new Arme("Dague Durandil(TM)   ", "600", "1D+3", "PRD-2", "AT+2 CHA+1 COU+1", "1 à 2", Constants.SUBCAT_LAMES_COURTES));


        stuff.add(new Arme("Épée, rapière, sabre 1 main perrave  ", "50", "1D+3", "CHA-1 COU-1 PRD-1", "", "1 à 4", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Épée, rapière, sabre 1 main correcte  ", "100", "1D+3", "PRD-1", "", "1 à 3", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Épée, rapière, sabre 1 main bonne qualité ", "200", "1D+4", "", "", "1 à 3", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Épée, rapière, sabre 1 main d'artisan renommé ", "500", "1D+5", "", "AT/PRD+1", "1 à 2", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Rapière de noble pour frimer, poignée plaqué or ", "800", "1D+3", "", "COU+1 CHA+2", "1 à 3", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Épée, rapière, sabre 1 main Durandil(TM)  ", "1000", "1D+5", "", "AT/PRD+1 CHA+1 COU+1", "1 à 2", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Lame d'excellence de Glonzg (ench.)  ", "1500", "1D+4", "", "AT/PRD+2", "Non", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Sabre de Guy le Batailleur (relique)  ", "2000", "1D+5", "", "COU+3 AT/PRD+1", "Non", Constants.SUBCAT_LAMES_1_MAIN));
        stuff.add(new Arme("Sabre en Trithil de Blaidh Le Diurnambule ", "6000", "1D+6", "", "COU+2 CHA+2 AT/PRD+2", "Non", Constants.SUBCAT_LAMES_1_MAIN));


        stuff.add(new Arme("Épée 2 mains de base  ", "100", "1D+5", "AT-3 PRD-4", "", "1 à 4", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Épée 2 mains correcte  ", "200", "1D+6", "AT-2 PRD-4", "", "1 à 3", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Épée 2 mains bonne qualité  ", "400", "2D+2", "AT-2 PRD-3", "COU+1", "1 à 3", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Épée 2 mains d'artisan renommé  ", "1000", "2D+4", "AT-2 PRD-2", "COU+1 CHA+1", "1 à 2", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Épée 2 mains Durandil(TM)  ", "2000", "2D+5", "AT-1 PRD-1", "COU+2 CHA+2", "1 à 2", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Grande Claymore de Wallace  ", "2500", "2D+5", "PRD-1", "COU+4", "1 à 2", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Éventreuse de Kjeukien-la-mule (relique) ", "3000", "2D+7", "AT-1 PRD-1", "COU+4", "Non", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Épée de Justice Légendaire (ench.)  ", "5000", "2D+5", "AT-1 PRD-1", "COU+8", "Non", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Epée vorpale +3 (dommage), deux mains (ench.)  ", "6000", "2D+6", "AT-1 PRD-1", "COU+2 CHA+3", "Non", Constants.SUBCAT_LAMES_2_MAINS));
        stuff.add(new Arme("Epée runique 2 mains +8 Souldrinker (ench.) ", "30000", "2D+10", "", "AT/PRD+3 PR+4 COU+4", "Non", Constants.SUBCAT_LAMES_2_MAINS));


        stuff.add(new Arme("Hache 1 main daubesque  ", "50", "1D+3", "CHA-1 PRD-2", "Nain : AT+1", "1 à 4", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache 1 main correcte  ", "100", "1D+3", "PRD-2 / Nain : PRD-1", "Nain : AT+1", "1 à 3", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache 1 main bonne qualité  ", "200", "1D+4", "PRD-1 (sauf Nain)", "Nain : AT+2 COU+1", "1 à 3", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache 1 main d'artisan renommé  ", "500", "1D+5", "PRD-1 (sauf Nain)", "Nain : AT/PRD+2 COU+1", "1 à 2", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache 1 main d'artisan Nain - 1 main pour Nain ", "700", "1D+4", "", "Nain : AT/PRD+1 COU+1", "1 à 2", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache 1 main Durandil(TM) - 1 main pour Nain ", "1000", "1D+5", "PRD-1 (sauf Nain)", "AT/PRD+1 CHA+1 COU+1", "1 à 2", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache de décapitation des Orcs (ench.) ", "1200", "1D+5", "PRD-1 (sauf Nain)", "AT/PRD+2 (contre orcs)", "1 à 2", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache Barbelée Mauvaise (ench.)  ", "2600", "1D+7", "CHA-2", "AT/PRD+1", "Non", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache de Goltor (relique) – 1 main pour Nain ", "3000", "1D+6", "", "AT/PRD+1 COU+3", "Non", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache Démembreuse (ench.)  ", "5000", "1D+7", "", "AT/PRD+2 CHA+1 COU+1", "Non", Constants.SUBCAT_HACHES_1_MAIN));
        stuff.add(new Arme("Hache Miraculeuse du Blizzard (ench.) ", "10000", "1D+7 (glace)", "", "AT/PRD+2 CHA+2 COU+2", "Non", Constants.SUBCAT_HACHES_1_MAIN));

        stuff.add(new Arme("Hache de jet quelconque** – 1 main pour Nain ", "200", "1D+3", "AT-2 PRD-5 (c.a.c.)", "", "1 à 3", Constants.SUBCAT_HACHES_DE_JET));
        stuff.add(new Arme("Hache de jet des pirates mauves**  ", "300", "1D+4", "AT-2 PRD-4 (c.a.c.)", "", "1 à 3", Constants.SUBCAT_HACHES_DE_JET));
        stuff.add(new Arme("Hache de jet Durandil(TM)** - 1 main pour Nain ", "400", "1D+5", "AT-1 PRD-4 (c.a.c.)", "AD+2* COU+1", "1 à 2", Constants.SUBCAT_HACHES_DE_JET));
        stuff.add(new Arme("Hache de Jet du Grand Forgeron** (relique, Nain)  ", "2000", "1D+6", "", "AD+3* COU+2", "Non", Constants.SUBCAT_HACHES_DE_JET));

        stuff.add(new Arme("Marteau, masse 1 main daubesque  ", "50", "1D+3", "CHA-1 PRD-2", "Nain : AT+1", "1 à 4", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau, masse 1 main correcte  ", "100", "1D+3", "PRD-2 / Nain : PRD-1", "Nain : AT+1", "1 à 3", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau, masse 1 main bonne qualité ", "200", "1D+4", "PRD-1 (sauf Nain)", "Nain : AT+2 COU+1", "1 à 3", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau, masse 1 main d'artisan renommé ", "500", "1D+5", "PRD-1 (sauf Nain)", "Nain : AT/PRD+2 COU+1", "1 à 2", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau, masse d'artisan nain – 1 main pour Nain ", "600", "1D+4", "", "Nain : AT/PRD+2 COU+1", "1 à 2", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau 1 main Durandil(TM) – 1 main pour Nain ", "1000", "1D+5", "PRD-1 (sauf Nain)", "AT/PRD+1 CHA+1 COU+1", "1 à 2", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Masse PAF(TM)   ", "1000", "1D+5", "PRD-1", "AT/PRD+1 CHA+1 COU+1", "1 à 2", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Masse du Destin (ench.)  ", "2000", "1D+5", "PRD-1", "Ignore 2 points de PR", "1 à 2", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau de Précision (ench.)  ", "2000", "1D+5", "PRD-2 (sauf Nain)", "Chances de critique : +1", "1 à 2", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau des Pères Septeurs (relique)  ", "3000", "1D+8", "PRD-1 (sauf Nain)", "COU+3", "Non", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau Légendaire de Jambfer (relique pour Nain) ", "3000", "1D+6", "", "AT/PRD+1 COU+3", "Non", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));
        stuff.add(new Arme("Marteau Équilibré de Martembur (ench. pour Nain) ", "10000", "1D+7", "", "AT/PRD+2 CHA+2 COU+2", "Non", Constants.SUBCAT_MARTEAUX_ET_MASSES_1_MAIN));


        stuff.add(new Arme("Marteau 2 mains minable  ", "100", "1D+5", "AT-3 PRD-4", "", "1 à 4", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Marteau 2 mains correct  ", "200", "1D+6", "AT-2 PRD-4", "", "1 à 3", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Marteau 2 mains bonne qualité  ", "400", "2D+2", "AT-2 PRD-3", "COU+1", "1 à 3", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Marteau de Guerre Syldérien  ", "600", "2D+4", "AT-2 PRD-2", "COU+1 CHA+1", "1 à 2", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Marteau 2 mains d'artisan renommé  ", "1000", "2D+5", "AT-2 PRD-2", "", "1 à 2", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Marteau de Baston des Moriacs  ", "1500", "2D+5", "AT-1 PRD-1", "", "1 à 2", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Marteau 2 mains Durandil(TM)  ", "2000", "2D+5", "AT-1 PRD-1", "COU+2 CHA+2", "1 à 2", Constants.SUBCAT_MARTEAUX_2_MAINS));
        stuff.add(new Arme("Gurstaker (relique, Nain uniquement)  ", "5000", "2D+8", "AT-1 PRD-1", "COU+2 CHA+2", "Non", Constants.SUBCAT_MARTEAUX_2_MAINS));


        stuff.add(new Arme("Lance de base  ", "20", "1D+3", "AT-1 PRD-2", "", "1 à 5", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Lance de qualité  ", "60", "1D+4", "PRD-2", "", "1 à 3", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Lance d'Assaut des Milices de Glargh  ", "150", "1D+4", "PRD-1", "", "1 à 3", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Lance de bataille des Drows  ", "500", "1D+5", "", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Lance Barbelée des troupes de Gzor  ", "500", "1D+6", "CHA-1 AT/PRD-1", "", "1 à 2", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Pique de défense  ", "150", "1D+4", "AT-1", "", "1 à 4", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Pique Légendaire de Kolegram (relique)  ", "2000", "1D+6", "", "CHA+1 PRD+2", "Non", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Hallebarde de Milicien  ", "200", "1D+6", "AT-2 PRD-4", "", "1 à 4", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Hallebarde des Défenseurs de Waldorg  ", "400", "2D+2", "AT-2 PRD-3", "COU+1", "1 à 2", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Hallebarde des Tueurs de Géants  ", "1500", "2D+5", "AT-1 PRD-1", "", "1 à 2", Constants.SUBCAT_LANCES_ET_PIQUES));
        stuff.add(new Arme("Trident de Kjaniouf  ", "500", "1D+5", "AT-1", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_LANCES_ET_PIQUES));


        stuff.add(new Arme("Javelot \"maison\"**   ", "***", "1D", "AD-2* CHA-2", "Nain : AD-3*", "1 à 5", Constants.SUBCAT_JAVELOTS));
        stuff.add(new Arme("Javelot de base**  ", "15", "1D+2", "CHA-1 AD-1*", "Nain : AD-3*", "1 à 4", Constants.SUBCAT_JAVELOTS));
        stuff.add(new Arme("Javelot de qualité**  ", "40", "1D+2", "", "Nain : AD-3*", "1 à 3", Constants.SUBCAT_JAVELOTS));
        stuff.add(new Arme("Javelot de chasse des Moriacs**  ", "200", "1D+3", "", "AD+1* Nain : AD-3*", "1 à 2", Constants.SUBCAT_JAVELOTS));
        stuff.add(new Arme("Javelot du Tangorodrigue (relique) **  ", "1000", "1D+5", "", "AD+2* Nain : AD-3*", "Non", Constants.SUBCAT_JAVELOTS));

        stuff.add(new Arme("Arc court de basse qualité**  ", "30", "1D+2", "AD-2* CHA-1", "", "1 à 5", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc court de qualité correcte**  ", "50", "1D+2", "", "", "1 à 4", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc long de basse qualité**  ", "50", "1D+3", "AD-2* CHA-1", "", "1 à 5", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc long de qualité correcte**  ", "80", "1D+3", "", "", "1 à 4", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc composite d'elfe sylvain (imitation)**  ", "200", "1D+4", "", "CHA+1", "1 à 3", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc long de luxe**  ", "300", "1D+3", "", "CHA+1 COU+1", "1 à 3", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc long des Drows**  ", "500", "1D+4", "", "CHA+1 AD+1*", "1 à 3", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc Ouvragé des Lunelbar**  ", "600", "1D+4", "", "CHA+3", "1 à 2", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc des Meuldors**  ", "800", "1D+4", "", "CHA+1 AD+1*", "1 à 2", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc Solide d'Unrienmôrn**  ", "1000", "1D+4", "", "CHA+1 AD+1* COU+2", "Non", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc composite d'elfe sylvain (véritable)**  ", "2000", "1D+5", "", "CHA+2 AD+2* COU+1", "Non", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc long de Yemisold + 2 dexterité (ench.)** ", "5000", "1D+6", "", "AD+3* CHA+2 (niveau 6+)", "Non", Constants.SUBCAT_ARCS));
        stuff.add(new Arme("Arc de Puissance des Syldériens**  ", "5000", "1D+8", "Min FO : 15", "", "Non", Constants.SUBCAT_ARCS));

        stuff.add(new Arme("Flèche de base  ", "0,5", "", "AD-1*", "", "1 à 5", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche de qualité  ", "2", "", "", "", "1 à 4", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Mauve des pirates  ", "5", "", "", "AD+1*", "1 à 4", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Noire des Drows  ", "8", "", "", "Degâts +1", "1 à 3", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche d'elfe sylvain \"La Meurtrière\"(TM)  ", "10", "", "", "Degâts +2", "1 à 3", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche d'elfe sylvain \"L'Agile\"(TM)  ", "10", "", "", "AD+2*", "1 à 3", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Barbelée des Ogres Chasseurs  ", "20", "", "", "Degâts +3", "1 à 3", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche de Blazing Fire (ench.)  ", "30", "", "", "Degâts +1 et feu + 1D", "1 à 2", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Hypodermique de Dlul (ench.)  ", "50", "", "", "Degâts = Sommeil", "1 à 2", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Lubrique de Slanoush (ench.)  ", "120", "", "", "Critique Organes gen.", "1 à 2", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Ophidienne de Tholsadûm (ench.)  ", "150", "", "", "AD+4* +poison 2D", "1 à 2", Constants.SUBCAT_FLECHES_POUR_ARC));
        stuff.add(new Arme("Flèche Malveillante de Khornettoh (ench.)  ", "150", "", "", "Degâts +4D", "1 à 2", Constants.SUBCAT_FLECHES_POUR_ARC));

        stuff.add(new Arme("Arbalète de gobelin**  ", "60", "1D+4", "AD-2*", "", "1 à 4", Constants.SUBCAT_ARBALETES));
        stuff.add(new Arme("Arbalète de qualité correcte**  ", "120", "1D+4", "", "", "1 à 3", Constants.SUBCAT_ARBALETES));
        stuff.add(new Arme("Arbalète d'artisan renommé**  ", "500", "1D+5", "", "AD+2*", "1 à 2", Constants.SUBCAT_ARBALETES));
        stuff.add(new Arme("Arbalète de Luxe pour frimeur**  ", "500", "1D+5", "", "AD+2* CHA+2", "1 à 2", Constants.SUBCAT_ARBALETES));
        stuff.add(new Arme("Arbalète Sauvage de Gzurulia**  ", "1000", "1D+7", "Min FO : 13", "AD+1* CHA+1 COU+1", "1 à 2", Constants.SUBCAT_ARBALETES));
        stuff.add(new Arme("Arbalète double de Vontorz (relique)**  ", "3000", "2D+10", "Temps recharg. doublé", "", "Non", Constants.SUBCAT_ARBALETES));

        stuff.add(new Arme("Carreau de base  ", "1", "", "AD-1*", "", "1 à 4", Constants.SUBCAT_CARREAUX_ARBALETE));
        stuff.add(new Arme("Carreau de qualité  ", "3", "", "", "", "1 à 3", Constants.SUBCAT_CARREAUX_ARBALETE));
        stuff.add(new Arme("Carreau de Dlul (ench.)  ", "80", "", "", "Degâts = Sommeil", "1 à 2", Constants.SUBCAT_CARREAUX_ARBALETE));
        stuff.add(new Arme("Carreau Vicelard de Slanoush (ench.)  ", "150", "", "", "Critique Organes gen.", "1 à 2", Constants.SUBCAT_CARREAUX_ARBALETE));
        stuff.add(new Arme("Carreau Maudit des Troupes de Gzor (ench.) ", "180", "", "", "AD+4* +poison 2D", "1 à 2", Constants.SUBCAT_CARREAUX_ARBALETE));
        stuff.add(new Arme("Carreau d'Assaut de Khornettoh (ench.)  ", "180", "", "", "Degâts +4D", "1 à 2", Constants.SUBCAT_CARREAUX_ARBALETE));

        stuff.add(new Arme("Sarbacane**  ", "5", "1+poison", "", "", "1 à 5", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Nunchaku  ", "50", "1D+1", "Min AD : 14 / PRD-4", "2 AT/assaut", "1 à 4", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Nunchaku de Brouzli  ", "200", "1D+3", "Min AD : 14 / PRD-4", "2 AT/assaut", "1 à 2", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Fléau Bourrinant des Moriacs  ", "500", "2D+2", "Min AD : 13 / PRD-4", "", "1 à 3", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Lance-pierre Mythique d'Hyshoul (relique)**  ", "500", "1D+3", "", "AD+1", "Non", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Faucille de la Démence  ", "1000", "1D+5", "", "AT/PRD+1 CHA+1 COU+1", "1 à 2", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Boomerang Stupéfiant de Mike Dundee**  ", "1000", "1D+2", "", "revient sauf dégâts", "Non", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Couperet du Bourreau Velu D'Ukkuh (relique) ", "2000", "2D+5", "CHA-2", "COU+4", "Non", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Flagelleur Malveillant  ", "3000", "1D+4", "Min AD : 12 / PRD=0", "Ignore 1 point de PR", "Non", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Triple Lacérateur à Déflection  ", "4000", "3D", "Min AD : 12 / PRD=0", "Ignore 1 point de PR", "Non", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Doubles Serres du Moine Tatoncouto (relique, ", "5000", "2D", "Min AD : 15", "2 AT/assaut – COU+3", "Non", Constants.SUBCAT_ARMES_BIZARRES));
        stuff.add(new Arme("Faux Léthale de Tormentor (relique, ench.) ", "10000", "2D+8", "Min AD : 15 / CHA-2", "", "Non", Constants.SUBCAT_ARMES_BIZARRES));


        stuff.add(new Armure("Gambison de base avec manches  ", "20", "2", "CHA-1", "", "1 à 4", Constants.SUBCAT_PLASTRONS_TISSU));
        stuff.add(new Armure("Veste toile renforcée avec manches  ", "30", "2", "", "", "1 à 5", Constants.SUBCAT_PLASTRONS_TISSU));
        stuff.add(new Armure("Gambison correct avec manches  ", "50", "2", "", "", "1 à 4", Constants.SUBCAT_PLASTRONS_TISSU));
        stuff.add(new Armure("Veste toile renforcée noire, pour voleur ", "100", "2", "", "AD+1 (discrétion)", "1 à 3", Constants.SUBCAT_PLASTRONS_TISSU));
        stuff.add(new Armure("Gambison luxe avec manches ", "100", "2", "", "CHA+1", "1 à 3", Constants.SUBCAT_PLASTRONS_TISSU));

        stuff.add(new Armure("Plastron de cuir de base  ", "30", "3", "CHA-1", "", "1 à 4", Constants.SUBCAT_PLASTRONS_CUIR));
        stuff.add(new Armure("Plastron de cuir bouilli correct  ", "50", "3", "", "", "1 à 4", Constants.SUBCAT_PLASTRONS_CUIR));
        stuff.add(new Armure("Plastron de cuir moulé sur mesure ", "100", "3", "", "AD+1", "1 à 3", Constants.SUBCAT_PLASTRONS_CUIR));
        stuff.add(new Armure("Plastron de cuir renforcé métal  ", "200", "4", "AD-1", "", "1 à 3", Constants.SUBCAT_PLASTRONS_CUIR));
        stuff.add(new Armure("Plastron de cuir luxe (renforcé métal et décoré) ", "500", "4", "AD-1", "CHA+1", "1 à 3", Constants.SUBCAT_PLASTRONS_CUIR));
        stuff.add(new Armure("Plastron de cuir luxe +2 force (ench. base 3)** ", "2000", "4", "", "CHA+1 FO+2", "1 à 2", Constants.SUBCAT_PLASTRONS_CUIR));
        stuff.add(new Armure("Plastron de cuir luxe Haut-Elfe +4 (ench. base 3)** ", "6000", "4", "Incompatible peau-verte", "CHA+1 AD+2 AT/PRD+1", "Non", Constants.SUBCAT_PLASTRONS_CUIR));

        stuff.add(new Armure("Plastron métal, lourd et grossier  ", "200", "4", "CHA-1 AD-1", "", "1 à 4", Constants.SUBCAT_PLASTRONS_METAL));
        stuff.add(new Armure("Plastron métal léger  ", "500", "4", "AD-1", "", "1 à 3", Constants.SUBCAT_PLASTRONS_METAL));
        stuff.add(new Armure("Plastron métal luxe (artisan nain)  ", "1000", "5", "", "CHA+1", "1 à 2", Constants.SUBCAT_PLASTRONS_METAL));
        stuff.add(new Armure("Plastron métal luxe + 2 force (ench. base 4)** ", "4000", "5", "", "CHA+1 FO+2", "Non", Constants.SUBCAT_PLASTRONS_METAL));

        stuff.add(new Armure("Jambières métal, lourdes et grossières ", "200", "1", "CHA-1 AD-1 MV-20%", "", "1 à 5", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Jambières métal légères  ", "500", "1", "AD-2", "", "1 à 3", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Jambières métal luxe (artisan nain) ", "1000", "1", "AD-1", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Jambières métal luxe + 1 dexterité (ench.) ", "3000", "1", "", "CHA+1 COU+1 AD+1", "Non", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Jambières métal luxe Protector(TM) (ench. base 1)** ", "4000", "2", "", "COU+2", "Non", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Brassières métal, lourdes et grossières ", "200", "1", "CHA-1 AD-2", "", "1 à 5", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Brassières métal légères  ", "500", "1", "AD-1", "", "1 à 3", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Brassières métal luxe (artisan nain) ", "1000", "1", "", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Brassières métal luxe + 1 force (ench.) ", "3000", "1", "", "CHA+1 COU+1 FO+1", "Non", Constants.SUBCAT_ACCESSOIRES_METAL));
        stuff.add(new Armure("Brassières métal luxe Protector(TM) (ench. base 1)** ", "4000", "2", "", "COU+2", "Non", Constants.SUBCAT_ACCESSOIRES_METAL));

        stuff.add(new Armure("Cotte de maille pour Nain \"Débutant\" avec manches ", "100", "3", "AD-1", "Nain uniq. CHA+1", "1 à 4", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));
        stuff.add(new Armure("Cotte de mailles basique sans manches ", "500", "4", "AD-1", "", "1 à 3", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));
        stuff.add(new Armure("Cotte de mailles basique avec manches ", "800", "5", "AD-2", "", "1 à 3", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));
        stuff.add(new Armure("Cotte de maille luxe avec manches (artisan nain) ", "3000", "5", "", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));
        stuff.add(new Armure("Cotte de maille acier carbone pour voleur, sans manches ", "5000", "5", "", "CHA+1 AD+1 COU+1", "Non", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));
        stuff.add(new Armure("Cotte de maille elfique avec manches (ench. base 4)** ", "8000", "6", "", "CHA+2 AD+1", "Non", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));
        stuff.add(new Armure("Cotte de maille Thritil avec manches (ench. base 5)** ", "20000", "6", "", "CHA+3 AD+2 AT/PRD+1", "Non", Constants.SUBCAT_PLASTRONS_COTTES_DE_MAILLE));

        stuff.add(new Armure("Casque de cuir  ", "20", "0", "", "", "1 à 5", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Casque de cuir luxe  ", "100", "1", "", "", "1 à 3", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Casque de métal de base ", "50", "1", "CHA-1 AD-1", "COU+1", "1 à 4", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Casque de métal \"Lebohaum\"  ", "100", "1", "AD-1", "COU+1", "1 à 3", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Casque de métal \"confort\" léger et ouvragé ", "500", "1", "", "COU+1", "1 à 3", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Casque luxe (artisan nain) ", "1000", "1", "", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Heaume de guerrier elfique (ench. base 0)** ", "1500", "1", "", "CHA+1 COU+2", "1 à 2", Constants.SUBCAT_CASQUE));
        stuff.add(new Armure("Heaume plaqué or ouvragé  ", "2000", "1", "", "CHA+2 COU+2", "1 à 2", Constants.SUBCAT_CASQUE));

        stuff.add(new Armure("Gantelets ou bracelets cuir  ", "30", "***", "", "", "1 à 5", Constants.SUBCAT_GANTS));
        stuff.add(new Armure("Gantelets ou bracelets cuir et métal ", "80", "***", "AD-1", "", "1 à 4", Constants.SUBCAT_GANTS));
        stuff.add(new Armure("Gantelets maille  ", "150", "***", "AD-1", "", "1 à 3", Constants.SUBCAT_GANTS));
        stuff.add(new Armure("Gantelets ou bracelets de combat elfiques ", "1000", "1", "", "AD+1", "1 à 2", Constants.SUBCAT_GANTS));
        stuff.add(new Armure("Gantelets ou bracelets Thritil  ", "2000", "1", "", "COU+1 AT+1", "Non", Constants.SUBCAT_GANTS));

        stuff.add(new Armure("Bottes de cuir minables  ", "5", "***", "AD-1 CHA-1", "", "1 à 5", Constants.SUBCAT_BOTTES));
        stuff.add(new Armure("Bottes de cuir standard  ", "15", "***", "", "", "1 à 4", Constants.SUBCAT_BOTTES));
        stuff.add(new Armure("Bottes de cuir renforcées de base ", "30", "1", "AD-1", "", "1 à 3", Constants.SUBCAT_BOTTES));
        stuff.add(new Armure("Bottes de cuir renforcées légères  ", "100", "1", "", "", "1 à 3", Constants.SUBCAT_BOTTES));
        stuff.add(new Armure("Bottes elfiques de danseur de guerre ", "1500", "1", "", "CHA+1", "1 à 3", Constants.SUBCAT_BOTTES));
        stuff.add(new Armure("Bottes de cuir luxe de champion ", "2000", "1", "AD-1", "CHA+1 COU+1 FO+1", "1 à 2", Constants.SUBCAT_BOTTES));
        stuff.add(new Armure("Chaussons de danse de Rizmo Jarbé (relique) ", "3000", "1", "CHA-2 (sauf elfes)", "CHA+2 (elfes) AD+4 (danse)", "Non", Constants.SUBCAT_BOTTES));


        stuff.add(new Armure("Set d'armure métal bas de gamme Donjon Facile ", "700", "7", "AD-5 CHA-4 MV-50% AT/PRD-1", "", "1 à 4", Constants.SUBCAT_ARMURE_COMPLETE_METAL));
        stuff.add(new Armure("Set d'armure métal TinCan(TM) pour Nain ", "2000", "7", "AD-4 CHA-3 MV-50%", "COU+1", "1 à 4", Constants.SUBCAT_ARMURE_COMPLETE_METAL));
        stuff.add(new Armure("Set d'armure métal \"Petit Palouf\" du Donjon Facile ", "4000", "6", "AD-3 MV-50%", "COU+1 CHA+1 (prodiges)", "1 à 3", Constants.SUBCAT_ARMURE_COMPLETE_METAL));
        stuff.add(new Armure("Set d'armure \"Grand Palouf\" du Donjon Facile (ench.) 10000", "", "8", "AD-2", "COU+3 CHA+3 (prodiges)", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_METAL));
        stuff.add(new Armure("Set d'armure de Justice de Braav' (ench.) (relique) 20000", "", "9", "", "COU+4 CHA+3 FO+1", "Non", Constants.SUBCAT_ARMURE_COMPLETE_METAL));
        stuff.add(new Armure("Armure complète en Thritil (rare)  50000", "", "12", "", "CHA+4 AT/PRD+2 COU+4", "Non", Constants.SUBCAT_ARMURE_COMPLETE_METAL));

        stuff.add(new Armure("Set Armure de cuir orque troupier  ", "250", "4", "AD-2 CHA-2", "COU+1", "1 à 5", Constants.SUBCAT_ARMURE_COMPLETE_CUIR));
        stuff.add(new Armure("Set Armure de cuir orque mercenaire \"Tourkilak\" ", "800", "5", "AD-3 MV-25% CHA-3", "COU+2", "1 à 5", Constants.SUBCAT_ARMURE_COMPLETE_CUIR));
        stuff.add(new Armure("Set Armure de cuir \"Mercenaire 100\" ", "2500", "6", "AD-2 CHA-2 MV-25%", "COU+2", "1 à 4", Constants.SUBCAT_ARMURE_COMPLETE_CUIR));
        stuff.add(new Armure("Set d'armure cuir-métal \"Maraveur 200\" ", "5500", "7", "AD-3 MV-25%", "COU+2 CHA+1", "1 à 3", Constants.SUBCAT_ARMURE_COMPLETE_CUIR));
        stuff.add(new Armure("Set d'armure cuir-métal \"Bastonneur 400\" ", "7000", "8", "AD-2 MV-25%", "COU+2 CHA+2", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_CUIR));
        stuff.add(new Armure("Set d'armure cuir-écaille \"Destructeur 1000\" ", "8000", "9", "AD-2 MV-25%", "COU+3 CHA+2", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_CUIR));

        stuff.add(new Armure("Set d'armure elfique \"Folonariel\" (ench. base 4)** 10000", "", "6", "MV-25%", "COU+3 CHA+3", "1 à 3", Constants.SUBCAT_ARMURE_COMPLETE_LEGERE));
        stuff.add(new Armure("Set d'armure Demigod(TM) (ench. base 6)** 10000", "", "8", "AD-1", "COU+3 CHA+2 FO+1", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_LEGERE));
        stuff.add(new Armure("Set d'armure elfique \"Talairfin\" (ench. base 4)** 15000", "", "7", "MV-25%", "COU+4 CHA+3 2AT/assaut", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_LEGERE));
        stuff.add(new Armure("Set d'armure du Massacre de Khornettoh (ench. base 6)** 20000", "", "9", "CHA-1", "COU+1 AT/PRD+1 FO+2", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_LEGERE));

        stuff.add(new Armure("Set de Robes de prêtre \"Veinard\" (ench. base 2)** 10000", "", "4", "", "Res. Magie+3 PRD+2", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));
        stuff.add(new Armure("Set Tunique/Pantalon  des Ombres (ench. base 3)** 10000", "", "6", "", "CHA+3 AD+4 (discrétion)", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));
        stuff.add(new Armure("Set Tunique/Pantalon  du Fourbe (ench. base 3)** 12000", "", "6", "", "CHA+2 AT+2 AD+1", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));
        stuff.add(new Armure("Set Tunique/Pantalon  de Vélocité (ench. base 3)** 12000", "", "6", "", "MV+100% 2AT/assaut", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));
        stuff.add(new Armure("Set Tunique/Pantalon  de l'Ether (ench. base 3)** 12000", "", "4", "", "Invisibilité en standard", "1 à 2", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));
        stuff.add(new Armure("Set de Robes de prêtre \"Dévôt\" (ench. base 2)** 15000", "", "5", "", "COU+2 CHA+4 (prodiges)", "Non", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));
        stuff.add(new Armure("Set de Robes de prêtre \"L'élu\" (ench. base 2)** 20000", "", "8", "", "Lévitation, CHA+4 (prodiges)", "Non", Constants.SUBCAT_ARMURE_COMPLETE_TISSU));

        stuff.add(new Armure("Bouclier de base  ", "30", "1", "AD-1 AT-2", "PRD+1", "1 à 4", Constants.SUBCAT_BOUCLIERS));
        stuff.add(new Armure("Grand bouclier de base  ", "50", "2", "AD-2 AT-3 MV-20%", "PRD+2", "1 à 4", Constants.SUBCAT_BOUCLIERS));
        stuff.add(new Armure("Bouclier Saldur (de luxe)  ", "500", "1", "AT-1", "PRD+2 CHA+1", "1 à 3", Constants.SUBCAT_BOUCLIERS));
        stuff.add(new Armure("Grand bouclier de luxe  ", "800", "2", "AD-1 AT-2", "PRD+3 CHA+2", "1 à 3", Constants.SUBCAT_BOUCLIERS));
        stuff.add(new Armure("Bouclier elfique de luxe, ultra-léger  ", "2000", "2", "AT-1", "PRD+3 CHA+2", "1 à 2", Constants.SUBCAT_BOUCLIERS));
        stuff.add(new Armure("Bouclier ensorcelé de champion du Chaos (ench. base 1)**", "5000", "3", "AD-1 CHA-1", "FO+2 AT/PRD+1", "Non", Constants.SUBCAT_BOUCLIERS));

        stuff.add(new Armure("Calotte de cuir du Chef (tête)  ", "25", "***", "", "", "1 à 5", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Beau casque du Gardien (tête)  ", "60", "***", "", "COU+1", "1 à 3", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Salade de garde des Remparts d'Altrouille (tête) ", "75", "1", "CHA-1 AD-1", "COU+1", "1 à 4", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Casque de Sargent de Rillettebourg (tête) ", "130", "1", "", "", "1 à 3", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Pourpoint de cuistot-brigand (torse)  ", "40", "2", "", "", "1 à 4", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Gambison de Fierpâté (torse, avec manches) ", "65", "2", "", "", "1 à 4", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Gambison d'Altrouille (torse, avec manches) ", "130", "2", "", "CHA+1", "1 à 3", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Veston redoutable de Terrineville (torse, avec manches) ", "130", "3", "", "AD+1", "1 à 3", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Gambison Joli (torse, avec manches) (ench. base 3)** ", "600", "4", "AD-1", "CHA+1 COU+1", "1 à 3", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Cotte Magnifique de Gilbert (torse) (ench. base 3)** ", "1000", "5", "", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Bracelets de cuir du Tit'gars (avant-bras)  ", "100", "***", "AD-1", "", "1 à 4", Constants.SUBCAT_PROTECTION_HOBBITS));
        stuff.add(new Armure("Grand'bottes chourées à Boombardil (pieds, jambes) ", "100", "***", "AD-1", "", "1 à 4", Constants.SUBCAT_PROTECTION_HOBBITS));

        stuff.add(new Armure("Veste en cuir bricolée (torse) ", "60", "2", "CHA-1", "", "1 à 5", Constants.SUBCAT_PROTECTION_GNOMES));
        stuff.add(new Armure("Veste en cuir sur mesure (torse, avec manches) ", "120", "2", "", "", "1 à 4", Constants.SUBCAT_PROTECTION_GNOMES));
        stuff.add(new Armure("Veste en cuir sur mesure d'artisan (torse, avec manches) ", "250", "2", "", "CHA+1", "1 à 3", Constants.SUBCAT_PROTECTION_GNOMES));
        stuff.add(new Armure("Mini-casque de protection forgé sur mesure (tête) ", "500", "1", "", "COU+1", "1 à 3", Constants.SUBCAT_PROTECTION_GNOMES));
        stuff.add(new Armure("Braies d'acrobate sur mesure (jambes)  ", "250", "***", "", "Évite parfois l'unijambisme", "1 à 5", Constants.SUBCAT_PROTECTION_GNOMES));
        stuff.add(new Armure("Veste en toile renforcée d'exception (ench. base 2)** ", "500", "3", "", "COU+1", "1 à 4", Constants.SUBCAT_PROTECTION_GNOMES));

        stuff.add(new Armure("Grand casque du Bourreau (tête)  ", "140", "1", "AD-1", "", "1 à 3", Constants.SUBCAT_PROTECTION_OGRES));
        stuff.add(new Armure("Tunique Renforcée du Boucher (torse, avec manches) ", "80", "2", "", "", "1 à 4", Constants.SUBCAT_PROTECTION_OGRES));
        stuff.add(new Armure("Pagne de cuir solide  ", "30", "***", "", "Peut éviter certains soucis", "1 à 4", Constants.SUBCAT_PROTECTION_OGRES));
        stuff.add(new Armure("Braies de Cuir du Boucher (jambes)  ", "200", "1", "", "CHA+1", "1 à 4", Constants.SUBCAT_PROTECTION_OGRES));
        stuff.add(new Armure("Grand Surcot du Dépeceur (torse) (ench. base 2)** ", "1000", "4", "", "CHA+1 COU+1", "1 à 2", Constants.SUBCAT_PROTECTION_OGRES));


    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
                                int groupPosition, int childPosition, long id) {

        Stuff selectedItem = (Stuff) mAdapter.getChild(groupPosition, childPosition);
        showPopup(selectedItem);
        return true;
    }

    private void showPopup(Stuff selectedItem) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_stuff);
        dialog.getWindow().setLayout((6 * width) / 7, LinearLayout.LayoutParams.WRAP_CONTENT);
        // dialog.setTitle("Custom Alert Dialog");

        TextView tt1 = dialog.findViewById(R.id.nomStuffPopup);
        TextView tt2 = dialog.findViewById(R.id.prixStuffPopup);
        TextView tt3 = dialog.findViewById(R.id.prOuDgtStuffPopup);
        TextView tt4 = dialog.findViewById(R.id.malusStuffPopup);
        TextView tt5 = dialog.findViewById(R.id.bonusStuffPopup);
        TextView tt6 = dialog.findViewById(R.id.ruptureStuffPopup);

        if (tt1 != null) {
            tt1.setText(selectedItem.getNom());
        }
        if (tt2 != null) {
            tt2.setText(selectedItem.getPrix());
        }
        if (tt3 != null) {
            tt3.setText(selectedItem.getPrOuDgts());
        }
        if (tt4 != null) {
            if (selectedItem.getMalus() == "")
                tt4.setVisibility(View.GONE);

            else
                tt4.setText("Malus : " + selectedItem.getMalus());
        }
        if (tt5 != null) {
            if (selectedItem.getBonus() == "")
                tt5.setVisibility(View.GONE);
            else
                tt5.setText("Bonus : " + selectedItem.getBonus());
        }
        if (tt6 != null) {
            tt6.setText(selectedItem.getRupture());
        }
        dialog.show();
    }

}
