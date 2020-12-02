package com.example.af.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
public class ClienteController 
{
    @Autowired
    private ClienteService service;

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Cliente> getClientes() 
    {
        return service.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) 
    {
        Cliente cliente = service.getClienteById(id);     
        
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO clienteDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) 
    {
         Cliente cliente = service.fromDTO(clienteDTO);
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
    public ResponseEntity<Cliente> update(@RequestBody ClienteDTO clienteDTO, @PathVariable int id)
    { 
        Cliente cliente = service.fromDTO(clienteDTO);
        cliente.setId(id);
        cliente = service.update(cliente);

        return ResponseEntity.ok(cliente);
    }

    @PostMapping("{idCliente}/veiculos/{idVeiculo}")
    public ResponseEntity<Reserva> salvar(  @PathVariable int idCliente,
                                            @PathVariable int idVeiculo,
                                           @RequestBody Reserva reserva,
                                           @RequestBody LocalDate dataFim,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) 
    {
         reservaService.save(reserva, dataFim, idCliente, idVeiculo);                                    
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+reserva.getId()).build();

         if(dataFim.getDayOfWeek().equals(DayOfWeek.SUNDAY))
         {
             System.out.println("Domingo!");
         }

         return ResponseEntity.created(uriComponents.toUri()).build();
    }
}