package daos;

import models.IPhones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class IPhonesDAO implements GenericDAO <IPhones>{
    //DAO is to interact with the database.

    Connection connection = ConnectionFactory.getConnection();

    private IPhones extractUserFromResultSet(ResultSet rs) throws SQLException {
        IPhones iPhones = new IPhones();

        iPhones.setId( rs.getInt("Id"));
        iPhones.setName( rs.getString("Name"));
        iPhones.setYear_released( rs.getString("Year_Released"));
        iPhones.setCost( rs.getInt("Cost"));
        iPhones.setFingerprint( rs.getString("Fingerprint"));
        iPhones.setSize( rs.getFloat("Size"));

        return iPhones;
    }

    public IPhones findById(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM iPhones WHERE id=" + id);

            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<IPhones> findAll() {
        return null;
    }

    public IPhones update(IPhones dto) {
        return null;
    }

    public IPhones create(IPhones dto) {
        return null;
    }

    public void delete(int id) {

    }
}
