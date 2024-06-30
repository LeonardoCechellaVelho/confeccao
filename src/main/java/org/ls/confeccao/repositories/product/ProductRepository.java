package org.ls.confeccao.repositories.product;


import java.util.List;

import org.ls.confeccao.data.entities.Product;

public interface ProductRepository {

    Product persistProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(String code);
    List<Product> getProducts();
}
