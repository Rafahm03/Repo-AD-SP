package com.example.Ejerciciojpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaPedidoId {

    private Pedido pedido;
    private int lineaId;

}
