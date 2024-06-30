package org.ls.confeccao.data.models;

import org.ls.confeccao.data.entities.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BrandModel {
    private String code;
    private String name;

    public static BrandModel from(Brand product) {
        return new BrandModel(product.getCode(), product.getName());
    }
}
