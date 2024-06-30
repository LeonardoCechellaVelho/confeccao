package org.ls.confeccao.services;

import java.util.List;

import org.ls.confeccao.data.entities.Costumer;
import org.ls.confeccao.data.models.CostumerModel;

public interface CostumerService {
    Costumer addCostumer(CostumerModel request);
    Costumer updateCostumer(Costumer request);
    Costumer getCostumer(String code);
    List<Costumer> getCostumers();
}
