package com.jdc.tareas.repository;


import com.jdc.tareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {



}
