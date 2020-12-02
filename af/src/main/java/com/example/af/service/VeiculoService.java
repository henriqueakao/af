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
public class VeiculoService 
{
    @Autowired
    private VeiculoRepository repositorio;

    public Veiculo fromDTO(VeiculoDTO dto)
    {
        Veiculo veiculo = new Veiculo();
        veiculo.setValorDiaria(dto.getValorDiaria());

        return veiculo;
    }

    public List<Veiculo> getAllVeiculos()
    {
        return repositorio.getAllVeiculos();
    }

    public Veiculo getVeiculoById(int id)
    {
        Optional<Veiculo> op = repositorio.getVeiculoById(id);

        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo nao cadastrado"));
    }

    public Veiculo save(Veiculo veiculo)
    {
        return repositorio.save(veiculo);
    }

    public Veiculo update(Veiculo veiculo)
    {
        getVeiculoById(veiculo.getId());

        return repositorio.update(veiculo);
    }

    public void delete(int id)
    {
        repositorio.delete(getVeiculoById(id));
    }
}