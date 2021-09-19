package org.ilona.cafeteria.adapter.out;

import lombok.RequiredArgsConstructor;
import org.ilona.cafeteria.application.port.in.entities.PersonneDto;
import org.ilona.cafeteria.application.port.out.PersonnePortOut;
import org.ilona.cafeteria.application.port.out.jpa.entities.PersonneJpaEntity;
import org.ilona.cafeteria.application.port.out.jpa.mapper.PersonneJpaEntityMapper;
import org.ilona.cafeteria.application.port.out.jpa.repository.PersonneRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PersonneAdapterOut implements PersonnePortOut {
    private final PersonneRepository personneRepository;
    private final PersonneJpaEntityMapper personneMapper;

    @Override
    public PersonneDto ajouterUnePersonne(PersonneDto personneDto){
        PersonneJpaEntity personneJpaEntity = personneMapper.toPersonneJpaEntity(personneDto);
        personneJpaEntity = personneRepository.save(personneJpaEntity);
        return personneMapper.toPersonneDto(personneJpaEntity);
    }

    @Override
    public List<PersonneDto> toutesLesPersonnes() {
        List<PersonneJpaEntity> all = personneRepository.findAll();
        return personneMapper.toCollectionDePersonneDto(all);
    }

}
