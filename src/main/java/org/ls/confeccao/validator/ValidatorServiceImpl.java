package org.ls.confeccao.validator;

import org.ls.confeccao.data.models.BrandModel;
import org.ls.confeccao.data.models.CostumerModel;
import org.ls.confeccao.data.models.ProductModel;
import org.ls.confeccao.validator.validators.EmptyValidator;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void validateProduct(ProductModel product) {
        EmptyValidator.isValid(product.getName(), "Name");
        EmptyValidator.isValid(product.getCode(), "Code");
        EmptyValidator.isValid(product.getSizes(), "Sizes");
    }

    @Override
    public void validateBrand(BrandModel brand) {
        EmptyValidator.isValid(brand.getName(), "Name");
        EmptyValidator.isValid(brand.getCode(), "Code");
    }

    @Override
    public void validateCostumer(CostumerModel costumer) {
        EmptyValidator.isValid(costumer.getName(), "Name");
        EmptyValidator.isValid(costumer.getCode(), "Code");
        EmptyValidator.isValidNullable(costumer.getAddress(), "Address");
        EmptyValidator.isValidNullable(costumer.getPostalcode(), "Postalcode");
        EmptyValidator.isValidNullable(costumer.getDocumentNumber(), "DocumentNumber");
        EmptyValidator.isValidNullable(costumer.getStateInscription(), "StateInscription");
        EmptyValidator.isValidNullable(costumer.getEmail(), "Email");
        EmptyValidator.isValidNullable(costumer.getTelephone(), "Telephone");
        EmptyValidator.isValidNullable(costumer.getCity(), "City");
        EmptyValidator.isValidNullable(costumer.getState(), "State");
        EmptyValidator.isValidNullable(costumer.getReference(), "Reference");
    }
    
}
