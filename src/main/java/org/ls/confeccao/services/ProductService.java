package org.ls.confeccao.services;

import java.util.List;

import org.ls.confeccao.data.entities.Product;
import org.ls.confeccao.data.models.ProductModel;

public interface ProductService {
    Product addProduct(ProductModel request);
    Product updateProduct(Product request);
    Product getProduct(String code);
    List<Product> getProducts();
}
