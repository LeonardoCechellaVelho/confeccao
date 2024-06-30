package org.ls.confeccao.services;

import java.util.List;

import org.ls.confeccao.data.entities.Product;
import org.ls.confeccao.data.models.ProductModel;
import org.ls.confeccao.repositories.product.ProductRepository;
import org.ls.confeccao.validator.ValidatorService;
import org.ls.confeccao.validator.validators.EmptyValidator;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private ValidatorService validator;

    @Override
    public Product addProduct(ProductModel request) {
        validator.validateProduct(request);
        return this.repository.persistProduct(Product.from(request));
    }

    @Override
    public Product updateProduct(Product request) {
        validator.validateProduct(ProductModel.from(request));
        return this.repository.updateProduct(request);
    }
    
    @Override
    public Product getProduct(String code) {
        EmptyValidator.isValid(code, "Code");
        return this.repository.getProduct(code);
    }
    
    @Override
    public List<Product> getProducts() {
        return this.repository.getProducts();
    }
}
