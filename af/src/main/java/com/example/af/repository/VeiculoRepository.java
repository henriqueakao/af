package com.example.af.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af.model.*;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository 
{
    private ArrayList<Veiculo> Veiculos = new ArrayList<Veiculo>();
    private static int nextId = 1;

    public List<Veiculo> getAllVeiculos()
    {
        return Veiculos;
    }

    public Optional<Veiculo> getVeiculoById(int id)
    {
        for (Veiculo aux : Veiculos)
        {
            if(aux.getId() == id)
            {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Veiculo save(Veiculo veiculo)
    {
        veiculo.setId(nextId++);
        Veiculos.add(veiculo);

        return veiculo;
    }

    public Veiculo update(Veiculo veiculo)
    {
        Veiculo aux = getVeiculoById(veiculo.getId()).get();

        if(aux != null)
        {
            aux.setValorDiaria(veiculo.getValorDiaria());
        }

        return aux;
    }

    public void delete(Veiculo veiculo)
    {
        Veiculos.remove(veiculo);
    }
}
