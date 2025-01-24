package com.example.ejercicio3.controller;


import com.example.ejercicio3.dto.EditBicicletaDto;
import com.example.ejercicio3.model.Bicicleta;
import com.example.ejercicio3.service.BicicletaService;
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
@RequestMapping("/bicicleta/")
@RequiredArgsConstructor
@Tag(name = "Bicicleta", description = "El controlador de bicicletas para gestionar todas las operaciones relacionadas con ellas")
public class BicicletaController {

    private final BicicletaService bicicletaService;

    @Operation(summary = "Obtiene todas las bicicletas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado bicicletas",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EditBicicletaDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"marca": "Orbea", "estado": "Nueva", "modelo": "MX50"},
                                                {"marca": "Trek", "estado": "Usada", "modelo": "Domane"}
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se han encontrado bicicletas",
                    content = @Content)
    })
    @GetMapping
    public List<EditBicicletaDto> getAll() {
        return bicicletaService.findAllBicicleta()
                .stream()
                .map(EditBicicletaDto::of)
                .toList();
    }

    @Operation(summary = "Obtiene una bicicleta por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la bicicleta",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bicicleta.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la bicicleta con el ID proporcionado",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public Bicicleta getById(@PathVariable Long id) {
        return bicicletaService.findBicicleta(id);
    }

    @Operation(summary = "Crea una nueva bicicleta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Bicicleta creada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bicicleta.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Datos inválidos para crear la bicicleta",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Bicicleta> create(@RequestBody EditBicicletaDto nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bicicletaService.save(nuevo));
    }

    @Operation(summary = "Edita una bicicleta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Bicicleta actualizada con éxito",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bicicleta.class))}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la bicicleta con el ID proporcionado",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public Bicicleta edit(@RequestBody EditBicicletaDto aEditar, @PathVariable Long id) {
        return bicicletaService.edit(aEditar, id);
    }

    @Operation(summary = "Elimina una bicicleta por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Bicicleta eliminada con éxito",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la bicicleta con el ID proporcionado",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bicicletaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}