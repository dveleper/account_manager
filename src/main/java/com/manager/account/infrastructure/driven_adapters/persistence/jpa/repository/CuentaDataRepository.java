package com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository;

import com.manager.account.infrastructure.driven_adapters.persistence.jpa.CuentaData;
import org.springframework.data.repository.CrudRepository;

public interface CuentaDataRepository extends CrudRepository<CuentaData, String> {

}
