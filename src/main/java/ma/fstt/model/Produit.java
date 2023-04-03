package ma.fstt.model;

public class Produit {
    private Long id_produit;
    private  String prix;
    private String description;

    public Produit() {
    }
    public Produit(Long id_produit, String prix, String desciption){
        this.id_produit=id_produit;
        this.prix =prix;
        this.description=description;

    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    public String toString(){
        return "produit{"+"id_produit="+id_produit+",description="+description+",prix="+prix;
    }
}
