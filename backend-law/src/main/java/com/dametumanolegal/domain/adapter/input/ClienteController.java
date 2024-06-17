package com.dametumanolegal.domain.adapter.input;

import com.dametumanolegal.domain.DocumentacionDomain;
import com.dametumanolegal.domain.HonorarioDomain;
import com.dametumanolegal.domain.NotificacionDomain;
import com.dametumanolegal.domain.TramiteDomain;
import com.dametumanolegal.domain.port.input.Seguible;
import com.dametumanolegal.dtos.response.DocumentacionResponse;
import com.dametumanolegal.dtos.response.HonorarioResponse;
import com.dametumanolegal.dtos.response.NotificacionResponse;
import com.dametumanolegal.dtos.response.TramiteResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/modCliente")
public class ClienteController {

    @Autowired
    private Seguible seguible;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/verTram/{idTramite}")
    public TramiteResponse verTramite(@PathVariable Long idTramite) {
        TramiteDomain tram = seguible.verTramite(idTramite);
        return modelMapper.map(tram, TramiteResponse.class);
    }

    @GetMapping("/verDocuTram/{idTramite}")
    public DocumentacionResponse verDocumentacionTram(@PathVariable Long idTramite) {
        DocumentacionDomain doc = seguible.verDocumentacionTram(idTramite);
        return modelMapper.map(doc, DocumentacionResponse.class);
    }

    @GetMapping("/verHonorario/{idTramite}")
    public HonorarioResponse verHonorario(@PathVariable Long idTramite) {
        HonorarioDomain honor = seguible.verHonorario(idTramite);
        return modelMapper.map(honor, HonorarioResponse.class);
    }

    @GetMapping("/verNotificacion/{idCaso}")
    public NotificacionResponse verNotificacion(@PathVariable Long idCaso) {
        NotificacionDomain noti = seguible.verNotificacion(idCaso);
        return modelMapper.map(noti, NotificacionResponse.class);
    }
}
