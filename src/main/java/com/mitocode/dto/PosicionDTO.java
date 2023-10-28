package com.mitocode.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDTO {


    private Integer idPosicion;

    @NotEmpty
    @Size(min = 3, message = "{name.size}")
    private String name;
}
