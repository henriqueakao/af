package com.example.af.model;

import java.util.ArrayList;

public class Cliente {
    private int Id;
    private String Nome;
    private String Endereco;
    private String CPF;
    private ArrayList<Reserva> Reservas;

    public int getId() 
    {
        return Id;
    }

    public void setId(int id) 
    {
        Id = id;
    }

    public String getNome() 
    {
        return Nome;
    }

    public void setNome(String nome) 
    {
        Nome = nome;
    }

    public String getEndereco() 
    {
        return Endereco;
    }

    public void setEndereco(String endereco) 
    {
        Endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) 
    {
        CPF = cpf;
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
