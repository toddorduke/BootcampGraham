package org.example.DAO;

import org.example.LeaseContract;

import java.sql.*;


public class LeaseContractDAO {


    private String connectionString;
    private String userName;
    private String password;



    public LeaseContractDAO(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public LeaseContractDAO() {

    }

    public void save(LeaseContract lease) {
        String query = "INSERT INTO lease_contracts (contract_date, customer_name, customer_email, vehicle_vin, " +
                "monthly_payment, total_price, lease_term) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, lease.getDate());
            stmt.setString(2, lease.getCustomerName());
            stmt.setString(3, lease.getCustomerEmail());
            // Correct way
            stmt.setBigDecimal(5, lease.getMonthlyPayment());
            stmt.setBigDecimal(6, lease.getTotalPrice());
            // Add this line!

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

