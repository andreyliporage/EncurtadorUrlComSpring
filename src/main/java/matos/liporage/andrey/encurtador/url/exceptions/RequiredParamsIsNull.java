package matos.liporage.andrey.encurtador.url.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredParamsIsNull extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RequiredParamsIsNull(String ex) {
        super(ex);
    }

    public RequiredParamsIsNull() {
        super("Não é permitido encurtar uma URL inexistente");
    }
}
