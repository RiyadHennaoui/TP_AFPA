package fr.riyad.entites;

import javax.swing.*;
import java.text.DecimalFormat;

public class Moteur {

    private float volumeReservoir;
    private float volumeTotal;
    private boolean demarre;
    private float consoTotal;
    private DecimalFormat df = new DecimalFormat("#.##");


    //Constructeurs
    public Moteur() {
    }

    public Moteur(float volumeReservoir) {
        this.volumeReservoir = volumeReservoir;
    }


    //Getters & Setters
    //TODO que les getters d'après l'énnoncé.
    public float getVolumeReservoir() {
        return volumeReservoir;
    }

    public void setVolumeReservoir(float volumeReservoir) {
        this.volumeReservoir = volumeReservoir;
    }

    public float getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(float volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public boolean isDemarre() {
        return demarre;
    }

    public void setDemarre(boolean demarre) {
        this.demarre = demarre;
    }

    //METHODES

    /**
     * Methode pour demarrer le véhicule.
     * @return
     */
    public boolean demarrer() {

        if (!isDemarre()){
            if (this.volumeReservoir > 0.1f) {
                System.out.println("Le moteur est demarré avec " + df.format(this.volumeReservoir) + " litres dans le réservoir");
                this.volumeReservoir -= 0.1f;
                this.consoTotal += 0.1f;
                System.out.println("Je viens de consommer 1/10 litre pour démarrer");
                this.demarre = true;
                return true;
            } else {
                String resultat = JOptionPane.showInputDialog(null,
                        "Veuillez saisir le nombre de litres SVP ",
                        "50");
                Float i = new Float(resultat);
                faireLePlein(i);
                return false;
            }
        }else{
            return true;
        }
    }

    /**
     * Methode pour utiliser le moteur
     * @param consomation consomation d'essence exprimée en litre.
     * @return ce qui reste dans le reservoir d'essence.
     */
    public float utiliser(float consomation) {

        //Soustraire la consomation du volume restant du réservoire
        this.volumeReservoir -= consomation;
        //Permet le suivi de la consomation => remis à zero a chaque plein d'essence.
        this.consoTotal += consomation;
        //Affichages console
        System.out.println("Le moteur utilise " + consomation + "Litres"
                + " --->  Il reste " + df.format(this.volumeReservoir) + " litres");
        System.out.println("Je viens de consomer " + consoTotal + " litres");
        //vérification de la panne d'essence.
        if (this.volumeReservoir < 0) {
            volumeReservoir = 0.0f;
            arreter();
        }

        return volumeReservoir;
    }


    /**
     * Methode qui permet d'arreter un moteur.
     */
    public void arreter() {
        this.demarre = false;
        System.out.println("le moteur est arreté");
    }


    /**
     * Methode qui permet de faire le plein.
     * @param carburant exprimé en litre et saisie par l'utilisateur
     */
    public void faireLePlein(float carburant) {

        //Remise à zero de la consoTotal.
        this.consoTotal = 0;
        //Addition des deux variables avec la saisie utilisateur
        this.volumeTotal += carburant;
        this.volumeReservoir += carburant;
        System.out.println("Plein effectué avec " + carburant + " litres");
    }

}
