package fr.riyad.entites;

import fr.riyad.exception.PanneEssenceException;

import java.text.DecimalFormat;

public abstract class VehiculeAMoteur extends Vehicule{

    protected Moteur moteur = new Moteur();
    protected float carburant;
    DecimalFormat df = new DecimalFormat("#.##");

    public VehiculeAMoteur() {
    }

    public VehiculeAMoteur(String marque, String modele, float niveauReservoire) {
        super(marque, modele);
        moteur.setVolumeReservoir(niveauReservoire);
        moteur.setVolumeTotal(niveauReservoire);
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public boolean demarrer(){
        return moteur.demarrer();
    }

    public void arreter(){
        moteur.arreter();
    }

    public void faireLePlein(float carburant){
        if (demarrer()){
            arreter();
        }
        moteur.faireLePlein(carburant);
        demarrer();

    }

    public void rouler(float consomation) throws PanneEssenceException {
        if(!getMoteur().isDemarre()){
            getMoteur().demarrer();
        }

        carburant = getMoteur().utiliser(consomation);

        if (carburant <= 0){
            throw new PanneEssenceException("C’est la panne d’essence !!");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Je suis le véhicule ");
        builder.append(super.getMarque())
                .append(" ")
                .append(getModele())
                .append("\n")
                .append("il reste ")
                .append(df.format(moteur.getVolumeReservoir()))
                .append(" litres dans le réservoir");
        return  builder.toString();
    }
}
