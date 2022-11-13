package matos.liporage.andrey.encurtador.url.controllers;

import matos.liporage.andrey.encurtador.url.data.VO.UrlVO;
import matos.liporage.andrey.encurtador.url.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/shortUrl")
public class UrlController {

    @Autowired
    private UrlService service;

    @GetMapping()
    public ResponseEntity<Void> get(@RequestParam String token) {
        var longUrl = service.get(token).getUrl();

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UrlVO> create(@RequestParam String url) {
        var result = service.create(url);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("{token}").buildAndExpand(result.getUrl()).toUri();
        return ResponseEntity.created(uri).body(result);
    }
}
