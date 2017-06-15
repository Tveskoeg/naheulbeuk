package com.meujeu.julien.naheulbeuk.csheet;

import com.meujeu.julien.naheulbeuk.csheet.elements.Counter;
import com.meujeu.julien.naheulbeuk.csheet.elements.Stat;
import com.meujeu.julien.naheulbeuk.table.items.Item;

import java.util.ArrayList;

/**
 * Created by Julien on 10/06/2017.
 */

public class CharacterSheet {

    private String name;
    private String note;
    private ArrayList<Counter> counters;
    private ArrayList<Stat> stats;
    private ArrayList<Item> stuff;
    private ArrayList<Item> inventory;

    public CharacterSheet() {
        name = "";
        note = "";
        counters = new ArrayList<Counter>();
        stats = new ArrayList<Stat>();
        stuff = new ArrayList<Item>();
        stuff = new ArrayList<Item>();
    }

    public void addCounter(String name, int defaultValue) {

        this.counters.add(new Counter(name, defaultValue));
    }

    public void addStat(String name, int defaultValue) {
        this.stats.add(new Stat(name, defaultValue));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<Counter> getCounters() {
        return counters;
    }

    public void setCounters(ArrayList<Counter> counters) {
        this.counters = counters;
    }

    public ArrayList<Stat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Stat> stats) {
        this.stats = stats;
    }

    public ArrayList<Item> getStuff() {
        return stuff;
    }

    public void setStuff(ArrayList<Item> stuff) {
        this.stuff = stuff;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void addInventory(Item itemToAdd) {
        this.inventory.add(itemToAdd);
    }

    public void removeIventory(int indexInIventory) {
        this.inventory.remove(indexInIventory);
    }

    public void addStuff(Item itemToAdd) {
        this.stuff.add(itemToAdd);
    }

    public void removeStuff(int indexInStuff) {
        this.stuff.remove(indexInStuff);
    }

    public void putStuffIntoInventory(int indexInStuff) {
        this.addInventory(this.getStuff().get(indexInStuff));
        this.removeStuff(indexInStuff);
    }

    public void equipStuffFromInventory(int indexInInventory) {
        this.addStuff(this.getInventory().get(indexInInventory));
        this.removeIventory(indexInInventory);
    }

}
