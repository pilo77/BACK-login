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

    @Operation(summary = "Mostrar todos los recordatorios")
    @GetMapping("/recordatorios")
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
    @Operation(summary = "eliminar recordatorio de la base de datos por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recordatorio eliminado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Recordatorio.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),


    })
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Long id) {
        recordatorioService.delete(id);
    }

//-------------------------------------------------------------------------------

    @Operation(summary = "Contar el número total de recordatorios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Éxito al obtener el número total de recordatorios",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontraron recordatorios",
                    content = @Content)
    })
    @GetMapping("/count")
    public Long countRecordatorios() {
        return recordatorioService.countRecordatorios();
    }
}