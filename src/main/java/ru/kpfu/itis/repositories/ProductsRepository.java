package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
