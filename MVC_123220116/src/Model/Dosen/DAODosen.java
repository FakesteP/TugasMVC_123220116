/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafizh
 */
public class DAODosen implements InterfaceDAODosen {

    @Override
    public void insert(ModelDosen dosen) {
        try{
            String query = "INSERT INTO dosen (nama, nidn) VALUES (?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelDosen dosen) {
    try {
        String query = "UPDATE dosen SET nama=?, nidn=? WHERE id=?;";
            
        PreparedStatement statement;
        statement = Connector.Connect().prepareStatement(query);
        statement.setString(1, dosen.getNama());
        statement.setString(2, dosen.getNidn());
        statement.setInt(3, dosen.getId());
        
        statement.executeUpdate();
        
        statement.close();
    } catch (SQLException e) {
        System.out.println("update Failed! (" + e.getMessage() + ")");
    }
}

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM dosen WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelDosen> getAll() {
        List<ModelDosen> listdosen = null;

        try {
            listdosen = new ArrayList<>();
            
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM dosen;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelDosen mhs = new ModelDosen();
                
                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNidn(resultSet.getString("nidn"));
                
                listdosen.add(mhs);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listdosen;
    }
    
}

