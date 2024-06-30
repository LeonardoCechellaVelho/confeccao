package org.ls.confeccao.rest.brand;

import org.ls.confeccao.data.entities.Brand;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BrandResponse {

    private Brand brand;
}
