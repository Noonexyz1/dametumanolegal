package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.*;
import com.dametumanolegal.domain.port.output.ProcuradorPersistence;
import com.dametumanolegal.entities.*;
import com.dametumanolegal.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProcuradorPersistenceAdapter implements ProcuradorPersistence {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private NotificacionRepository notificacionRepository;
    @Autowired
    private ActuadoRepository actuadoRepository;
    @Autowired
    private CasoRepository casoRepository;
    @Autowired
    private CuadernoRepository cuadernoRepository;
    @Autowired
    private FiscalRepository fiscalRepository;
    @Autowired
    private CasoFiscaliaRepository casoFiscaliaRepository;

    @Override
    public void setNotificacion(NotificacionDomain nuevaNotificacion) {
        Notificacion noti = modelMapper.map(nuevaNotificacion, Notificacion.class);
        notificacionRepository.save(noti);
    }

    @Override
    public CasoDomain getCasoPorId(Long idCaso) {
        Optional<Caso> caso = casoRepository.findById(idCaso);
        return caso.map(x -> modelMapper.map(x, CasoDomain.class)).orElse(null);
    }

    @Override
    public void setActuado(ActuadoDomain nuevoActuado) {
        Actuado actuado = modelMapper.map(nuevoActuado, Actuado.class);
        actuadoRepository.save(actuado);
    }


    @Override
    public List<CasoDomain> getCasos() {
        List<Caso> listCaso = casoRepository.findAll();
        return listCaso.stream().map(x -> modelMapper.map(x, CasoDomain.class)).toList();
    }

    @Override
    public List<CuadernoDomain> getCuadernos() {
        List<Cuaderno> listCuader = cuadernoRepository.findAll();
        return listCuader.stream().map(y -> modelMapper.map(y, CuadernoDomain.class)).toList();
    }

    @Override
    public List<FiscalDomain> getFiscales() {
        List<Fiscal> listFiscal = fiscalRepository.findAll();
        return listFiscal.stream().map(z -> modelMapper.map(z, FiscalDomain.class)).toList();
    }

    @Override
    public List<CasoFiscaliaDomain> getCasosFiscalia() {
        List<CasoFiscalia> listCasFis = casoFiscaliaRepository.findAll();
        return listCasFis.stream().map(u -> modelMapper.map(u, CasoFiscaliaDomain.class)).toList();
    }
}
