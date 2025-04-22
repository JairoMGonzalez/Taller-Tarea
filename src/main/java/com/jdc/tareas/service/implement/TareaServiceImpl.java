package com.jdc.tareas.service.implement;

import com.jdc.tareas.model.Tarea;
import com.jdc.tareas.repository.TareaRepository;
import com.jdc.tareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> obtenerPorId(Integer id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminar(Integer id) {
        tareaRepository.deleteById(id);
    }
}
