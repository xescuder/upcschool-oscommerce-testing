package upcschool.oscommerce.test;


import io.qameta.allure.Description;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Currency;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upcschool.oscommerce.model.Configuration;
import upcschool.oscommerce.model.ProductItem;
import upcschool.oscommerce.model.ShoppingCart;

class ShoppingCartPriceInDefaultCurrencyTest {

    static ShoppingCart sc1;
    static ShoppingCart sc2;


    @BeforeAll
    static void setUpBeforeClass() throws Exception {

        //Obtenemos la instancia de configuración
        Configuration c = Configuration.getInstance();

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        //Creamos un shopping cart
        sc1 = new ShoppingCart("MyFirstShoppingCart");

        //Creamos y añadimos product items
        ProductItem p1 = new ProductItem("Camiseta", 18, 1);
        ProductItem p2 = new ProductItem("Pantalones", 68, 1);
        sc1.addProductItem(p1);
        sc1.addProductItem(p2);


        //Creamos otro shopping cart
        sc2 = new ShoppingCart("MySecondShoppingCart");

        //Creamos y añadimos product items
        ProductItem p3 = new ProductItem("Blusa", 40, 2);
        ProductItem p4 = new ProductItem("Calcetines", 6, 3);
        sc2.addProductItem(p3);
        sc2.addProductItem(p4);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    @Description("Test total price with products with one quantity")
    void testSimplePrice() {
        assertEquals(86, sc1.totalPrice().getAmount());
        //fail("To be implemented in class as demonstration");
    }

    @Test
    @Description("Test total price with products with more than one quantity")
    void testPriceWithQuantities() {
        assertEquals(98, sc2.totalPrice().getAmount());
        //fail("To be implemented in class as demonstration");
    }

    @Test
    @Description("Test total price is recalculated when added new product")
    void addProductItemAndCheckPrice() {
        ProductItem p5 = new ProductItem("Camisa", 2, 2);
        sc1.addProductItem(p5);
        sc2.addProductItem(p5);
        assertEquals(90, sc1.totalPrice().getAmount());
        assertEquals(102, sc2.totalPrice().getAmount());
        //fail("To be implemented autonomously");
    }

    @Test
    @Description("Test total price is recalculated when removed a product")
    void removeProductItemAndCheckPrice() {
        sc1.removeProductItem(1);
        sc2.removeProductItem(1);
        assertEquals(18, sc1.totalPrice().getAmount());
        assertEquals(80, sc2.totalPrice().getAmount());
        //fail("To be implemented autonomously");
    }

    @Test
    @Description("Test total price in USD currency")
    void checkPriceWithOtherCurrencies() throws Exception {
        //Buscar un assert equals que nos de un margen de error
        assertEquals(111, sc2.totalPrice(Currency.getInstance("USD")).getAmount(), 10);
        //fail("To be implemented autonomously");
    }

}
