package org.ls.confeccao.services;

import java.util.List;

import org.ls.confeccao.data.entities.Brand;
import org.ls.confeccao.data.models.BrandModel;

public interface BrandService {
    Brand addBrand(BrandModel request);
    Brand updateBrand(Brand request);
    Brand getBrand(String code);
    List<Brand> getBrands();
}
