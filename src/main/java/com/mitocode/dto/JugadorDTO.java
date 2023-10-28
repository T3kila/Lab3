package com.mitocode.dto;


import com.mitocode.model.Posiciones;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    private Integer idplayer;

    @NotEmpty
    @Size(min = 3, message = "{name.size}")
    private String name;


    private Integer num;

    private Posiciones posiciones;


}
