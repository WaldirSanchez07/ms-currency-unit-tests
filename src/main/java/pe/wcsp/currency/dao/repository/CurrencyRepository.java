package pe.wcsp.currency.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.wcsp.currency.dao.entity.CurrencyEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
    Optional<CurrencyEntity> findByCurrencyCode(String currencyCode);
//    @Query(value = "select currencyCode from CurrencyEntity order by currencyCode asc")
    @Query(value = "select currencyCode from CurrencyEntity")
    List<String> findAllCurrencyCode();
    @Modifying
    @Query(value = "delete from CurrencyEntity where currencyCode = ?1")
    void deleteByCurrencyCode(String currencyCode);
}