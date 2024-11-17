package pe.wcsp.currency.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.stereotype.Service;
import pe.wcsp.currency.core.exception.BusinessException;
import pe.wcsp.currency.model.ExchangeRate;
import pe.wcsp.currency.service.CurrencyParser;

@Service
public class CurrencyParserImpl implements CurrencyParser {

    private final ObjectReader currencyReader;

    public CurrencyParserImpl(ObjectMapper objectMapper) {
        currencyReader = objectMapper.readerFor(ExchangeRate.class);
    }

    @Override
    public ExchangeRate readCurrencyResponse(String json) {
        return readValue(currencyReader, json);
    }

    private <T> T readValue(ObjectReader objectReader, String json) {
        try {
            return objectReader.readValue(json);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
