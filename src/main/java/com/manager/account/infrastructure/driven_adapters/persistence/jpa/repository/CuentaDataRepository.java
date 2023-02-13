package com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository;

import com.manager.account.infrastructure.driven_adapters.persistence.jpa.CuentaData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CuentaDataRepository extends CrudRepository<CuentaData, String> {
    List<CuentaData> findByCliente(String identificacion);
}
