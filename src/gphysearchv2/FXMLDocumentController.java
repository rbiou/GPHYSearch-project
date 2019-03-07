/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearchv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Remi
 */
public class FXMLDocumentController implements Initializable {
    
    private Promotions allPromotions;
    @FXML
    private Label title_label;
    @FXML
    private ImageView title_icon;
    @FXML
    private AnchorPane add_pane, home_pane;
    @FXML
    private TextField name_field, surname_field, year_field;
    @FXML
    private MenuButton promotion_field;
    @FXML
    private MenuItem promotion_1, promotion_2, promotion_3;
    @FXML
    private Button addButton;
    @FXML
    private TableView<Etudiant> personTable;
    @FXML
    private TableColumn<Etudiant, String> prenomColonne;
    @FXML
    private TableColumn<Etudiant, String> nomColonne;  
    @FXML
    private Label label;    
    @FXML
    private Label prenomLabel; 
    @FXML
    private Label nomLabel;   
    @FXML
    private Label promotionLabel;   
    @FXML
    private Label anneeDeNaissanceLabel;
    
    
    @FXML
    private void setSelectedPromotion(ActionEvent event) {
        promotion_field.setText(((MenuItem)event.getTarget()).getText());
    }
    
    @FXML
    private void setAddPanel(MouseEvent event) {
        title_label.setText("Ajouter un étudiant");
        title_icon.setImage(new Image(getClass().getResource("baseline_person_add_white_48dp.png").toExternalForm()));
        add_pane.setVisible(true);
        home_pane.setVisible(false);
    }
    
    @FXML
    private void setHomePanel(MouseEvent event) {
        title_label.setText("Accueil");
        title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
        add_pane.setVisible(false);
    }
    
    @FXML
    private void addStudent(MouseEvent event) {
        Etudiant newStudent = new Etudiant(name_field.getText(), surname_field.getText(), promotion_field.getText(), year_field.getText());
        allPromotions.addEtudiant(newStudent);
        //Set home panel back
        title_label.setText("Accueil");
        title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
        add_pane.setVisible(false);
        home_pane.setVisible(true);
        //System.out.println(allPromotions.size());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prenomColonne.setCellValueFactory(data -> data.getValue().prenomProperty());
        nomColonne.setCellValueFactory(data -> data.getValue().nomProperty());
        allPromotions = new Promotions();
        //System.out.println(allPromotions.getListeEtudiants().size());
        personTable.setItems(allPromotions.getListeEtudiants());
    }
    
    private void showStudentsDetails(Etudiant newStudent) {
        nomLabel.setText(newStudent.getNom());
        prenomLabel.setText(newStudent.getPrenom());
        promotionLabel.setText(newStudent.getPromotion());
        anneeDeNaissanceLabel.setText(newStudent.getAnneeDeNaissance());
    }
}
