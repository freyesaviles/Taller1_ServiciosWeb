package com.uam.taller1_serviciosweb.controllers;

import com.uam.taller1_serviciosweb.models.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1, "Café Tradicional", "50 g", "Café soluble", true));
        productos.add(new Producto(2, "Café Tradicional", "100 g", "Café soluble", true));
        productos.add(new Producto(3, "Café Tradicional", "200 g", "Café soluble", true));
        productos.add(new Producto(4, "Café Descafeinado", "50 g", "Descafeinado", true));
        productos.add(new Producto(5, "Café Descafeinado", "100 g", "Descafeinado", false));
        productos.add(new Producto(6, "Café con Canela", "50 g", "Café saborizado", true));
        productos.add(new Producto(7, "Café con Vainilla", "100 g", "Café saborizado", true));
        productos.add(new Producto(8, "Café Premium", "200 g", "Café soluble", false));
    }

    @GetMapping
    public List<Producto> consultarProductos() {
        return productos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarProductoPorId(@PathVariable int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
