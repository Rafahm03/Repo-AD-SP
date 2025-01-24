package com.example.ejercicio3.controller;

import com.example.ejercicio3.dto.EditEstacionDto;
import com.example.ejercicio3.model.Estacion;
import com.example.ejercicio3.service.EstacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estaciones/")
@RequiredArgsConstructor
@Tag(name = "Estacion", description = "El controlador de estaciones para gestionar todas las operaciones relacionadas con ellas")
public class EstacionController {


    private final EstacionService estacionService;

    @Operation(summary = "Obtiene todas las estaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado las estaciones",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Estacion.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "nombre": "Estación Central",
                                                "numero": 101,
                                                "coordenadas": "40.416775,-3.703790",
                                                "capacidad": 50,
                                                "listaBicicletas": []
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado estaciones"
            )
    })
    @GetMapping
    public List<Estacion> getAll() {
        return estacionService.findAll();
    }

    @Operation(summary = "Obtiene una estación por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la estación",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Estacion.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la estación con el ID proporcionado",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public Estacion getById(@PathVariable Long id) {
        return estacionService.findById(id);
    }

    @Operation(summary = "Crea una nueva estación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Estación creada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Estacion.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear la estación",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Estacion> create(@RequestBody EditEstacionDto nueva) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estacionService.save(nueva));
    }


    @Operation(summary = "Edita una estación existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Estación actualizada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Estacion.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la estación con el ID proporcionado",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public Estacion edit(@RequestBody EditEstacionDto editDto,
                         @PathVariable Long id) {
        return estacionService.update(id, editDto);
    }


    @Operation(summary = "Elimina una estación por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Estación eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la estación con el ID proporcionado",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}