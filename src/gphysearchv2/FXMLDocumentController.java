/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gphysearchv2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * Controller de notre application GPhySearch
 * @author Groupe IHM2.1 : Rémi BIOU, Hatim ER-RBIBI, Marvin GODARD
 */
public class FXMLDocumentController implements Initializable {
    
    private Integer index;
    private ObservableList<Etudiant> etudiants = FXCollections.observableArrayList();
    @FXML
    private Label title_label, error1, error2;
    @FXML
    private ImageView title_icon;
    @FXML
    private AnchorPane add_pane, home_pane, edit_pane;
    @FXML
    private TextField name_field, surname_field, year_field, edit_name_field, edit_surname_field, edit_year_field;
    @FXML
    private MenuButton promotion_field, edit_promotion_field;
    @FXML
    private TableView<Etudiant> personTable;
    @FXML
    private TableColumn<Etudiant, String> prenomColonne, nomColonne, anneeDeNaissanceColonne, promotionColonne;
    @FXML
    private TableColumn<Etudiant, Void> editerColonne;
    
    /**
     * Méthode qui permet de sélectionner la promotion parmis des choix (L3, M1 et M2) 
     * Le choix sélectionner sera celui affiché dans le champ "Promotion"
     * @param event
     */
    @FXML
    private void setSelectedPromotion(ActionEvent event) {
        if (add_pane.isVisible()) {
            promotion_field.setText(((MenuItem) event.getTarget()).getText());
        } else {
            edit_promotion_field.setText(((MenuItem) event.getTarget()).getText()); 
        }
    }
    
    /**
     * Méthode permettant de gérer l'affichage du panel "Ajout"
     * @param event
     */
    @FXML
    private void setAddPanel(MouseEvent event) {
        title_label.setText("Ajouter un étudiant");
        title_icon.setImage(new Image(getClass().getResource("baseline_person_add_white_48dp.png").toExternalForm()));
        add_pane.setVisible(true);
        home_pane.setVisible(false);
        edit_pane.setVisible(false);
        error1.setVisible(false);
        error2.setVisible(false);
    }
    
    /**
     * Méthode permettant de gérer l'affichage du panel "Accueil"
     * @param event 
     */
    @FXML
    private void setHomePanel(MouseEvent event) {
        title_label.setText("Accueil");
        title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
        add_pane.setVisible(false);
        home_pane.setVisible(true);
        edit_pane.setVisible(false);
        error1.setVisible(false);
        error2.setVisible(false);
    }
    
    /**
     * Méthode permettant d'ajouter un étudiant en renseignant son nom, son prénom, son année de naissance et sa promotion
     * Tous les champs doivent être remplis pour pourvoir ajouter un étudiant
     * Le nom et le prénom ne peuvent pas contenir de numéro
     * La date de naissance ne peut pas contenir de lettres et doit contenir 4 chiffres
     * @param event 
     */
    @FXML
    private void addStudent(ActionEvent event) {
        Etudiant newStudent = new Etudiant(surname_field.getText(), name_field.getText(), promotion_field.getText(), year_field.getText());
        if ((name_field.getText().isEmpty() == false) && (surname_field.getText().isEmpty() == false) && (promotion_field.getText().isEmpty() == false) && (year_field.getText().isEmpty() == false)) {
            if ((name_field.getText().matches(".*\\d+.*") == false) && (name_field.getText().matches("[a-zA-Z]+")) && (surname_field.getText().matches(".*\\d+.*") == false) && (surname_field.getText().matches("[a-zA-Z]+")) && ((year_field.getText().matches("[0-9]+")) && (year_field.getText().length() == 4))) {
                //Set home panel back            
                title_label.setText("Accueil");
                title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
                add_pane.setVisible(false);
                home_pane.setVisible(true);
                //If any empty field
                error1.setVisible(false);
                //Add the new student to the student lists 
                personTable.getItems().add(newStudent);
                //Clear fields for the add
                name_field.clear();
                surname_field.clear();
                promotion_field.setText("");
                year_field.clear();
            } else {
                error1.setText("Champs contenant des caractères incorrects !");
                error1.setVisible(true);
            }
        } else {
            error1.setText("Veuillez remplir tous les champs SVP");
            error1.setVisible(true);
        }
    }
    
