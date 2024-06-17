package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.*;
import com.dametumanolegal.domain.port.output.SecretariaPersistence;
import com.dametumanolegal.entities.*;
import com.dametumanolegal.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SecretariaPersistenceAdapter implements SecretariaPersistence{

    @Autowired
    private CuadernoRepository cuadernoRepository;
    @Autowired
    private MemorialRepository memorialRepository;
    @Autowired
    private CasoRepository casoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private SecretariaRepository secretariaRepository;
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void registrarCuaderno(CuadernoDomain cuadernoNuevo) {
        Cuaderno cuaderno = modelMapper.map(cuadernoNuevo, Cuaderno.class);
        cuadernoRepository.save(cuaderno);
    }

    @Override
    public void registrarMemorial(MemorialDomain nuevoMemorial) {
        Memorial memorial = modelMapper.map(nuevoMemorial, Memorial.class);
        memorialRepository.save(memorial);
    }

    @Override
    public CasoDomain findCasoPorId(Long idCaso) {
        Optional<Caso> caso = casoRepository.findById(idCaso);
        return caso.map(x -> modelMapper.map(x, CasoDomain.class)).orElse(null);
    }

    @Override
    public ClienteDomain findClientePorId(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente.map(y -> modelMapper.map(y, ClienteDomain.class)).orElse(null);
    }

    @Override
    public SecretariaDomain findSecrePorId(Long idSecre) {
        Optional<Secretaria> secre = secretariaRepository.findById(idSecre);
        return secre.map(z -> modelMapper.map(z, SecretariaDomain.class)).orElse(null);
    }

    @Override
    public void registrarCita(CitaDomain nuevaCita) {
        Cita cita = modelMapper.map(nuevaCita, Cita.class);
        citaRepository.save(cita);
    }


    @Override
    public List<CuadernoDomain> getListCuaderno() {
        List<Cuaderno> cuadernos = cuadernoRepository.findAll();
        return cuadernos.stream().map(x -> modelMapper.map(x, CuadernoDomain.class)).toList();
    }

    @Override
    public List<MemorialDomain> getListMemorial() {
        List<Memorial> memorials = memorialRepository.findAll();
        return memorials.stream().map(x -> modelMapper.map(x, MemorialDomain.class)).toList();
    }

    @Override
    public List<CasoDomain> getListCaso() {
        List<Caso> casos = casoRepository.findAll();
        return casos.stream().map(x -> modelMapper.map(x, CasoDomain.class)).toList();
    }
}
