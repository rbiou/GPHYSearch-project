/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearchv2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.I;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Remi
 */
public class FXMLDocumentController implements Initializable {
    
    
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
    private TableColumn<Etudiant, String> prenomColonne,nomColonne,anneeDeNaissanceColonne,promotionColonne;
  
    @FXML
    private Label label,error1;    
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
        home_pane.setVisible(true);
    }
    
    @FXML
    private void addStudent(ActionEvent event) {
        
        Etudiant newStudent = new Etudiant(surname_field.getText(), name_field.getText(), promotion_field.getText(), year_field.getText());
        //allPromotions.addEtudiant(newStudent);
        //Set home panel back
        if ((name_field.getText().isEmpty()==false) && (surname_field.getText().isEmpty()==false) && (promotion_field.getText().isEmpty()==false) && (year_field.getText().isEmpty()==false) ) {
                    System.out.println("coucou");

        
        title_label.setText("Accueil");
        title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
        add_pane.setVisible(false);
        home_pane.setVisible(true);
        //System.out.println(allPromotions.size());
        error1.setVisible(false);
        personTable.getItems().add(newStudent);
        }
        else{
            error1.setVisible(true);
        }
    }
    


      @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        anneeDeNaissanceColonne.setCellValueFactory(new PropertyValueFactory<>("anneeDeNaissance"));
        promotionColonne.setCellValueFactory(new PropertyValueFactory<>("promotion"));
        personTable.setItems(getPeople());
        personTable.setEditable(true);
    }
    
    public ObservableList<Etudiant>  getPeople()
    {
        ObservableList<Etudiant> etudiants = FXCollections.observableArrayList();
        etudiants.add(new Etudiant("Frank","Sinatra","L3", "1999"));
        etudiants.add(new Etudiant("Rebecca","Fergusson","M1", "1999"));
        etudiants.add(new Etudiant("Mr.","T","M2", "1999"));
       
        
        return etudiants;
    }
}

