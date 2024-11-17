package pe.wcsp.currency.service;

import pe.wcsp.currency.model.ExchangeRate;

public interface CurrencyParser {
    ExchangeRate readCurrencyResponse(String json);
}
