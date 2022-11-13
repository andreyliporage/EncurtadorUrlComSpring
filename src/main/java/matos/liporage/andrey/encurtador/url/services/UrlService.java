package matos.liporage.andrey.encurtador.url.services;

import matos.liporage.andrey.encurtador.url.data.VO.UrlVO;
import matos.liporage.andrey.encurtador.url.exceptions.RequiredParamsIsNull;
import matos.liporage.andrey.encurtador.url.exceptions.ResourceNotFoundException;
import matos.liporage.andrey.encurtador.url.model.UrlModel;
import matos.liporage.andrey.encurtador.url.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UrlService {
    private final Logger logger = Logger.getLogger(UrlService.class.getName());

    @Autowired
    private UrlRepository repository;

    public UrlVO get(String token) {
        Optional<UrlModel> urlModelOptional = repository.findById(token);
        UrlModel urlModel = urlModelOptional.orElseThrow(() -> {
            throw new ResourceNotFoundException("URL não encontrada ou expirada");
        });

        return new UrlVO(urlModel.getLongUrl());
    }

    public UrlVO create(String longUrl) {
        if (longUrl == null) throw new RequiredParamsIsNull();
        logger.info("Criando url...");
        UrlVO urlVO = new UrlVO(longUrl);
        UrlModel urlModel = new UrlModel(urlVO.getUrl());
        String shortUrl = repository.save(urlModel).geraNovaUrl();

        return new UrlVO(shortUrl);
    }
}
