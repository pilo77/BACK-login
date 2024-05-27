package com.example.loginback.Controller;


import com.example.loginback.IService.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

}
