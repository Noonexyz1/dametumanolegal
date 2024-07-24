package com.dametumanolegal.infrastructure.rest.adapter.input;

import com.dametumanolegal.domain.model.ActuadoDomain;
import com.dametumanolegal.domain.model.CasoFiscaliaDomain;
import com.dametumanolegal.domain.model.FiscalDomain;
import com.dametumanolegal.domain.model.NotificacionDomain;
import com.dametumanolegal.domain.port.input.Procurable;
import com.dametumanolegal.infrastructure.rest.dtos.request.ActuadoRequest;
import com.dametumanolegal.infrastructure.rest.dtos.request.NotificacionRequest;
import com.dametumanolegal.infrastructure.rest.dtos.request.ReguistrarActuadoRequest;
import com.dametumanolegal.infrastructure.rest.dtos.response.CasoFiscaliaResponse;
import com.dametumanolegal.infrastructure.rest.dtos.response.CasoResponse;
import com.dametumanolegal.infrastructure.rest.dtos.response.CuadernoResponse;
import com.dametumanolegal.infrastructure.rest.dtos.response.FiscalResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/modProcurador")
public class ProcuradorController {

    @Autowired
    private Procurable procurable;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/setNotificacion")
    public void registrarNotificacion(@RequestBody NotificacionRequest nuevaNotificacion) {
        NotificacionDomain notiDomain = modelMapper.map(nuevaNotificacion, NotificacionDomain.class);
        procurable.registrarNotificacion(notiDomain);
    }

    @PostMapping("/setActuado")
    public void registrarActuado(@RequestBody ReguistrarActuadoRequest nuevoActuado) {
        ActuadoRequest actRequest = nuevoActuado.getActRequest();
        Long idCaso = nuevoActuado.getIdCaso();
        ActuadoDomain actDomain = modelMapper.map(actRequest, ActuadoDomain.class);
        procurable.registrarActuado(actDomain, idCaso);
    }

    @GetMapping("/listaCaso")
    public List<CasoResponse> verCasos() {
        return procurable.verCasos().stream().map(x -> modelMapper.map(x, CasoResponse.class)).toList();
    }

    @GetMapping("/listaCuaderno")
    public List<CuadernoResponse> verCuadernos() {
        return procurable.verCuadernos().stream().map(x -> modelMapper.map(x, CuadernoResponse.class)).toList();
    }

    @GetMapping("/listaFiscal")
    public List<FiscalResponse> verFiscales() {
        List<FiscalDomain> fiscalDomains = procurable.verFiscales();
        return fiscalDomains.stream().map(x -> modelMapper.map(x, FiscalResponse.class)).toList();
    }

    @GetMapping("/listaCasosFiscalia")
    public List<CasoFiscaliaResponse> verCasosFiscalia() {
        List<CasoFiscaliaDomain> casoFisc = procurable.verCasosFiscalia();
        return casoFisc.stream().map(y -> modelMapper.map(y, CasoFiscaliaResponse.class)).toList();
    }
}
