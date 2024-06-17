package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.DocumentacionDomain;
import com.dametumanolegal.domain.HonorarioDomain;
import com.dametumanolegal.domain.NotificacionDomain;
import com.dametumanolegal.domain.TramiteDomain;
import com.dametumanolegal.domain.port.output.ClientePersitence;
import com.dametumanolegal.entities.Tramite;
import com.dametumanolegal.repository.DocumentancionRepository;
import com.dametumanolegal.repository.HonorarioRepository;
import com.dametumanolegal.repository.NotificacionRepository;
import com.dametumanolegal.repository.TramiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientePersistenceAdapter implements ClientePersitence {

    @Autowired
    private TramiteRepository tramiteRepository;
    @Autowired
    private DocumentancionRepository documentancionRepository;
    @Autowired
    private HonorarioRepository honorarioRepository;
    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private ModelMapper modelMapper;


    //El problema de SQL al traer tram y que no podia traer esas listas en rojo se soluciona con
    //eliminar la BD, crear otra base de datos
    //y poner el properties en modo "create" luego podemos ver que el problema se soluciona
    //solo faltaria insertar los datos de las tablas a partir del nuestro .txt
    @Override
    public TramiteDomain verProcTram(Long idTramite) {
        Optional<Tramite> tram = tramiteRepository.findById(idTramite);
        return tram.map(x -> modelMapper.map(x, TramiteDomain.class)).orElse(null);
    }

    @Override
    public DocumentacionDomain verDocumentacionTram(Long idTramite) {
        return modelMapper.map(documentancionRepository.findById(idTramite), DocumentacionDomain.class);
    }

    @Override
    public HonorarioDomain getHonorario(Long idTramite) {
        return modelMapper.map(honorarioRepository.findById(idTramite), HonorarioDomain.class);
    }

    @Override
    public NotificacionDomain getNotificacion(Long idCaso) {
        return modelMapper.map(notificacionRepository.findById(idCaso), NotificacionDomain.class);
    }
}
