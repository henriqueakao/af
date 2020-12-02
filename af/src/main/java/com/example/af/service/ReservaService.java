package com.example.af.service;

import com.example.af.repository.*;
import com.example.af.model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService 
{
    @Autowired
    private ReservaRepository repositorioReserva;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    public Reserva getReservaById(int id)
    {
        Optional<Reserva> op = repositorioReserva.getReservaById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não cadastrada"));
    }

    public Reserva getReservaByCliente(int id)
    {
        Optional<Reserva> op = repositorioReserva.getReservaByCliente(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não cadastrada"));
    }

    public Reserva getReservaByVeiculo(int id)
    {
        Optional<Reserva> op = repositorioReserva.getReservaByVeiculo(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não cadastrada"));
    }

    public Reserva save(Reserva reserva, LocalDate dataFim, int idCliente, int idVeiculo)
    {
        Cliente cliente = clienteService.getClienteById(idCliente);
        Veiculo veiculo = veiculoService.getVeiculoById(idVeiculo);

        if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY))
        {
            System.out.println("Domingo!");
        }
        reserva.setDataInicio(LocalDate.now());
        reserva.setDataFim(dataFim);

        reserva.setCliente(cliente);
        cliente.addReserva(reserva);

        reserva.setVeiculo(veiculo);
        veiculo.addReserva(reserva);

        return repositorioReserva.save(reserva);
    }
}
