package org.ls.confeccao.repositories.costumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ls.confeccao.config.AppException;
import org.ls.confeccao.config.SurrealConfig;
import org.ls.confeccao.data.entities.Costumer;
import org.ls.confeccao.data.enums.Errors;
import org.ls.confeccao.data.enums.HttpErrors;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class CostumerRepositoryImpl implements CostumerRepository {

    private SurrealConfig driver;

    @Override
    public Costumer persistCostumer(Costumer costumer) {
        if (this.findCostumerByCode(costumer.getCode()).isEmpty()) {
            return driver.database().create("costumer", costumer);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCT_ALREADY_REGISTERED);
        }
    }

    @Override
    public Costumer updateCostumer(Costumer costumer) {
        List<Costumer> costumerFound = this.findCostumerById(costumer.getId());
        if (!costumerFound.isEmpty()) {
            driver.database().update(costumerFound.get(0).getId(), costumer);
            return costumer;
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCTS_NOT_FOUND);
        }
    }
    
    @Override
    public Costumer getCostumer(String code) {
        List<Costumer> costumer = this.findCostumerByCode(code);
        if (!costumer.isEmpty()) {
            return costumer.get(0);
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCT_NOT_FOUND);
        }
    }
    
    @Override
    public List<Costumer> getCostumers() {
        List<Costumer> costumers = driver.database().select("costumer", Costumer.class);
        if (!costumers.isEmpty()) {
            return costumers;
        } else {
            throw new AppException(HttpErrors.BAD_REQUEST.getCode(), Errors.PRODUCTS_NOT_FOUND);
        }
    }

    private List<Costumer> findCostumerByCode(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        return driver.database().query("SELECT * FROM costumer WHERE code = $code", params, Costumer.class).get(0).getResult();
    }

    private List<Costumer> findCostumerById(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return driver.database().query("SELECT * FROM costumer WHERE id = $id", params, Costumer.class).get(0).getResult();
    }

}
