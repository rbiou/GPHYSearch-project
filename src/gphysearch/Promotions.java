/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearch;

import java.util.ArrayList;

/**
 *
 * @author Remi
 */
public class Promotions {
    
    private ArrayList<Etudiant> listeEtudiants; /* test git */
    public Promotions(){
        listeEtudiants = new ArrayList<>();
    }
    
    public void addEtudiant(Etudiant newEtudiant){
        listeEtudiants.add(newEtudiant);
    }
    
    public ArrayList<Etudiant> getListeEtudiants(){
        return this.listeEtudiants;
    }
}
