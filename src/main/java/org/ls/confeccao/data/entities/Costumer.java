package org.ls.confeccao.data.entities;

import org.ls.confeccao.data.models.CostumerModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class Costumer {
    private String id;
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

    public static Costumer from(CostumerModel costumerModel) {
        return new Costumer(
            null,
            costumerModel.getCode(),
            costumerModel.getName(),
            costumerModel.getAddress(),
            costumerModel.getPostalcode(),
            costumerModel.getDocumentNumber(),
            costumerModel.getStateInscription(),
            costumerModel.getEmail(),
            costumerModel.getTelephone(),
            costumerModel.getCity(),
            costumerModel.getState(),
            costumerModel.getReference()
        );
    }
}
