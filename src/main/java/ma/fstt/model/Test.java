package ma.fstt.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {

// trait bloc try catch
        try {


            LivreurDAO livreurDAO = new LivreurDAO();
            //  Livreur liv = new Livreur(0l , "liv3" , "200000000");

            //livreurDAO.save(liv);

            //Livreur liv2 = new Livreur(0l , "liv2" , "100000000");


            // livreurDAO.save(liv2);


            List<Livreur> livlist = livreurDAO.getAll();

            for (Livreur liv : livlist) {

                System.out.println(liv.toString());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
            LivreurDAO livreurDAO = new LivreurDAO();

            // Créer un objet Livreur
            Livreur livreur = new Livreur(12345678909L, "Dupont", "0123456789");

            // Ajouter le livreur dans la base de données
            livreurDAO.ajouterLivreur(livreur);

            System.out.println("Le livreur a été ajouté avec succès !");

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du livreur : " + e.getMessage());
        }

        // Mettre à jour les informations du livreur dans la base de données
        try {
            LivreurDAO livreurDAO = new LivreurDAO();
            Livreur livreur = new Livreur(12345678909L, "Dupont", "0123456789");
            livreurDAO.update(livreur);
            System.out.println("Livreur mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Vérifier si les informations du livreur ont été mises à jour en effectuant une requête SELECT sur la table livreur

    }
    }






