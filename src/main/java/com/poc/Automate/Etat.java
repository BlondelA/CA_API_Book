package com.poc.Automate;

import java.util.HashMap;

/**
 * Representation d'un etat d'automate
 */
public class Etat {

    HashMap<Character, EnsEtat> transitions;
    boolean init;

    public Etat() {
        this.transitions = new HashMap<Character, EnsEtat>();
    }

    public boolean isInit() {
        return init;
    }

    // return etats successeurs
    public EnsEtat succ(){
        if(!transitions.isEmpty()){
            EnsEtat tmp = new EnsEtat();
            for(EnsEtat etats: transitions.values()){
                tmp.addAll(etats);
            }
            return tmp;
        }
        return new EnsEtat();
    }

}