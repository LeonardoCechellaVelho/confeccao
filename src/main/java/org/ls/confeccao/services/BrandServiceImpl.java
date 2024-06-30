package org.ls.confeccao.services;

import java.util.List;

import org.ls.confeccao.data.entities.Brand;
import org.ls.confeccao.data.models.BrandModel;
import org.ls.confeccao.repositories.brand.BrandRepository;
import org.ls.confeccao.validator.ValidatorService;
import org.ls.confeccao.validator.validators.EmptyValidator;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;
    private ValidatorService validator;

    @Override
    public Brand addBrand(BrandModel request) {
        validator.validateBrand(request);
        return this.repository.persistBrand(Brand.from(request));
    }

    @Override
    public Brand updateBrand(Brand request) {
        validator.validateBrand(BrandModel.from(request));
        return this.repository.updateBrand(request);
    }
    
    @Override
    public Brand getBrand(String code) {
        EmptyValidator.isValid(code, "Code");
        return this.repository.getBrand(code);
    }
    
    @Override
    public List<Brand> getBrands() {
        return this.repository.getBrands();
    }
}
