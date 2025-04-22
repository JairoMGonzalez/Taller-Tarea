package com.jdc.tareas.service;

import com.jdc.tareas.model.Tarea;

import java.util.List;
import java.util.Optional;


public interface TareaService {
    List<Tarea> obtenerTodas();
    Optional<Tarea> obtenerPorId(Integer id);
    Tarea guardar(Tarea tarea);
    void eliminar(Integer id);
}
