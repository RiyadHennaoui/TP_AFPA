package fr.riyad.entites;

import fr.riyad.exception.PanneEssenceException;

import java.util.ArrayList;
import java.util.List;


public class ParcVehicules <T extends VehiculeAMoteur>{


    List<T> parcDeVehicules = new ArrayList<>();

    //CONSTRUCTEURS
    public ParcVehicules() {
    }

    public ParcVehicules(List<T> parcDeVehicules) {
        this.parcDeVehicules = parcDeVehicules;
    }

    //GETTERS & SETTERS


    public List<T> getParcDeVehicules() {
        return parcDeVehicules;
    }

    public void setParcDeVehicules(List<T> parcDeVehicules) {
        this.parcDeVehicules = parcDeVehicules;
    }

    //METHODES
    public void controlerVehicules()  {
        int trajetRandom = (int) (1 + Math.random() * (1 - 5));
        int pleinRandom = (int) (1 + Math.random() * (1 - 10));
        String typeVehicule = "";
        int i = 1;




        System.out.println("-----------------------------------------------");
        System.out.println("Debut du test");

        for (VehiculeAMoteur vehicule: parcDeVehicules) {
            System.out.println("-----------------------------------------------");

            if(vehicule instanceof Voiture){
                typeVehicule = "une Voiture";
            }else if(vehicule instanceof Scooter){
                typeVehicule = "un Scooter";
            }
            System.out.println("Démarrer le véhicule " + i + " qui est " + typeVehicule );
            try{
                vehicule.demarrer();
                for (int j = 0; j <= trajetRandom; j++){
                    vehicule.rouler((float)trajetRandom);
                }
            }catch (PanneEssenceException ex){
                System.out.println(ex.getMessage());
            }


            i++;
        }

    }
}
