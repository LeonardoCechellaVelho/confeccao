package org.ls.confeccao.repositories.costumer;


import java.util.List;

import org.ls.confeccao.data.entities.Costumer;

public interface CostumerRepository {

    Costumer persistCostumer(Costumer costumer);
    Costumer updateCostumer(Costumer costumer);
    Costumer getCostumer(String code);
    List<Costumer> getCostumers();
}
