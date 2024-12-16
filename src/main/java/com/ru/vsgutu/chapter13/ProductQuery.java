package com.ru.vsgutu.chapter13;

import com.ru.vsgutu.chapter13.entity.Parameter;
import com.ru.vsgutu.chapter13.entity.Product;
import com.ru.vsgutu.chapter13.projection.ProductWithParameters;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductQuery {

    private final DatabaseConnection databaseConnection;

    public ProductQuery(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Parameter> getParametersForProductGroup(int productGroupId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query =
                "SELECT * FROM parameters WHERE parameters_group_id IN "
                        + "(SELECT id FROM parameters_groups WHERE product_group_id = "
                        + productGroupId
                        + ")";
        ResultSet resultSet = statement.executeQuery(query);
        List<Parameter> parameters = new ArrayList<>();
        while (resultSet.next()) {
            Parameter parameter = new Parameter();
            parameter.setId(resultSet.getInt("id"));
            parameter.setName(resultSet.getString("name"));
            parameter.setUnitOfMeasurement(resultSet.getString("unit_of_measurement"));
            parameters.add(parameter);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return parameters;
    }

    public List<Product> getProductsWithoutParameter(int parameterId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query =
                "SELECT * FROM products WHERE id NOT IN "
                        + "(SELECT product_id FROM product_parameters WHERE parameter_id = "
                        + parameterId
                        + ")";
        ResultSet resultSet = statement.executeQuery(query);
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setReleaseDate(resultSet.getDate("release_date"));
            product.setGroupId(resultSet.getInt("product_group_id"));
            products.add(product);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return products;
    }

    public List<Product> getProductInfoForGroup(int productGroupId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM products WHERE product_group_id = " + productGroupId;
        ResultSet resultSet = statement.executeQuery(query);
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setReleaseDate(resultSet.getDate("release_date"));
            product.setGroupId(resultSet.getInt("product_group_id"));
            products.add(product);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return products;
    }

    public List<ProductWithParameters> getProductInfoWithParameters(int productId)
            throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query =
                "SELECT p.id AS product_id, p.name AS product_name, p.description, p.release_date, "
                        + "pr.name AS parameter_name, pr.unit_of_measurement, pp.value FROM products p "
                        + "JOIN product_parameters pp ON p.id = pp.product_id "
                        + "JOIN parameters pr ON pp.parameter_id = pr.id WHERE p.id = "
                        + productId;
        ResultSet resultSet = statement.executeQuery(query);
        List<ProductWithParameters> products = new ArrayList<>();
        while (resultSet.next()) {
            ProductWithParameters product = new ProductWithParameters();
            product.setId(resultSet.getInt("product_id"));
            product.setName(resultSet.getString("product_name"));
            product.setDescription(resultSet.getString("description"));
            product.setReleaseDate(resultSet.getDate("release_date"));
            product.setParameterName(resultSet.getString("parameter_name"));
            product.setUnitOfMeasurement(resultSet.getString("unit_of_measurement"));
            product.setValue(resultSet.getString("value"));
            products.add(product);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return products;
    }

    public void deleteProductsWithParameters(List<Integer> parameterIds) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query =
                "DELETE FROM products WHERE id IN "
                        + "(SELECT product_id FROM product_parameters WHERE parameter_id IN ("
                        + String.join(
                                ",",
                                parameterIds.stream().map(Object::toString).toArray(String[]::new))
                        + "))";
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    public void moveParametersGroup(int parametersGroupId, int newProductGroupId)
            throws SQLException {
        Connection connection = databaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String query =
                "UPDATE parameters_groups SET product_group_id = "
                        + newProductGroupId
                        + " WHERE id = "
                        + parametersGroupId;
        statement.executeUpdate(query);
        statement.close();
        connection.close();
    }
}
