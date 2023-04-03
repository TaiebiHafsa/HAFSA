
package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Commande;
import ma.fstt.model.CommandeDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {


    @FXML
    private TextField nom;

    @FXML
    private TextField prix;



    @FXML
    private TableView<Commande> mytable;


    @FXML
    private TableColumn<Commande, String> col_nom;

    @FXML
    private TableColumn<Commande, String> col_prix;

    @FXML
    public void CommandetController(){

    }
    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            CommandeDAO CommandeDAO = new CommandeDAO();

            Commande cmd = new Commande(8l,prix.getText(),nom.getText());

            CommandeDAO.save(cmd);


            UpdateTable();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    protected void onDeleteButtonClick() {

        // accees a la bdd

        Commande selCommande=mytable.getSelectionModel().getSelectedItem();
         if(selCommande != null){
             try {
                 CommandeDAO com = new CommandeDAO();
                 com.delete(selCommande);

             }catch (SQLException e){
                 throw new RuntimeException(e);

             }
             UpdateTable();

         }
    }
    @FXML
    protected void onUpdateButtonClick() {
        Commande selectedCommande = mytable.getSelectionModel().getSelectedItem();
        if (selectedCommande != null) {
            try {
                CommandeDAO prod = new CommandeDAO();
                //mettre a jour les champs de l'objet livreur selectionne
                selectedCommande.setPrix(prix.getText());
                selectedCommande.setNom(nom.getText());
                prod.update(selectedCommande);
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            //mettre a jour la ligne selectionnee dans la table
            int selectedIndex = mytable.getSelectionModel().getSelectedIndex();
            mytable.getItems().set(selectedIndex, selectedCommande);
        }
    }


    public void UpdateTable() {
        col_nom.setCellValueFactory(new PropertyValueFactory<Commande, String>("nom"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Commande, String>("prix"));



        mytable.setItems(this.getDataCommande());
    }

    public static ObservableList<Commande> getDataCommande() {

        CommandeDAO CommandeDAO = null;

        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            CommandeDAO = new CommandeDAO();
            for (Commande ettemp : CommandeDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }

}