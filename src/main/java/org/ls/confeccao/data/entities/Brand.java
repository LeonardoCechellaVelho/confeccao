package org.ls.confeccao.data.entities;

import org.ls.confeccao.data.models.BrandModel;

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
public class Brand {
    private String id;
    private String code;
    private String name;

    public static Brand from(BrandModel brandModel) {
        return new Brand(null, brandModel.getCode().toString(), brandModel.getName());
    }
}
