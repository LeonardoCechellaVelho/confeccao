package org.ls.confeccao.repositories.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ls.confeccao.config.AppException;
import org.ls.confeccao.config.SurrealConfig;
import org.ls.confeccao.data.entities.Product;
import org.ls.confeccao.data.enums.Errors;
import org.ls.confeccao.data.enums.HttpErrors;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository {

    private SurrealConfig driver;

    @Override
    public Product persistProduct(Product product) {
        if (this.findProductByCode(product.getCode()).isEmpty()) {
            return driver.database().create("product", product);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCT_ALREADY_REGISTERED);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        List<Product> productFound = this.findProductById(product.getId());
        if (!productFound.isEmpty()) {
            driver.database().update(productFound.get(0).getId(), product);
            return product;
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCTS_NOT_FOUND);
        }
    }
    
    @Override
    public Product getProduct(String code) {
        List<Product> product = this.findProductByCode(code);
        if (!product.isEmpty()) {
            return product.get(0);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCT_NOT_FOUND);
        }
    }
    
    @Override
    public List<Product> getProducts() {
        List<Product> products = driver.database().select("product", Product.class);
        if (!products.isEmpty()) {
            return products;
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCTS_NOT_FOUND);
        }
    }

    private List<Product> findProductByCode(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        return driver.database().query("SELECT * FROM product WHERE code = $code", params, Product.class).get(0).getResult();
    }

    private List<Product> findProductById(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return driver.database().query("SELECT * FROM product WHERE id = $id", params, Product.class).get(0).getResult();
    }

}
