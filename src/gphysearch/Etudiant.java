/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearch;

/**
 *
 * @author Remi
 */
public class Etudiant {
    private String nom;
    private String prenom;
    private String promotion;
    private int anneeDeNaissance;
    public Etudiant(String newNom,String newPrenom,String newPromotion,Integer newAnneeDeNaissance){
        nom = newNom;
        prenom = newPrenom;
        promotion = newPromotion;
        anneeDeNaissance = newAnneeDeNaissance;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public String getPromotion(){
        return this.promotion;
    }
    
    public int getAnneeDeNaissance(){
        return this.anneeDeNaissance;
    }
    
    public void setPromotion(String newPromotion){
        this.promotion = newPromotion;
    }
    
    public void setNom(String newNom){
        this.nom = newNom;
    }
    
    public void setPrenom(String newPrenom){
        this.prenom = newPrenom;
    }
    
    public void setAnneeDeNaissance(Integer newAnneeDeNaissance){
        this.anneeDeNaissance = newAnneeDeNaissance;
    }
}
