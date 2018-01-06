package ru.kpfu.itis.services;

import ru.kpfu.itis.controllers.exceptions.NotEnoughProductsInStockException;
import ru.kpfu.itis.models.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {
    void addProduct(Product product);
    void removeProduct(Product product);
    Map<Product, Integer> getProductsInCart();
    void checkout() throws NotEnoughProductsInStockException;
    BigDecimal getTotal();
}
