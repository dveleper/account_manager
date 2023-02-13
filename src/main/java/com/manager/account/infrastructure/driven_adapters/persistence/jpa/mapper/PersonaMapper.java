package com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper;

import com.manager.account.domain.model.Persona;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.PersonaData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    Persona toPersona(PersonaData personaData);

    @InheritInverseConfiguration
    PersonaData toPersonaData(Persona persona);
}
