package com.example.af.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.example.af.model.*;
import com.example.af.service.*;
import com.example.af.dto.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/clientes")
public class VeiculoController 
{
    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> getVeiculos() 
    {
        return service.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable int id) 
    {
        Veiculo cliente = service.getVeiculoById(id);    

        return ResponseEntity.ok(cliente);
    }


    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody VeiculoDTO clienteDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) 
    {
         Veiculo cliente = service.fromDTO(clienteDTO);
         cliente = service.save(cliente);
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+cliente.getId()).build();

         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@RequestBody VeiculoDTO clienteDTO, @PathVariable int id)
    { 
        Veiculo cliente = service.fromDTO(clienteDTO);
        cliente.setId(id);
        cliente = service.update(cliente);
        
        return ResponseEntity.ok(cliente);
    }
}