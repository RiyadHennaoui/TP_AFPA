package fr.riyad.entites;

public abstract class Vehicule {

    private String marque;
    private String modele;


    //CONSTRUCTEURS
    public Vehicule() {
    }

    public Vehicule(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    //METHODES
    public abstract boolean demarrer();
    public abstract void arreter();
    public abstract void faireLePlein(float volumeEnLitreCarburant);

}
