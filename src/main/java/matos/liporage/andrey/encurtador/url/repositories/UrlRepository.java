package matos.liporage.andrey.encurtador.url.repositories;

import matos.liporage.andrey.encurtador.url.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, String> {
}
