package matos.liporage.andrey.encurtador.url.data.VO;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UrlVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String url;

    public UrlVO(String endereco) {
        url = endereco;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlVO urlVO = (UrlVO) o;
        return Objects.equals(url, urlVO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
