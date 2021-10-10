package org.ilona.cafeteria.application.service;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.exceptions.PersoneServiceException;
import org.ilona.cafeteria.application.port.in.PersonnePortIn;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersoneService implements PersonnePortIn {
    private final PersonnePortOut personnePortOut;

    @Override
    public PersonneDto enregistrer(PersonneDto personneDto) {
        try{
        return personnePortOut.enregistrer(personneDto);
        }catch(Exception e){
            throw new PersoneServiceException("Erreur Enregistrement",e);
        }
    }

    @Override
    public List<PersonneDto> toutes() {
        return personnePortOut.toutes();
    }

    @Override
    public void supprimer(PersonneDto personneDto) {
        personnePortOut.supprimer(personneDto);
    }

    @Override
    public void miseAjour(PersonneDto anciennePersonneDto, PersonneDto nouvellePersonneDto) {
        personnePortOut.miseAjour(anciennePersonneDto, nouvellePersonneDto);
    }

    @Override
    public PersonneDto unePersonne(String id) {
        return personnePortOut.unePersonne(id);
    }
}
