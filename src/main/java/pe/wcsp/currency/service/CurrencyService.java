package pe.wcsp.currency.service;

import java.util.List;
import pe.wcsp.currency.model.Currency;

public interface CurrencyService {
    List<Currency> findCurrencies();
    List<String> findAllCurrencyCode();
    Currency findFirstCurrencyWithSalePriceGreaterThanUSD();
    Currency findCurrency(String currencyCode);
    void deleteByCurrencyCode(String currencyCode);
}
