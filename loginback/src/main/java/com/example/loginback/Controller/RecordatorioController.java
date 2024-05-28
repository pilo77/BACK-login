package com.example.loginback.Controller;

import com.example.loginback.Entity.Recordatorio;
import com.example.loginback.IService.RecordatorioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recordatorio")
@RequiredArgsConstructor
public class RecordatorioController {

    private final RecordatorioService recordatorioService;


    @Operation(summary = "Obtener todos los recordatorio")
    @ApiResponse(responseCode = "200", description = "Éxito al obtener todos los recordatorio",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Recordatorio.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "403", description = "Acceso denegado debido a permisos insuficientes", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)})

    @GetMapping()
    public List<Recordatorio> findAll() {
        return recordatorioService.findAll();
    }

    //-------------------------------------------------------------------------------------------------------------
    @Operation(summary = "Mostrar por Id recordatorio especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "recordatorio encontrado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Recordatorio.class))
                    }),
            @ApiResponse(responseCode = "500", description = "id invalid", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Recordatorio> findById(@Parameter(description = "id de recordatorio ", example = "1") @PathVariable Long id) {
        return recordatorioService.findById(id);
    }
    //----------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Crear Recordatorios en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recordatorio creado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Recordatorio.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })
    @PostMapping("/guardar")
    public Recordatorio save(@RequestBody Recordatorio recordatorio) {
        return recordatorioService.save(recordatorio);
    }
    //------------------------------------------------------------------------------------------

    @Operation(summary = "Actualizar Recordatorios prolongados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recordatorio actualizado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Recordatorio.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })
    @PutMapping("editar/{id}")
    public void update(@RequestBody Recordatorio recordatorio, @PathVariable Long id) {
        recordatorioService.update(id, recordatorio);

    }

    //---------------------------------------------------------------------------


//-------------------------------------------------------------------------------

}