    /**
     * Méthode permettant d'editer un étudiant en changeant son nom, son prénom, son année de naissance et/ou sa promotion
     * L'édition se fait en cliquand sur le bouton "Editer" au niveau de l'accueil, sur la ligne de l'étudiant à modifier
     * Tous les champs doivent être remplis pour pourvoir ajouter un étudiant
     * Le nom et le prénom ne peuvent pas contenir de numéro
     * La date de naissance ne peut pas contenir de lettres et doit contenir 4 chiffres
     * @param event 
     */
    @FXML
    private void editStudent(ActionEvent event) {
        Etudiant editedStudent = new Etudiant(edit_surname_field.getText(), edit_name_field.getText(), edit_promotion_field.getText(), edit_year_field.getText());
        if ((edit_name_field.getText().isEmpty() == false) && (edit_surname_field.getText().isEmpty() == false) && (edit_promotion_field.getText().isEmpty() == false) && (edit_year_field.getText().isEmpty() == false)) {
            if ((edit_name_field.getText().matches(".*\\d+.*") == false) && (edit_name_field.getText().matches("[a-zA-Z]+")) && (edit_surname_field.getText().matches(".*\\d+.*") == false) && (edit_surname_field.getText().matches("[a-zA-Z]+")) && ((edit_year_field.getText().matches("[0-9]+")) && (edit_year_field.getText().length() == 4))) {    
                //Edit student
                etudiants.set(index, editedStudent);
                //Set home panel back            
                title_label.setText("Accueil");
                title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
                edit_pane.setVisible(false);
                home_pane.setVisible(true);
                error2.setVisible(false);
            } else {
                error2.setText("Champs contenant des caractères incorrects !");
                error2.setVisible(true);
            }
        } else {
            //If any empty field
            error2.setText("Veuillez remplir tous les champs SVP");
            error2.setVisible(true);
        }
    }
    
    /**
     * Procédure d'initialisation qui créer notre tableau avec notre liste d'étudiants pré-remplies avec les informations de getPeople()
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        anneeDeNaissanceColonne.setCellValueFactory(new PropertyValueFactory<>("anneeDeNaissance"));
        promotionColonne.setCellValueFactory(new PropertyValueFactory<>("promotion"));
        personTable.setItems(etudiants);
        personTable.setEditable(true);

        //Set Edit button column
        TableColumn<Etudiant, Void> editerColonne = new TableColumn("Editer");
        
        Callback<TableColumn<Etudiant, Void>, TableCell<Etudiant, Void>> cellFactory = (final TableColumn<Etudiant, Void> param) -> {
            final TableCell<Etudiant, Void> cell = new TableCell<Etudiant, Void>() {
                private final Button btn = new Button();
                {
                    btn.setOnAction((ActionEvent event) -> {
                        title_label.setText("Editer un étudiant");
                        title_icon.setImage(new Image(getClass().getResource("baseline_edit_white_48dp.png").toExternalForm()));
                        Etudiant etudiant = getTableView().getItems().get(getIndex());
                        home_pane.setVisible(false);
                        add_pane.setVisible(false);
                        edit_pane.setVisible(true);
                        edit_name_field.setText(etudiant.getNom());
                        edit_surname_field.setText(etudiant.getPrenom());
                        edit_year_field.setText(etudiant.getAnneeDeNaissance());
                        edit_promotion_field.setText(etudiant.getPromotion());
                        index = getIndex();
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                        setStyle("-fx-alignment : CENTER;");
                        btn.setGraphic(new ImageView(new Image(getClass().getResource("baseline_edit_black_48dp.png").toExternalForm(), 20, 20, true, true)));
                    }
                }
            };
            return cell;
        };
        editerColonne.setCellFactory(cellFactory);
        personTable.getColumns().add(editerColonne);
    }
}
