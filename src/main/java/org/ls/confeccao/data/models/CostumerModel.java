package org.ls.confeccao.data.models;

import org.ls.confeccao.data.entities.Costumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CostumerModel {
    private String code;
    private String name;
    private String address;
    private String postalcode;
    private String documentNumber;
    private String stateInscription;
    private String email;
    private String telephone;
    private String city;
    private String state;
    private String reference;

    
    public static CostumerModel from(Costumer costumer) {
        return new CostumerModel(
            costumer.getCode(),
            costumer.getName(),
            costumer.getAddress(),
            costumer.getPostalcode(),
            costumer.getDocumentNumber(),
            costumer.getStateInscription(),
            costumer.getEmail(),
            costumer.getTelephone(),
            costumer.getCity(),
            costumer.getState(),
            costumer.getReference()
        );
    }
}
