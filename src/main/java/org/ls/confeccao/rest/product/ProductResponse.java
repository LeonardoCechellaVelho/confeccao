package org.ls.confeccao.rest.product;

import org.ls.confeccao.data.entities.Product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponse {

    private Product product;
}
