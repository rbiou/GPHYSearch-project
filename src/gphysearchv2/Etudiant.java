package gphysearchv2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe définissant un étudiant avec son nom, prénom, sa promotion et sa date de naissance
 * 
 * @author Groupe IHM2.1 : Rémi BIOU, Hatim ER-RBIBI, Marvin GODARD
 */
public class Etudiant {
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty promotion;
    private final StringProperty anneeDeNaissance;
    
    /**
     * Constructeur créant un étudiant
     * @param newPrenom
     * @param newNom
     * @param newPromotion
     * @param newAnneeDeNaissance
     */
    public Etudiant(String newPrenom, String newNom,String newPromotion,String newAnneeDeNaissance){
        this.prenom = new SimpleStringProperty(newPrenom);
        this.nom = new SimpleStringProperty(newNom);
        this.promotion = new SimpleStringProperty(newPromotion);
        this.anneeDeNaissance = new SimpleStringProperty(newAnneeDeNaissance);
    }
    
    /**
     * Retourne la propriété nom d'un étudiant
     * @return nom
     */
    public StringProperty nomProperty() {
        return nom;
    }
    
    /**
     * Retourne la propriété prénom d'un étudiant
     * @return prenom
     */
    public StringProperty prenomProperty() {
        return prenom;
    }
    
    /**
     * Retourne la propriété promotion d'un étudiant
     * @return promotion
     */
    public StringProperty promotionProperty() {
        return promotion;
    }
    
    /**
     * Retourne la propriété d'année de naissance d'un étudiant
     * @return anneeDeNaissance
     */
    public StringProperty anneeDeNaissanceProperty() {
        return anneeDeNaissance;
    }
    
    /**
     * Retourne le nom d'un étudiant
     * @return nom.get()
     */
    public String getNom(){
        return nom.get();
    }
    
    /**
     * Retourne le prénom d'un étudiant
     * @return prenom.get()
     */
    public String getPrenom(){
        return prenom.get();
    }
    
    /**
     * Retourne la promotion d'un étudiant
     * @return promotion.get()
     */
    public String getPromotion(){
        return promotion.get();
    }
    
    /**
     * Retourne l'année de naissance d'un étudiant
     * @return anneeDeNaissance.get()
     */
    public String getAnneeDeNaissance(){
        return anneeDeNaissance.get();
    }
    
    /**
     * Permet de paramètrer la promotion d'un étudiant
     * @param newPromotion
     */
    public void setPromotion(String newPromotion){
        this.promotion.set(newPromotion);
    }
    
    /**
     * Permet de paramètrer le nom d'un étudiant
     * @param newNom
     */
    public void setNom(String newNom){
        this.nom.set(newNom);
    }
    
    /**
     * Permet de paramètrer le prénom d'un étudiant
     * @param newPrenom
     */
    public void setPrenom(String newPrenom){
        this.prenom.set(newPrenom);
    }
    
    /**
     * Permet de paramètrer l'année de naissance d'un étudiant
     * @param newAnneeDeNaissance
     */
    public void setAnneeDeNaissance(String newAnneeDeNaissance){
        this.anneeDeNaissance.set(newAnneeDeNaissance);
    }
}