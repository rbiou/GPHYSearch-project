/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearchv2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Remi
 */
public class Etudiant {
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty promotion;
    private final StringProperty anneeDeNaissance;
    public Etudiant(String newPrenom, String newNom,String newPromotion,String newAnneeDeNaissance){
        this.prenom = new SimpleStringProperty(newPrenom);
        this.nom = new SimpleStringProperty(newNom);
        this.promotion = new SimpleStringProperty(newPromotion);
        this.anneeDeNaissance = new SimpleStringProperty(newAnneeDeNaissance);
    }
    
    public StringProperty nomProperty() {
        return nom;
    }
    
    public StringProperty prenomProperty() {
        return prenom;
    }
    
    public StringProperty promotionProperty() {
        return promotion;
    }
    
    public StringProperty anneeDeNaissanceProperty() {
        return anneeDeNaissance;
    }
    
    public String getNom(){
        return nom.get();
    }
    
    public String getPrenom(){
        return prenom.get();
    }
    
    public String getPromotion(){
        return promotion.get();
    }
    
    public String getAnneeDeNaissance(){
        return anneeDeNaissance.get();
    }
    
    public void setPromotion(String newPromotion){
        this.promotion.set(newPromotion);
    }
    
    public void setNom(String newNom){
        this.nom.set(newNom);
    }
    
    public void setPrenom(String newPrenom){
        this.prenom.set(newPrenom);
    }
    
    public void setAnneeDeNaissance(String newAnneeDeNaissance){
        this.anneeDeNaissance.set(newAnneeDeNaissance);
    }
}