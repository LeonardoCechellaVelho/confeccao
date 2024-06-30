package org.ls.confeccao.data.entities;

import java.util.List;

import org.ls.confeccao.data.models.ProductModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class Product {
    private String id;
    private String code;
    private String name;
    private List<String> sizes;

    public static Product from(ProductModel productModel) {
        return new Product(null, productModel.getCode().toString(), productModel.getName(), productModel.getSizes());
    }
}
