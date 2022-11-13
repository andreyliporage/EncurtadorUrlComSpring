package matos.liporage.andrey.encurtador.url.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Random;

@Entity
@Table(name = "shorten_table")
public class UrlModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Random random = new Random();

    @Id
    @Column(name = "token")
    private String token;

    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public UrlModel() {};

    public UrlModel(String urlDesejada) {
        token = setToken(urlDesejada);
        longUrl = urlDesejada;
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getToken() {
        return token;
    }

    private String setToken(String longUrl) {
        String dominio = longUrl.split("\\.")[1];
        char[] dominioChar = dominio.toCharArray();

        StringBuilder token = new StringBuilder();

        int rangeRandom = (dominioChar.length - 1);

        for (int i = 0; i < dominioChar.length; i++) {
            token.append(dominioChar[random.nextInt(rangeRandom)]);
            token.append(i + random.nextInt(10));
        }

        return token.toString();
    }

    public String geraNovaUrl() {
        return new StringBuilder("http://localhost:8080/shortUrl?token=").append(token).toString();
    }

    public String getLongUrl() {
        return longUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlModel urlModel = (UrlModel) o;
        return Objects.equals(token, urlModel.token) && Objects.equals(longUrl, urlModel.longUrl) && Objects.equals(createdAt, urlModel.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, longUrl, createdAt);
    }
}
