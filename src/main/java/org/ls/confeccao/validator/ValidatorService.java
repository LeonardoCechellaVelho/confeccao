package org.ls.confeccao.validator;

import org.ls.confeccao.data.models.BrandModel;
import org.ls.confeccao.data.models.CostumerModel;
import org.ls.confeccao.data.models.ProductModel;

public interface ValidatorService {
    void validateProduct(ProductModel product);
    void validateBrand(BrandModel brand);
    void validateCostumer(CostumerModel costumer);
}
