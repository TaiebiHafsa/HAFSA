package ma.fstt.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends BaseDAO<Produit>{
    public ProduitDAO() throws SQLException {

        super();
    }

    @Override
    public  void save(Produit object) throws SQLException {

        String request = "insert into produit (prix , description) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getPrix());

        this.preparedStatement.setString(2 , object.getDescription());


        this.preparedStatement.execute();
    }

    @Override
    public void update(Produit produit) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE commande SET prix=?, description=? WHERE id_produit=?");
        preparedStatement.setString(1, produit.getPrix());
        preparedStatement.setString(2, produit.getDescription());
        preparedStatement.setLong(3, produit.getId_produit());
        preparedStatement.executeUpdate();
    }


    @Override
    public void delete(Produit object) throws SQLException {
        String request = "DELETE FROM produit WHERE id_produit=?";
        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setLong(1, object.getId_produit());
        this.preparedStatement.executeUpdate();
    }
    @Override public List<Produit> getAll()  throws SQLException {

          List<Produit> mylist = new ArrayList<Produit>();

        String request = "select * from produit ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Produit(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));


        }


        return mylist;
    }

    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }

    public void ajouterProduit(Produit produit) throws SQLException {
        String query = "INSERT INTO produit (prix, description) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, produit.getPrix());
        statement.setString(2, produit.getDescription());
        statement.executeUpdate();
        statement.close();
    }

}


