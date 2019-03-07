/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearchv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Remi
 */
public class Promotions {
    
    private final ObservableList<Etudiant> listeEtudiants;
    public Promotions(){
        listeEtudiants = FXCollections.observableArrayList();
        listeEtudiants.add(new Etudiant("Remi","Biou","L3","1997"));
    }
    
    public void addEtudiant(Etudiant newEtudiant){
        listeEtudiants.add(newEtudiant);
    }
    
    public ObservableList<Etudiant> getListeEtudiants(){
        return this.listeEtudiants;
    }
}