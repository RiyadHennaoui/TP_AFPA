package fr.riyad.entites;

import fr.riyad.exception.PanneEssenceException;



public class Voiture extends VehiculeAMoteur{



    //CONSTRUCTEURS
    public Voiture() {
    }

    public Voiture(String marque, String modele, float niveauReservoire) {
        super(marque, modele, niveauReservoire);
    }


    //METHODES

    @Override
    public String toString() {
        if (moteur.getVolumeReservoir() <= 0){
            return super.toString() + "\n" + "et je viens de tomber en panne";
        }else{
            return super.toString();
        }
    }
}
