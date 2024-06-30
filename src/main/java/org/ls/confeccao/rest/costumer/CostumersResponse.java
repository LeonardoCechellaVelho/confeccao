package org.ls.confeccao.rest.costumer;

import java.util.List;
import org.ls.confeccao.data.entities.Costumer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CostumersResponse {
    
    private List<Costumer> costumers;
}
