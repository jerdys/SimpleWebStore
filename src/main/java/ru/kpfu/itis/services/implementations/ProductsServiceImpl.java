package ru.kpfu.itis.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.models.Product;
import ru.kpfu.itis.repositories.ProductsRepository;
import ru.kpfu.itis.services.ProductsService;

public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Product findById(Long id) {
        return productsRepository.findOne(id);
    }

    @Override
    public Page<Product> findAllProductsPageable(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }
}
