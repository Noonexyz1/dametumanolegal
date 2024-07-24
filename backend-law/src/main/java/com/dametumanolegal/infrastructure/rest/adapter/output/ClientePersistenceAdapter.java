package com.dametumanolegal.infrastructure.rest.adapter.output;

import com.dametumanolegal.domain.model.DocumentacionDomain;
import com.dametumanolegal.domain.model.HonorarioDomain;
import com.dametumanolegal.domain.model.NotificacionDomain;
import com.dametumanolegal.domain.model.TramiteDomain;
import com.dametumanolegal.domain.port.output.ClientePersitence;
import com.dametumanolegal.infrastructure.persistence.entities.Documentacion;
import com.dametumanolegal.infrastructure.persistence.entities.Honorario;
import com.dametumanolegal.infrastructure.persistence.entities.Notificacion;
import com.dametumanolegal.infrastructure.persistence.entities.Tramite;
import com.dametumanolegal.infrastructure.persistence.repository.DocumentancionRepository;
import com.dametumanolegal.infrastructure.persistence.repository.HonorarioRepository;
import com.dametumanolegal.infrastructure.persistence.repository.NotificacionRepository;
import com.dametumanolegal.infrastructure.persistence.repository.TramiteRepository;
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
        Optional<Documentacion> doc = documentancionRepository.findById(idTramite);
        return doc.map(y -> modelMapper.map(y, DocumentacionDomain.class)).orElse(null);
    }

    @Override
    public HonorarioDomain getHonorario(Long idTramite) {
        Optional<Honorario> honor = honorarioRepository.findById(idTramite);
        return honor.map(z -> modelMapper.map(z, HonorarioDomain.class)).orElse(null);
    }

    @Override
    public NotificacionDomain getNotificacion(Long idCaso) {
        Optional<Notificacion> notifi = notificacionRepository.findById(idCaso);
        return notifi.map(u -> modelMapper.map(u, NotificacionDomain.class)).orElse(null);
    }
}
