package com.mitocode.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idplayer;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer num;

    @ManyToOne
    @JoinColumn(name = "idPosicion")
    private Posiciones posiciones;


}
