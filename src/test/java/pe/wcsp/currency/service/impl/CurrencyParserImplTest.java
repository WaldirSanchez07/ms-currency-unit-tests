package pe.wcsp.currency.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.wcsp.currency.core.exception.BusinessException;
import pe.wcsp.currency.model.ExchangeRate;

@ExtendWith(SpringExtension.class)
class CurrencyParserImplTest {

    private CurrencyParserImpl currencyParser;

    @BeforeEach
    void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        currencyParser = new CurrencyParserImpl(objectMapper);
    }

    @Test
    void readCurrencyResponse_Success() {
        String json = """
                {"currencyOrigin": "PEN", "currencyTarget": "USD", "exchangeValue": 3.812340}
                """;
        ExchangeRate exchangeRate = currencyParser.readCurrencyResponse(json);

        Assertions.assertNotNull(exchangeRate);
        Assertions.assertEquals("PEN", exchangeRate.getCurrencyOrigin());
    }

    @Test
    void readCurrencyResponse_ThrowException() {
        String json = "";
        Assertions.assertThrows(BusinessException.class,
                () -> currencyParser.readCurrencyResponse(json));
    }

}
