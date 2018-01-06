package ru.kpfu.itis.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.models.Product;

public interface ProductsService {
    Product findById(Long id);
    Page<Product> findAllProductsPageable(Pageable pageable);
}
