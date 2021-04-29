package com.paramonga.capacitacion.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Ejemplo {
    private String nombres;
    private String apellidos;
    private String apellidosNombres;
    private String direccion;
    private String ruc;
}
