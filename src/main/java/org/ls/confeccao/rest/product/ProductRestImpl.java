package org.ls.confeccao.rest.product;

import java.util.List;

import org.ls.confeccao.data.entities.Product;
import org.ls.confeccao.data.models.ProductModel;
import org.ls.confeccao.services.ProductService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/product")
public class ProductRestImpl implements ProductRest {
    
    ProductService service;

    @Override
    @Transactional
    public ProductResponse addProduct(ProductModel request) {
        Product product = service.addProduct(request);
        return ProductResponse.builder().product(product).build();
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Product request) {
        Product product = service.updateProduct(request);
        return ProductResponse.builder().product(product).build();
    }

    @Override
    @Transactional
    public ProductResponse getProduct(String code) {
        Product product = service.getProduct(code);
        return ProductResponse.builder().product(product).build();
    }

    @Override
    @Transactional
    public ProductsResponse getProducts() {
        List<Product> products = service.getProducts();
        return ProductsResponse.builder().products(products).build();
    }
}
