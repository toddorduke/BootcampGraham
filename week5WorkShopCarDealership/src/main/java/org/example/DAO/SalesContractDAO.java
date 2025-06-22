package org.example.DAO;

import org.example.SalesContract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesContractDAO {

    private String connectionString;
    private String userName;
    private String password;

    public SalesContractDAO(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public void save(SalesContract contract) {
        String query = "INSERT INTO sales_contracts (buyer_name, contract_date, vehicle_vin, dealership_id) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, contract.getCustomerName());
            stmt.setString(2, contract.getDate());
            stmt.setInt(3, contract.getVehicle().getVin());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
