package ru.kpfu.itis.controllers.exceptions;

import ru.kpfu.itis.models.Product;

public class NotEnoughProductsInStockException extends Exception {
    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NotEnoughProductsInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductsInStockException(Product product) {
        super("Not enough of " + product.getName() + " in stock. Only " + product.getQuantity() + " left");
    }
}
