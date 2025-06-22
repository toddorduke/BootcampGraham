package org.example.DAO;

import org.example.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {


    private final String connectionString = "jdbc:mysql://localhost:3306/dd_dealership";
    private final String userName = "root";
    private final String password = "name";

    //. By price range
    //2. By make/model
    //3. By year range
    //4. By color
    //5. By mileage range
    //6. By type

    public List<Vehicle> getAll() {

        List<Vehicle> list = new ArrayList<>();
        String query = "SELECT * FROM vehicle ";

        //connect to the database
        //run our query
        // get back results and covnert that to java
        //return a list of Vehicle

        //try-with statment
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {


            //loop thorugh rows until you run out
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setVin(rs.getInt("vin"));
                newVehicle.setYear(rs.getInt("year"));
                newVehicle.setMake(rs.getString("make"));
                newVehicle.setModel(rs.getString("model"));
                newVehicle.setColor(rs.getString("color"));
                newVehicle.setOdometer(rs.getDouble("odometer"));
                newVehicle.setPrice(rs.getDouble("price"));
                list.add(newVehicle);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> priceRange(double min, double max) {
        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model, color, odometer, price " +
                "FROM vehicle " +
                "WHERE price BETWEEN ? AND ?";


        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, min);
            stmt.setDouble(2, max);

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> make() {

        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model, color, odometer, price " +
                "FROM vehicle " +
                "WHERE price BETWEEN ? AND ?";


        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> model() {
        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model, color, odometer, price " +
                "FROM vehicle " +
                "WHERE price BETWEEN ? AND ?";


        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public List<Vehicle> year(double min, double max) {
        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model, color, odometer, price " +
                "FROM vehicle " +
                "WHERE year BETWEEN ? AND ?";


        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));

                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> color(String color) {
        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model,  color, odometer, price " +
                "FROM vehicle " +
                "WHERE color = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, color);

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> mileage(double min, double max) {

        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model, color, odometer, price " +
                "FROM vehicle " +
                "WHERE price BETWEEN ? AND ?";


        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vehicle> type() {

        List<Vehicle> list = new ArrayList<>();

        String query = "SELECT vin, year, make, model, color, odometer, price " +
                "FROM vehicle " +
                "WHERE price BETWEEN ? AND ?";


        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            //loop through rows until you run out
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //how do we grab the data from SQL
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vin"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setMake(rs.getString("make"));
                    newVehicle.setModel(rs.getString("model"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getDouble("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));
                    list.add(newVehicle);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //DELETE
    public void delete(int vin) {
        String query = "DELETE FROM vehicle WHERE vin = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setInt(1, vin);
            stmt.executeQuery()
            ;
            System.out.println("vehicle deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //CREATE
    public void create(Vehicle vehicle) {
        String query = "INSERT INTO vehicle (vin, year, make, model, color, odometer, price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, vehicle.getVin());
            stmt.setInt(2, vehicle.getYear());
            stmt.setString(3, vehicle.getMake());
            stmt.setString(4, vehicle.getModel());
            stmt.setString(5, vehicle.getColor());
            stmt.setDouble(6, vehicle.getOdometer());
            stmt.setDouble(7, vehicle.getPrice());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
