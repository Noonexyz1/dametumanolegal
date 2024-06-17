package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.CasoDomain;
import com.dametumanolegal.domain.CitaDomain;
import com.dametumanolegal.domain.CuadernoDomain;
import com.dametumanolegal.domain.MemorialDomain;
import com.dametumanolegal.domain.port.input.Gestionable;
import com.dametumanolegal.dtos.request.*;
import com.dametumanolegal.dtos.response.CasoResponse;
import com.dametumanolegal.dtos.response.CuadernoResponse;
import com.dametumanolegal.dtos.response.MemorialResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/modSecretaria")
public class SecretariaController {

    @Autowired
    private Gestionable gestionable;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/setCuaderno")
    public void registrarCuaderno(@RequestBody CuadernoRequest cuadernoNuevo) {
        CuadernoDomain cuadernoDomain = modelMapper.map(cuadernoNuevo, CuadernoDomain.class);
        gestionable.registrarCuaderno(cuadernoDomain);
    }
    @PostMapping("/setMemorial")
    public void registrarMemorial(@RequestBody RegistrarMemorialRequest nuevoMemorial) {
        MemorialRequest memorialRequest = nuevoMemorial.getMemorial();
        Long idCaso = nuevoMemorial.getIdCaso();
        MemorialDomain memorialDomain = modelMapper.map(memorialRequest, MemorialDomain.class);
        gestionable.registrarMemorial(memorialDomain, idCaso);
    }
    @PostMapping("/setCita")
    public void registrarCita(@RequestBody RegistrarCitaRequest nuevaCita) {
        CitaRequest citaRequest = nuevaCita.getCitaRequest();
        Long idCliente = nuevaCita.getIdCliente();
        Long idSecre = nuevaCita.getIdSecretaria();
        CitaDomain citaDomain = modelMapper.map(citaRequest, CitaDomain.class);
        gestionable.registrarCita(citaDomain, idCliente, idSecre);
    }


    @GetMapping("/listaCuaderno")
    public List<CuadernoResponse> verCuadernos() {
        List<CuadernoDomain> listCuaderno = gestionable.verCuadernos();
        return listCuaderno.stream().map(x -> modelMapper.map(x, CuadernoResponse.class)).toList();
    }
    @GetMapping("/listaMemorial")
    public List<MemorialResponse> verMemoriales() {
        List<MemorialDomain> listMemorial = gestionable.verMemoriales();
        return listMemorial.stream().map(x -> modelMapper.map(x, MemorialResponse.class)).toList();
    }
    @GetMapping("/listaCaso")
    public List<CasoResponse> verCasos() {
        List<CasoDomain> listCaso = gestionable.verCasos();
        return listCaso.stream().map(x -> modelMapper.map(x, CasoResponse.class)).toList();
    }
}
