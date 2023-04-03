package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Produit;
import ma.fstt.model.ProduitDAO;
import ma.fstt.model.Produit;
import ma.fstt.model.ProduitDAO;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {


    //public TableColumn colId;
    @FXML
    private TextField prix;


    @FXML
    private TextField description;


    @FXML
    private TableView<Produit> mytable;


    @FXML
    private TableColumn<Produit, Long> coll_id;

    @FXML
    private TableColumn<Produit, String> col_prix;

    @FXML
    private TableColumn<Produit, String> col_descr;

    public ProduitController() {
    }

    //save
    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            ProduitDAO produitDAO = new ProduitDAO();

            Produit prod = new Produit(0l,prix.getText(),description.getText());

            produitDAO.save(prod);


            UpdateT();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    //delete
    @FXML
    protected void onDeleteButtonClick() {
        Produit selProduit = mytable.getSelectionModel().getSelectedItem();
        if (selProduit != null) {
            try {
                ProduitDAO prod = new ProduitDAO();
                prod.delete(selProduit);
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            UpdateT();
        }
    }

    /* try {
         LivreurDAO livreurDAO = new LivreurDAO();

         Livreur liv = new Livreur(0l , nom.getText() , tele.getText());

         livreurDAO.delete(liv);


         UpdateTable();

     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
*/
    /*
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
     */

    @FXML
    protected void onUpdateButtonClick() {
        Produit selectedProduit = mytable.getSelectionModel().getSelectedItem();
        if (selectedProduit != null) {
            try {
                ProduitDAO prod = new ProduitDAO();
                //mettre a jour les champs de l'objet livreur selectionne
                selectedProduit.setPrix(prix.getText());
                selectedProduit.setDescription(description.getText());
                prod.update(selectedProduit);
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            //mettre a jour la ligne selectionnee dans la table
            int selectedIndex = mytable.getSelectionModel().getSelectedIndex();
            mytable.getItems().set(selectedIndex, selectedProduit);
        }
    }


    public void UpdateT() {
        coll_id.setCellValueFactory(new PropertyValueFactory<Produit, Long>("id_produit"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Produit, String>("prix"));

        col_descr.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));


        mytable.setItems(this.getDataProduits());
    }

    public static ObservableList<Produit> getDataProduits() {

        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for (Produit ettemp : produitDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateT();

    }

}
