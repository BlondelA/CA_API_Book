package com.poc.Automate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Ensemble d'Etat unique
 * @see Etat
 */
public class EnsEtat extends HashSet<Etat> {

    protected HashMap<EnsEtat, Etat> mapDeterminise;
    protected HashMap<Etat[], Etat> mapUnion;

    // vide
    public EnsEtat() {
        super();
        mapDeterminise = null;
        mapUnion = null;
    }

    // return etats ateingable sur l'alphabet
    public EnsEtat succ(){
        EnsEtat a = new EnsEtat();
        for(Etat etat : this){
            EnsEtat sorties = etat.succ();
            a.addAll(sorties);
        }
        return a;
    }

}
