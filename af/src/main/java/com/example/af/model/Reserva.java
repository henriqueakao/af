package com.example.af.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva
{
    private int Id;
    private LocalDate DataInicio;
    private LocalDate DataFim;
    private Cliente Cliente;
    private Veiculo Veiculo;

    public int getId() 
    {
        return Id;
    }

    public void setId(int id) 
    {
        Id = id;
    }

    public LocalDate getDataInicio() 
    {
        return DataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) 
    {
        DataInicio = dataInicio;
    }

    public LocalDate getDataFim() 
    {
        return DataFim;
    }

    public void setDataFim(LocalDate dataFim) 
    {
        DataFim = dataFim;
    }

    public Cliente getCliente()
    {
        return Cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        Cliente = cliente;
    }

    public Veiculo getVeiculo()
    {
        return Veiculo;
    }

    public void setVeiculo(Veiculo veiculo) 
    {
        Veiculo = veiculo;
    }
    
    public int getVeiculoId() 
    {
        return Veiculo.getId();
    }
    
    public int getClienteId() 
    {
        return Cliente.getId();
    }

    public float totalReserva(){
        long days = ChronoUnit.DAYS.between(DataInicio, DataFim);

        return Veiculo.getValorDiaria() * days;
    }
}
