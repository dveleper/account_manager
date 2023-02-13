package com.manager.account.infrastructure.driven_adapters.persistence.jpa.mapper;

import com.manager.account.domain.model.Cuenta;
import com.manager.account.infrastructure.driven_adapters.persistence.jpa.CuentaData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    @Mappings({
            @Mapping(source = "cuentaId", target = "numeroCuenta"),
            @Mapping(source = "tipoCuenta", target = "tipoCuenta"),
            @Mapping(source = "saldoInicial", target = "saldoInicial"),
            @Mapping(source = "cliente", target = "cliente")
    })
    Cuenta toCuenta(CuentaData cuenta);

    List<Cuenta> toCuentas(List<CuentaData> cuentaDataList);

    @InheritInverseConfiguration
    CuentaData toCuentaData(Cuenta cuenta);


}