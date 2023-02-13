package com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper;

import com.manager.account.domain.model.Cliente;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.ClienteData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
            @Mapping(source = "estado", target = "estado")
    })
    Cliente toCliente(ClienteData clienteData);

    List<Cliente> toClientes(List<ClienteData> clienteDataList);

    @InheritInverseConfiguration
    ClienteData toClienteData(Cliente cliente);
}
