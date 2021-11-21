package fr.riyad.application;

import fr.riyad.entites.*;
import fr.riyad.exception.PanneEssenceException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] args) throws PanneEssenceException {

        laguna();
        espaceConsole();
        tourEnVoiture();
        espaceConsole();
        tourEnScouter();
        espaceConsole();
        testVehicules();

    }

    /**
     * Créer un espace entre chaque exercice
     */
    private static void espaceConsole() {
        System.out.println();
        System.out.println("- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -");
        System.out.println("- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -");
        System.out.println();
    }


    /**
     * première partie du TP
     * @throws PanneEssenceException
     */
    private static void laguna() throws PanneEssenceException {
        Voiture laguna = new Voiture("Renault", "Laguna", 30.0f);

        JOptionPane.showMessageDialog(null,laguna,"Voiture",JOptionPane.INFORMATION_MESSAGE);
        System.out.println(laguna);
        laguna.demarrer();
        laguna.rouler(25);
        System.out.println(laguna);
        System.out.println(laguna);
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println();
        try{
            laguna.rouler(35);
        }catch (PanneEssenceException ex){
            JOptionPane.showMessageDialog(null, "La laguna vient de tomber en panne  : " + ex.getMessage());
        }

        JOptionPane.showMessageDialog(null,laguna,"Voiture",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * deuxieme partie du TP
     * @throws PanneEssenceException
     */
    private static void tourEnVoiture() {
        /*
         * Questions 15 à 19 sur l'héritage ( page 10 )
         */
        Voiture c5 = new Voiture("Citroën", "C5", 40);
        System.out.println(c5);
        JOptionPane.showMessageDialog(null,
                "Je pars pour 6 tours qui consomment 10L",
                "Trajet",
                JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < 6; i++){
            try{
                c5.rouler(10);
                JOptionPane.showMessageDialog(null,
                        c5,
                        "Voiture",
                        JOptionPane.INFORMATION_MESSAGE);
            }catch(PanneEssenceException ex){
                System.out.println("------------------------------------------");
                System.out.println(c5);
                System.out.println("------------------------------------------");
                JOptionPane.showMessageDialog(null,c5, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("Fin du trajet");
        System.out.println("Nombre de litres restant => " + c5.getMoteur().getVolumeReservoir());
        System.out.println("Nombre de litres versés  => " + c5.getMoteur().getVolumeTotal());
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }


    /**
     * troisème partie du TP
     * @throws PanneEssenceException
     */
    private static void tourEnScouter() {
        /*
         * Questions 1 et 2 sur l'héritage ( page 12 )
         */
        Scooter xMax = new Scooter("Yamaha", "X-MAX", 20);
        System.out.println(xMax);
        JOptionPane.showMessageDialog(null,
                "Je pars pour 3 tours qui consomment 10L",
                "Trajet",JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < 3; i++){
            try{
                xMax.rouler(10);
                JOptionPane.showMessageDialog(null,xMax,"Scooter",JOptionPane.INFORMATION_MESSAGE);
            }catch(PanneEssenceException ex){
                System.out.println("------------------------------------------");
                System.out.println(xMax);
                System.out.println("------------------------------------------");
                JOptionPane.showMessageDialog(null,xMax, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("Fin du trajet");
        System.out.println("Nombre de litres restant => " + xMax.getMoteur().getVolumeReservoir());
        System.out.println("Nombre de litres versés  => " + xMax.getMoteur().getVolumeTotal());
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }


    /**
     * quatrième partie du TP
     * @throws PanneEssenceException
     */
    private static void testVehicules() {
        Scooter xMax = new Scooter("Yamaha", "X-MAX", 20);
        Scooter tMax = new Scooter("Yamaha", "T-MAX", 30);
        Scooter vMax = new Scooter("Yamaha", "V-MAX", 10);
        Voiture c5 = new Voiture("Citroën", "C5", 40);
        Voiture golf = new Voiture("VW", "Golf", 60);
        Voiture a3 = new Voiture("Audi", "A3", 50);
        Voiture classeA = new Voiture("Mercedes", "Classe A", 20);

        List<VehiculeAMoteur> lstVehicules = new ArrayList<>();
        lstVehicules.add(xMax);
        lstVehicules.add(tMax);
        lstVehicules.add(vMax);
        lstVehicules.add(c5);
        lstVehicules.add(golf);
        lstVehicules.add(a3);
        lstVehicules.add(classeA);


        ParcVehicules parcVehicules = new ParcVehicules(lstVehicules);

        parcVehicules.controlerVehicules();
    }

}
