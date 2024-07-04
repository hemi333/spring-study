package com.example.mySelectShop.repository;

import com.example.mySelectShop.entity.Folder;
import com.example.mySelectShop.entity.Product;
import com.example.mySelectShop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}
