package com.example.af.service;

import com.example.af.repository.*;
import com.example.af.model.*;

import java.util.List;
import java.util.Optional;

import com.example.af.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService 
{
    @Autowired
    private ClienteRepository repositorio;

    public Cliente fromDTO(ClienteDTO dto)
    {
        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.getEndereco());

        return cliente;
    }

    public List<Cliente> getAllClientes()
    {
        return repositorio.getAllClientes();
    }

    public Cliente getClienteById(int id)
    {
        Optional<Cliente> op = repositorio.getClienteById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao cadastrado"));
    }

    public Cliente save(Cliente cliente)
    {
        return repositorio.save(cliente);
    }

    public Cliente update(Cliente cliente)
    {
        getClienteById(cliente.getId());

        return repositorio.update(cliente);
    }

    public void delete(int id)
    {
        repositorio.delete(getClienteById(id));
    }
}