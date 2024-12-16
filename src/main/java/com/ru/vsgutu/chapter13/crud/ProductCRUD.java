package com.ru.vsgutu.chapter13.crud;

import com.ru.vsgutu.chapter13.DatabaseConnection;
import com.ru.vsgutu.chapter13.entity.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductCRUD {

    private final DatabaseConnection databaseConnection;

    public ProductCRUD(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createProduct(Product product) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String insertProductQuery =
                "INSERT INTO products (name, description, release_date, product_group_id) "
                        + "VALUES ('"
                        + product.getName()
                        + "', '"
                        + product.getDescription()
                        + "', '"
                        + new java.sql.Date(product.getReleaseDate().getTime())
                        + "', "
                        + product.getGroupId()
                        + ")";
        statement.executeUpdate(insertProductQuery);
        statement.close();
        connection.close();
    }

    public void createProductGroup(ProductGroup productGroup) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String insertProductQuery =
                "INSERT INTO product_groups (name) VALUES ('" + productGroup.getName() + "')";
        statement.executeUpdate(insertProductQuery);
        statement.close();
        connection.close();
    }

    public void createParametersGroup(ParameterGroup parameterGroup) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String insertQuery =
                "INSERT INTO parameters_groups (name, product_group_id) VALUES ('"
                        + parameterGroup.getName()
                        + "', "
                        + parameterGroup.getProductGroupId()
                        + ")";
        statement.executeUpdate(insertQuery);
        statement.close();
        connection.close();
    }

    public void createParameter(Parameter parameter) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String insertQuery =
                "INSERT INTO parameters (name, unit_of_measurement, parameters_group_id) VALUES ('"
                        + parameter.getName()
                        + "', '"
                        + parameter.getUnitOfMeasurement()
                        + "', "
                        + parameter.getParameterGroupId()
                        + ")";
        statement.executeUpdate(insertQuery);
        statement.close();
        connection.close();
    }

    public void createProductParameter(ProductParameter productParameter) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String insertQuery =
                "INSERT INTO product_parameters (product_id, parameter_id, value) VALUES ("
                        + productParameter.getProductId()
                        + ", "
                        + productParameter.getParameterId()
                        + ", '"
                        + productParameter.getValue()
                        + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        connection.close();
    }

    public Product getProductById(int productId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String selectProductQuery = "SELECT * FROM products WHERE id = " + productId;
        ResultSet resultSet = statement.executeQuery(selectProductQuery);
        Product product = null;
        if (resultSet.next()) {
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setReleaseDate(resultSet.getDate("release_date"));
            product.setGroupId(resultSet.getInt("product_group_id"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return product;
    }

    public void updateProduct(Product product) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String updateProductQuery =
                "UPDATE products SET name = '"
                        + product.getName()
                        + "', description = '"
                        + product.getDescription()
                        + "', "
                        + "release_date = '"
                        + new java.sql.Date(product.getReleaseDate().getTime())
                        + "', product_group_id = "
                        + product.getGroupId()
                        + " WHERE id = "
                        + product.getId();
        statement.executeUpdate(updateProductQuery);
        statement.close();
        connection.close();
    }

    public void deleteProduct(int productId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String deleteProductQuery = "DELETE FROM products WHERE id = " + productId;
        statement.executeUpdate(deleteProductQuery);
        statement.close();
        connection.close();
    }

    public void deleteProductParameters(int productId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String deleteQuery = "DELETE FROM product_parameters WHERE product_id = " + productId;
        statement.executeUpdate(deleteQuery);
        statement.close();
        connection.close();
    }

    public void deleteParameter(int parameterId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String deleteQuery = "DELETE FROM parameters WHERE id = " + parameterId;
        statement.executeUpdate(deleteQuery);
        statement.close();
        connection.close();
    }

    public void deleteParametersGroup(int parametersGroupId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String deleteQuery = "DELETE FROM parameters_groups WHERE id = " + parametersGroupId;
        statement.executeUpdate(deleteQuery);
        statement.close();
        connection.close();
    }

    public void deleteProductGroup(int productGroupId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String deleteQuery = "DELETE FROM product_groups WHERE id = " + productGroupId;
        statement.executeUpdate(deleteQuery);
        statement.close();
        connection.close();
    }
}
