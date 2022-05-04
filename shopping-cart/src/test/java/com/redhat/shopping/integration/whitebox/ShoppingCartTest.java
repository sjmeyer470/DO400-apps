package com.redhat.shopping.integration.whitebox;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.inject.Inject;
import com.redhat.shopping.cart.CartService;
import com.redhat.shopping.catalog.ProductNotFoundInCatalogException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ShoppingCartTest {
    

    @Inject CartService cartService;

    @BeforeEach
    void clearCart(){
        this.cartService.clear();
    }

    @Test
    void addingNonExistingProductInCatalogRaisesAnException(){
        assertThrows(
            ProductNotFoundInCatalogException.class,
            () -> this.cartService.addProduct(9999, 10)
        );
    }

}
