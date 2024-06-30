package org.ls.confeccao.rest.product;

import java.util.List;

import org.ls.confeccao.data.entities.Product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductsResponse {
    
    private List<Product> products;
}
