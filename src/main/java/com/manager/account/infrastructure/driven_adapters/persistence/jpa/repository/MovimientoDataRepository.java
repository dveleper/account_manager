package com.manager.account.infrastructure.driven_adapters.persistence.jpa.repository;

import com.manager.account.infrastructure.driven_adapters.persistence.jpa.MovimientoData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface MovimientoDataRepository extends CrudRepository<MovimientoData, Integer> {
    @Query(value = "from MovimientoData t where fecha BETWEEN :startDate AND :endDate")
    List<MovimientoData> getAllBetweenDates(OffsetDateTime endDate, OffsetDateTime startDate);

    List<MovimientoData> findByCuentaCuentaId(String cuentaId);
}
