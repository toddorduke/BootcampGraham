package org.yearup.data;


import org.yearup.models.Product;
import org.yearup.models.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProfileDao {
    Profile create(Profile profile);

    Profile getById(int userId);

    void updateprofile(int id, Profile profile);

//    @Override
//    public Product getById(int productId) {
//        String sql = "SELECT * FROM products WHERE product_id = ?";
//        try (Connection connection = getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, productId);
//
//            ResultSet row = statement.executeQuery();
//
//            if (row.next()) {
//                return mapRow(row);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

}
