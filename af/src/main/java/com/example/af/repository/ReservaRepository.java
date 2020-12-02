package com.example.af.repository;

import com.example.af.model.*;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ReservaRepository 
{
    private ArrayList<Reserva> Reservas = new ArrayList<Reserva>();
    private static int nextId = 1;
    
    public Optional<Reserva> getReservaById(int id)
    {
        for (Reserva aux : Reservas)
        {
            if(aux.getId() == id)
            {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Optional<Reserva> getReservaByCliente(int id)
    {
        for (Reserva aux : Reservas)
        {
            if(aux.getClienteId() == id)
            {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Optional<Reserva> getReservaByVeiculo(int id)
    {
        for (Reserva aux : Reservas)
        {
            if(aux.getVeiculoId() == id)
            {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Reserva save(Reserva reserva)
    {
        reserva.setId(nextId++);
        Reservas.add(reserva);

        return reserva;
    }
}
