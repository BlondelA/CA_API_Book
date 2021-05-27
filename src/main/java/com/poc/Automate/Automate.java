package com.poc.Automate;

/**
 * Structure d'un Automate fini
 */
public class Automate extends EnsEtat {

    private EnsEtat initiaux;

    // vide
    public Automate() {
        super();
        initiaux = new EnsEtat();
    }

    // automate auquel on ajoute tous les etats accessibles depuis l'etat en parametre
    public Automate(Etat etat){
        this();
        this.ajouteEtatRecursif(etat);
    }

    // Ajoute l'etat et ses etats accessibles a l'automate
    public boolean ajouteEtatRecursif(Etat e){
        if(ajouteEtatSeul(e)){
            EnsEtat succ = e.succ();
            if(succ != null){
                for(Etat etat : e.succ()) ajouteEtatRecursif(etat);
            }
            return true;
        }else{
            return false;
        }
    }

    // ajoute etat a l'automate
    public boolean ajouteEtatSeul(Etat e){
        if(!this.add(e)) return false;
        if(e.isInit()) initiaux.add(e);
        return true;
    }
}
