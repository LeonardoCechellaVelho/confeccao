package org.ls.confeccao.rest.brand;

import java.util.List;

import org.ls.confeccao.data.entities.Brand;
import org.ls.confeccao.data.models.BrandModel;
import org.ls.confeccao.services.BrandService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/brand")
public class BrandRestImpl implements BrandRest {
    
    BrandService service;

    @Override
    @Transactional
    public BrandResponse addBrand(BrandModel request) {
        Brand brand = service.addBrand(request);
        return BrandResponse.builder().brand(brand).build();
    }

    @Override
    @Transactional
    public BrandResponse updateBrand(Brand request) {
        Brand brand = service.updateBrand(request);
        return BrandResponse.builder().brand(brand).build();
    }

    @Override
    @Transactional
    public BrandResponse getBrand(String code) {
        Brand brand = service.getBrand(code);
        return BrandResponse.builder().brand(brand).build();
    }

    @Override
    @Transactional
    public BrandsResponse getBrands() {
        List<Brand> brands = service.getBrands();
        return BrandsResponse.builder().brands(brands).build();
    }
}
