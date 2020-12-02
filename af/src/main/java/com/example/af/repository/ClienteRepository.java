package com.example.af.repository;

import com.example.af.model.*;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepository 
{
    private ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    private static int nextId = 1;

    public List<Cliente> getAllClientes()
    {
        return Clientes;
    }

    public Optional<Cliente> getClienteById(int id)
    {
        for (Cliente aux : Clientes)
        {
            if(aux.getId() == id)
            {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Cliente save(Cliente cliente)
    {
        cliente.setId(nextId++);
        Clientes.add(cliente);

        return cliente;
    }

    public Cliente update(Cliente cliente)
    {
        Cliente aux = getClienteById(cliente.getId()).get();

        if(aux != null)
        {
            aux.setEndereco(cliente.getEndereco());
        }

        return aux;
    }

    public void delete (Cliente cliente)
    {
        Clientes.remove(cliente);
    }
}
