package com.ru.vsgutu.chapter13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ru.vsgutu.chapter13.crud.ProductCRUD;
import com.ru.vsgutu.chapter13.entity.*;
import com.ru.vsgutu.chapter13.projection.ProductWithParameters;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductQueryTest {

    private DatabaseConnection databaseConnection;
    private TableCreator tableCreator;
    private ProductCRUD productCRUD;
    private ProductQuery productQuery;

    @BeforeEach
    void setUp() throws SQLException {
        databaseConnection =
                new DatabaseConnection(
                        "jdbc:postgresql://localhost:5432/test_db", "postgres", "postgres");
        tableCreator = new TableCreator(databaseConnection);
        tableCreator.dropTables();
        tableCreator.createTablesTransaction();
        productCRUD = new ProductCRUD(databaseConnection);
        productQuery = new ProductQuery(databaseConnection);

        productCRUD.createProductGroup(new ProductGroup("Смартфоны"));
        productCRUD.createProductGroup(new ProductGroup("Телевизоры"));
        productCRUD.createParametersGroup(new ParameterGroup("Экран", 1));
        productCRUD.createParametersGroup(new ParameterGroup("Батарея", 1));
        productCRUD.createParameter(new Parameter("Размер", "дюйм", 1));
        productCRUD.createParameter(new Parameter("Вместимость", "mAh", 2));
        productCRUD.createProduct(new Product("iPhone 12", "Apple iPhone 12", new Date(), 1));
        productCRUD.createProduct(
                new Product("Samsung Galaxy S21", "Samsung Galaxy S21", new Date(), 1));
        productCRUD.createProduct(new Product("Sony Bravia", "Sony Bravia TV", new Date(), 2));
        productCRUD.createProductParameter(new ProductParameter(1, 1, "6.1"));
        productCRUD.createProductParameter(new ProductParameter(1, 2, "2815"));
        productCRUD.createProductParameter(new ProductParameter(2, 1, "6.2"));
        productCRUD.createProductParameter(new ProductParameter(2, 2, "3800"));
        productCRUD.createProductParameter(new ProductParameter(3, 1, "55"));
    }

    @AfterEach
    void tearDown() throws SQLException {
        productCRUD.deleteProductParameters(1);
        productCRUD.deleteProductParameters(2);
        productCRUD.deleteProductParameters(3);
        productCRUD.deleteProduct(1);
        productCRUD.deleteProduct(2);
        productCRUD.deleteProduct(3);
        productCRUD.deleteParameter(1);
        productCRUD.deleteParameter(2);
        productCRUD.deleteParametersGroup(1);
        productCRUD.deleteParametersGroup(2);
        productCRUD.deleteProductGroup(1);
        productCRUD.deleteProductGroup(2);
    }

    @Test
    void testGetParametersForProductGroup() throws SQLException {
        List<Parameter> parameters = productQuery.getParametersForProductGroup(1);
        assertEquals(2, parameters.size());
    }

    @Test
    void testGetProductsWithoutParameter() throws SQLException {
        List<Product> products = productQuery.getProductsWithoutParameter(1);
        assertEquals(0, products.size());
    }

    @Test
    void testGetProductInfoForGroup() throws SQLException {
        List<Product> products = productQuery.getProductInfoForGroup(1);
        assertEquals(2, products.size());
    }

    @Test
    void testGetProductInfoWithParameters() throws SQLException {
        List<ProductWithParameters> productWithParameters =
                productQuery.getProductInfoWithParameters(1);
        assertEquals(2, productWithParameters.size());
    }

    @Test
    void testDeleteProductsWithParameters() throws SQLException {
        productQuery.deleteProductsWithParameters(List.of(1));
        List<Product> products = productQuery.getProductInfoForGroup(1);
        assertEquals(0, products.size());
    }

    @Test
    void testMoveParametersGroup() throws SQLException {
        productQuery.moveParametersGroup(1, 2);
        List<Parameter> parameters = productQuery.getParametersForProductGroup(2);
        assertEquals(1, parameters.size());
    }
}
