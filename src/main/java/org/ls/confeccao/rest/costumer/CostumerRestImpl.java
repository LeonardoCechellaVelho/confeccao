package org.ls.confeccao.rest.costumer;

import java.util.List;

import org.ls.confeccao.data.entities.Costumer;
import org.ls.confeccao.data.models.CostumerModel;
import org.ls.confeccao.services.CostumerService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/costumer")
public class CostumerRestImpl implements CostumerRest {
    
    CostumerService service;

    @Override
    @Transactional
    public CostumerResponse addCostumer(CostumerModel request) {
        Costumer costumer = service.addCostumer(request);
        return CostumerResponse.builder().costumer(costumer).build();
    }

    @Override
    @Transactional
    public CostumerResponse updateCostumer(Costumer request) {
        Costumer costumer = service.updateCostumer(request);
        return CostumerResponse.builder().costumer(costumer).build();
    }

    @Override
    @Transactional
    public CostumerResponse getCostumer(String code) {
        Costumer costumer = service.getCostumer(code);
        return CostumerResponse.builder().costumer(costumer).build();
    }

    @Override
    @Transactional
    public CostumersResponse getCostumers() {
        List<Costumer> costumers = service.getCostumers();
        return CostumersResponse.builder().costumers(costumers).build();
    }
}
