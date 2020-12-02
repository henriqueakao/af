package com.example.af.model;

import java.util.ArrayList;

public class Veiculo 
{
    private int Id;
    private String Modelo;
    private float ValorDiaria;
    private ArrayList<Reserva> Reservas;

    public int getId() 
    {
        return Id;
    }

    public void setId(int id) 
    {
        Id = id;
    }

    public String getModelo() 
    {
        return Modelo;
    }

    public void setModelo(String modelo) 
    {
        Modelo = modelo;
    }

    public float getValorDiaria() 
    {
        return ValorDiaria;
    }

    public void setValorDiaria(float valorDiaria) 
    {
        ValorDiaria = valorDiaria;
    }

    public ArrayList<Reserva> getReservas() 
    {
        return Reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) 
    {
        Reservas = reservas;
    }

    public boolean addReserva(Reserva reserva) 
    {
        return Reservas.add(reserva);
    }
}
