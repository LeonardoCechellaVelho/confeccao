package org.ls.confeccao.data.models;

import java.util.List;

import org.ls.confeccao.data.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductModel {
    private String code;
    private String name;
    private List<String> sizes;

    
    public static ProductModel from(Product product) {
        return new ProductModel(product.getCode(), product.getName(), product.getSizes());
    }
}
