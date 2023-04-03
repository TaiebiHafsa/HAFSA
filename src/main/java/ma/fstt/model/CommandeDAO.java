
package ma.fstt.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO extends BaseDAO<Commande>{
    public CommandeDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Commande object) throws SQLException {

        String request = "insert into commande (nom , prix) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom());

        this.preparedStatement.setString(2 , object.getPrix());


        this.preparedStatement.execute();
    }

    @Override
    public void update(Commande commande) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE commande SET nom=?, prix=? WHERE id_commande=?");
        preparedStatement.setString(1, commande.getNom());
        preparedStatement.setString(2, commande.getPrix());
        preparedStatement.setLong(3, commande.getId_commande());
        preparedStatement.executeUpdate();
    }


    @Override
    public void delete(Commande object) throws SQLException {
        String request = "DELETE FROM commande WHERE id_commande=?";
        this.preparedStatement = this.connection.prepareStatement(request);
        this.preparedStatement.setLong(1, object.getId_commande());
        this.preparedStatement.executeUpdate();
    }


    @Override
    public List<Commande> getAll()  throws SQLException {

        List<Commande> mylist = new ArrayList<Commande>();

        String request = "select * from commande ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Commande(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));


        }


        return mylist;
    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

    public void ajouterLivreur(Commande commande) throws SQLException {
        String query = "INSERT INTO commande (nom, prix) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, commande.getNom());
        statement.setString(2, commande.getPrix());
        statement.executeUpdate();
        statement.close();
    }

}
