package com.poc.steps.autor;

import com.poc.dao.AutorDao;
import com.poc.entity.Autor;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;

public class AutorDaoStep {
    private final AutorDao autorDao;

    public AutorDaoStep(AutorDao autorDao) {
        this.autorDao = autorDao;
    }

    /**
     * @param autors la liste des auteurs sous forme d'un tableau avec les données suivantes :<br/>
     *               ID : identifiant de l'auteur (Long)<br/>
     *               NAME : nom de l'auteur (String)
     *               FIRSTNAME : prenom de l'auteur (String)
     */
    @Soit("les auteurs suivants :")
    public void initAutor(List<Map<String, String>> autors) {
        autors.forEach(map -> {
            var autor = new Autor();
            Optional.of("UUID").map(map::get).map(UUID::fromString).ifPresent(autor::setUuid);
            Optional.of("NAME").map(map::get).ifPresent(autor::setName);
            Optional.of("FIRSTNAME").map(map::get).ifPresent(autor::setFirstName);
            autorDao.save(autor);
        });
    }

    @Alors("un auteur existe avec le nom suivant : {string}")
    public void autorWithTitle(String text) {
        assertTrue(StreamSupport.stream(autorDao.findAll()
                .spliterator(), false)
                .anyMatch(autor -> text.equals(autor.getName())));
    }

}
