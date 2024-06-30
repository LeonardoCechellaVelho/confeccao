package org.ls.confeccao.repositories.brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ls.confeccao.config.AppException;
import org.ls.confeccao.config.SurrealConfig;
import org.ls.confeccao.data.entities.Brand;
import org.ls.confeccao.data.enums.Errors;
import org.ls.confeccao.data.enums.HttpErrors;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class BrandRepositoryImpl implements BrandRepository {

    private SurrealConfig driver;

    @Override
    public Brand persistBrand(Brand brand) {
        if (this.findBrandByCode(brand.getCode()).isEmpty()) {
            return driver.database().create("brand", brand);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCT_ALREADY_REGISTERED);
        }
    }

    @Override
    public Brand updateBrand(Brand brand) {
        List<Brand> brandFound = this.findBrandById(brand.getId());
        if (!brandFound.isEmpty()) {
            driver.database().update(brandFound.get(0).getId(), brand);
            return brand;
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCTS_NOT_FOUND);
        }
    }
    
    @Override
    public Brand getBrand(String code) {
        List<Brand> brand = this.findBrandByCode(code);
        if (!brand.isEmpty()) {
            return brand.get(0);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCT_NOT_FOUND);
        }
    }
    
    @Override
    public List<Brand> getBrands() {
        List<Brand> brands = driver.database().select("brand", Brand.class);
        if (!brands.isEmpty()) {
            return brands;
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCTS_NOT_FOUND);
        }
    }

    private List<Brand> findBrandByCode(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        return driver.database().query("SELECT * FROM brand WHERE code = $code", params, Brand.class).get(0).getResult();
    }

    private List<Brand> findBrandById(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return driver.database().query("SELECT * FROM brand WHERE id = $id", params, Brand.class).get(0).getResult();
    }

}
