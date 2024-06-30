package org.ls.confeccao.repositories.brand;


import java.util.List;

import org.ls.confeccao.data.entities.Brand;

public interface BrandRepository {

    Brand persistBrand(Brand brand);
    Brand updateBrand(Brand brand);
    Brand getBrand(String code);
    List<Brand> getBrands();
}
