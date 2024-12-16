package com.ru.vsgutu.chapter13;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    private final DatabaseConnection databaseConnection;

    public TableCreator(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void dropTables() throws SQLException {
        Connection connection = databaseConnection.getConnection();
        connection.setAutoCommit(false);

        try {
            String dropProductParametersTable = "DROP TABLE IF EXISTS product_parameters";
            String dropProductsTable = "DROP TABLE IF EXISTS products";
            String dropParametersTable = "DROP TABLE IF EXISTS parameters";
            String dropParametersGroupTable = "DROP TABLE IF EXISTS parameters_groups";
            String dropProductGroupTable = "DROP TABLE IF EXISTS product_groups";

            executeQuery(connection, dropProductParametersTable);
            executeQuery(connection, dropProductsTable);
            executeQuery(connection, dropParametersTable);
            executeQuery(connection, dropParametersGroupTable);
            executeQuery(connection, dropProductGroupTable);

            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
    }

    public void createTablesTransaction() throws SQLException {
        Connection connection = databaseConnection.getConnection();
        connection.setAutoCommit(false);

        try {
            String createProductGroupTable =
                    "CREATE TABLE IF NOT EXISTS product_groups ("
                            + "id SERIAL PRIMARY KEY,"
                            + "name VARCHAR(255) NOT NULL"
                            + ")";

            String createParametersGroupTable =
                    "CREATE TABLE IF NOT EXISTS parameters_groups ("
                            + "id SERIAL PRIMARY KEY,"
                            + "name VARCHAR(255) NOT NULL,"
                            + "product_group_id INT,"
                            + "FOREIGN KEY (product_group_id) REFERENCES product_groups(id)"
                            + ")";

            String createParametersTable =
                    "CREATE TABLE IF NOT EXISTS parameters ("
                            + "id SERIAL PRIMARY KEY,"
                            + "name VARCHAR(255) NOT NULL,"
                            + "unit_of_measurement VARCHAR(255),"
                            + "parameters_group_id INT,"
                            + "FOREIGN KEY (parameters_group_id) REFERENCES parameters_groups(id)"
                            + ")";

            String createProductsTable =
                    "CREATE TABLE IF NOT EXISTS products ("
                            + "id SERIAL PRIMARY KEY,"
                            + "name VARCHAR(255) NOT NULL,"
                            + "description TEXT,"
                            + "release_date DATE,"
                            + "product_group_id INT,"
                            + "FOREIGN KEY (product_group_id) REFERENCES product_groups(id)"
                            + ")";

            String createProductParametersTable =
                    "CREATE TABLE IF NOT EXISTS product_parameters ("
                            + "product_id INT,"
                            + "parameter_id INT,"
                            + "value VARCHAR(255),"
                            + "FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,"
                            + "FOREIGN KEY (parameter_id) REFERENCES parameters(id) ON DELETE CASCADE"
                            + ")";

            executeQuery(connection, createProductGroupTable);
            executeQuery(connection, createParametersGroupTable);
            executeQuery(connection, createParametersTable);
            executeQuery(connection, createProductsTable);
            executeQuery(connection, createProductParametersTable);

            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
    }

    private void executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }
}
