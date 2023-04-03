package ma.fstt.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestProduit {

    public static void main(String[] args) {

// trait bloc try catch

        try {


            ProduitDAO produitDAO = new ProduitDAO();


            List<Produit> comlist = produitDAO.getAll();

            for (Produit produit : comlist) {

                System.out.println(produit.toString());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            // Créer un objet LivreurDAO
            ProduitDAO produitDAO = new ProduitDAO();

            // Créer un objet Livreur
            Produit produit = new Produit(12345678909L, "234", "trop beau");

            // Ajouter le livreur dans la base de données
            produitDAO.ajouterProduit(produit);

            System.out.println("Le produit a été ajouté avec succès !");

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }

        // Mettre à jour les informations du livreur dans la base de données
        try {
            ProduitDAO produitDAO = new ProduitDAO();
            Produit produit = new Produit(12345678909L, "999", "OUI C'RAT CA ");
            produitDAO.update(produit);
            System.out.println("Livreur mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Vérifier si les informations du livreur ont été mises à jour en effectuant une requête SELECT sur la table livreur

    }
}