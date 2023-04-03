package ma.fstt.model;

public class Commande {
    private Long id_commande;
    private String nom;
    private String prix;

    public Commande(String text, String prixText) {
    }
    public Commande(Long id_commande, String nom, String prix){
        this.id_commande=id_commande;
        this.nom =nom;
        this.prix=prix;

    }

    public Long getId_commande() {
        return id_commande;
    }

    public void setId_commande(Long id_commande) {
        this.id_commande = id_commande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    public String toString(){
        return "commande{"+"id_commande="+id_commande+",nom="+nom+",prix="+prix;
    }
}
