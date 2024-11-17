package pe.wcsp.currency.service.utils;

import pe.wcsp.currency.dao.entity.CurrencyEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrencyTestUtil {

    public static List<CurrencyEntity> buildCurrencyList() {
        List<CurrencyEntity> currencies = new ArrayList<>();
        CurrencyEntity currencyEntity1 = new CurrencyEntity();
        currencyEntity1.setCurrencyId(1L);
        currencyEntity1.setCurrencyCode("PEN");
        currencyEntity1.setCurrencySymbol("S/.");
        currencyEntity1.setCurrencyName("Peruvian Sol (PEN)");
        currencyEntity1.setSalePrice(BigDecimal.valueOf(3.802500));
        currencies.add(currencyEntity1);

        CurrencyEntity currencyEntity2 = new CurrencyEntity();
        currencyEntity2.setCurrencyId(2L);
        currencyEntity2.setCurrencyCode("USD");
        currencyEntity2.setCurrencySymbol("$");
        currencyEntity2.setCurrencyName("United States Dollar (USD)");
        currencyEntity2.setSalePrice(BigDecimal.valueOf(1.000000));
        currencies.add(currencyEntity2);

        CurrencyEntity currencyEntity3 = new CurrencyEntity();
        currencyEntity3.setCurrencyId(3L);
        currencyEntity3.setCurrencyCode("EUR");
        currencyEntity3.setCurrencySymbol("€");
        currencyEntity3.setCurrencyName("Euro (EUR)");
        currencyEntity3.setSalePrice(BigDecimal.valueOf(0.948780));
        currencies.add(currencyEntity3);

        return currencies;
    }

    public static List<String> buildAllCurrencyCode() {
        return List.of("PEN","USD","EUR","ARS","PHP");
    }

    public static Optional<CurrencyEntity> buildCurrency() {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrencyId(1L);
        currencyEntity.setCurrencyCode("PEN");
        currencyEntity.setCurrencySymbol("S/.");
        currencyEntity.setCurrencyName("Peruvian Sol (PEN)");
        currencyEntity.setSalePrice(BigDecimal.valueOf(3.802500));

        return Optional.of(currencyEntity);
    }

    public static Optional<CurrencyEntity> buildCurrencyUSD() {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrencyId(2L);
        currencyEntity.setCurrencyCode("USD");
        currencyEntity.setCurrencySymbol("$");
        currencyEntity.setCurrencyName("United States Dollar");
        currencyEntity.setSalePrice(BigDecimal.valueOf(1.000000));

        return Optional.of(currencyEntity);
    }

}
