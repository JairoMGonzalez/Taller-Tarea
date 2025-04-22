package com.jdc.tareas.rest;

import com.jdc.tareas.model.Tarea;
import com.jdc.tareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTareas() {
        return ResponseEntity.ok(tareaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Integer id) {
        return tareaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.guardar(tarea));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Integer id, @RequestBody Tarea tareaActualizada) {
        return tareaService.obtenerPorId(id).map(tareaExistente -> {
            tareaExistente.setTitulo(tareaActualizada.getTitulo());
            tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
            tareaExistente.setFechaEntrega(tareaActualizada.getFechaEntrega());
            tareaExistente.setEstado(tareaActualizada.getEstado());
            return ResponseEntity.ok(tareaService.guardar(tareaExistente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Integer id) {
        if (tareaService.obtenerPorId(id).isPresent()) {
            tareaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
