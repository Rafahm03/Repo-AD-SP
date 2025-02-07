package com.example.Ejerciciojpa.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@IdClass(LineaPedidoId.class)
public class LineaPedido {

    @Id
    @GeneratedValue
    private Long id;

    @iD
    @ManyToOne


}
