package daos;

import models.IPhones;

import java.sql.*;
import java.util.ArrayList;
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
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM iPhones");

            List<IPhones> iPhones = new ArrayList<>();

            while(rs.next())
            {
                IPhones iPhone = extractUserFromResultSet(rs);
                iPhones.add(iPhone);
            }

            return iPhones;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public IPhones update(IPhones dto) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE iPhones SET Name=?, Year_released=?, Cost=?," +
                    "Fingerprint=?, Size=? WHERE id=?");
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getYear_released());
            ps.setInt(3, dto.getCost());
            ps.setString(4, dto.getFingerprint());
            ps.setFloat(5, dto.getSize());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();

            if(i >= 1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public IPhones create(IPhones dto) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO iPhones VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getYear_released());
            ps.setInt(3, dto.getCost());
            ps.setString(4, dto.getFingerprint());
            ps.setFloat(5, dto.getSize());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();

            if(i >= 1) {
                return dto;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM iPhones WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
