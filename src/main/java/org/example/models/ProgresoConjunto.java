package org.example.models;

import java.time.LocalDateTime;

public class ProgresoConjunto {
    private int idProgreso;
    private int paginasLeidas;
    private int paginaActual;
    private int porcentaje;
    private boolean abandonado;
    private boolean terminado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinalizacion;
}
