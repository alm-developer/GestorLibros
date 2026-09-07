package org.example.models;

import org.example.utils.adicionales.Estado;

import java.time.LocalDateTime;

public class UsuarioLecturaConjunta {
    private int idUsuario;
    private int idLecturaConjunta;
    private Estado estado;
    private LocalDateTime ultimaEntrada;
    private LocalDateTime fechaEntrada;
    private int idProgresoConjunto;
}
