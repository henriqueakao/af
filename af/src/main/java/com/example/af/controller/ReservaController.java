package com.example.af.controller;

import com.example.af.model.Reserva;
import com.example.af.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController 
{
    @Autowired
    private ReservaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id) 
    {
        Reserva reserva = service.getReservaById(id);  

        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Reserva> getReservaByCliente(@PathVariable int id) 
    {
        Reserva reserva = service.getReservaByCliente(id);  
           
        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<Reserva> getReservaByVeiculo(@PathVariable int id) 
    {
        Reserva reserva = service.getReservaByVeiculo(id);  
           
        return ResponseEntity.ok(reserva);
    }

}
