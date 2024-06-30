package org.ls.confeccao.services;

import java.util.List;

import org.ls.confeccao.data.entities.Costumer;
import org.ls.confeccao.data.models.CostumerModel;
import org.ls.confeccao.repositories.costumer.CostumerRepository;
import org.ls.confeccao.validator.ValidatorService;
import org.ls.confeccao.validator.validators.EmptyValidator;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class CostumerServiceImpl implements CostumerService {

    private final CostumerRepository repository;
    private ValidatorService validator;

    @Override
    public Costumer addCostumer(CostumerModel request) {
        validator.validateCostumer(request);
        return this.repository.persistCostumer(Costumer.from(request));
    }

    @Override
    public Costumer updateCostumer(Costumer request) {
        validator.validateCostumer(CostumerModel.from(request));
        return this.repository.updateCostumer(request);
    }
    
    @Override
    public Costumer getCostumer(String code) {
        EmptyValidator.isValid(code, "Code");
        return this.repository.getCostumer(code);
    }
    
    @Override
    public List<Costumer> getCostumers() {
        return this.repository.getCostumers();
    }
}
