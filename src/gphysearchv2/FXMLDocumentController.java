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
 *
 * @author Remi
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

    @FXML
    private void setSelectedPromotion(ActionEvent event) {
        if (add_pane.isVisible()) {
            promotion_field.setText(((MenuItem) event.getTarget()).getText());
        } else {
            edit_promotion_field.setText(((MenuItem) event.getTarget()).getText()); 
        }
    }

    @FXML
    private void setAddPanel(MouseEvent event) {
        title_label.setText("Ajouter un étudiant");
        title_icon.setImage(new Image(getClass().getResource("baseline_person_add_white_48dp.png").toExternalForm()));
        add_pane.setVisible(true);
        home_pane.setVisible(false);
        edit_pane.setVisible(false);
    }

    @FXML
    private void setHomePanel(MouseEvent event) {
        title_label.setText("Accueil");
        title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
        add_pane.setVisible(false);
        home_pane.setVisible(true);
        edit_pane.setVisible(false);
    }

    @FXML
    private void addStudent(ActionEvent event) {
        Etudiant newStudent = new Etudiant(surname_field.getText(), name_field.getText(), promotion_field.getText(), year_field.getText());
        if ((name_field.getText().isEmpty() == false) && (surname_field.getText().isEmpty() == false) && (promotion_field.getText().isEmpty() == false) && (year_field.getText().isEmpty() == false)) {
            //Set home panel back            
            title_label.setText("Accueil");
            title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
            add_pane.setVisible(false);
            home_pane.setVisible(true);
            //If any empty field
            error1.setVisible(false);
            //Add the new student to the student lists 
            personTable.getItems().add(newStudent);
            name_field.clear();
            surname_field.clear();
            year_field.clear();
        } else {
            error1.setVisible(true);
        }
    }
    
    @FXML
    private void editStudent(ActionEvent event) {
        Etudiant editedStudent = new Etudiant(edit_surname_field.getText(), edit_name_field.getText(), edit_promotion_field.getText(), edit_year_field.getText());
        if ((edit_name_field.getText().isEmpty() == false) && (edit_surname_field.getText().isEmpty() == false) && (edit_promotion_field.getText().isEmpty() == false) && (edit_year_field.getText().isEmpty() == false)) {
            //Edit student
            etudiants.set(index, editedStudent);
            //Set home panel back            
            title_label.setText("Accueil");
            title_icon.setImage(new Image(getClass().getResource("baseline_home_white_48dp.png").toExternalForm()));
            edit_pane.setVisible(false);
            home_pane.setVisible(true);
            //If any empty field
            error2.setVisible(false);
            //Clear all fields for next edit
            edit_name_field.clear();
            edit_surname_field.clear();
            edit_year_field.clear();
        } else {
            error2.setVisible(true);
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

        //Set Edit button column
        TableColumn<Etudiant, Void> editerColonne = new TableColumn("Editer");
        Callback<TableColumn<Etudiant, Void>, TableCell<Etudiant, Void>> cellFactory = (final TableColumn<Etudiant, Void> param) -> {
            final TableCell<Etudiant, Void> cell = new TableCell<Etudiant, Void>() {
                private final Button btn = new Button("Editer");
                {
                    btn.setOnAction((ActionEvent event) -> {
                        title_label.setText("Editer un étudiant");
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
                    }
                }
            };
            return cell;
        };
        editerColonne.setCellFactory(cellFactory);
        personTable.getColumns().add(editerColonne);
    }

    public ObservableList<Etudiant> getPeople() {
//        etudiants.add(new Etudiant("Frank", "Sinatra", "L3", "1999"));
//        etudiants.add(new Etudiant("Rebecca", "Fergusson", "M1", "1999"));
//        etudiants.add(new Etudiant("Mr.", "T", "M2", "1999"));
        return etudiants;
    }
}
