package com.example.loginback.Controller;


import com.example.loginback.Entity.Categoria;

import com.example.loginback.IService.CategoriaService;
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
@RequestMapping("api/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private CategoriaService categoriaService;


    @Operation(summary = "Obtener todos los Categoria")
    @ApiResponse(responseCode = "200", description = "Éxito al obtener todos los Categoria",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "403", description = "Acceso denegado debido a permisos insuficientes", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)})

    @GetMapping()
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    //-------------------------------------------------------------------------------------------------------------
    @Operation(summary = "Mostrar por Id Categoria especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Categoria.class))
                    }),
            @ApiResponse(responseCode = "500", description = "id invalid", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Categoria> findById(@Parameter(description = "id de Categoria ", example = "1") @PathVariable Long id) {
        return categoriaService.findById(id);
    }
    //----------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Crear Categorias en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria creado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Categoria.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })
    @PostMapping("/guardar")
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }
    //------------------------------------------------------------------------------------------

    @Operation(summary = "Actualizar Categorias prolongados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria actualizado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Categoria.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error de response", content = @Content)


    })
    @PutMapping("editar/{id}")
    public void update(@RequestBody Categoria categoria, @PathVariable Long id) {
        categoriaService.update(id, categoria);

    }

    //---------------------------------------------------------------------------
    @Operation(summary = "eliminar Categoria de la base de datos por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria eliminado con exito",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Categoria.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error de parametros", content = @Content),


    })
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }


}
