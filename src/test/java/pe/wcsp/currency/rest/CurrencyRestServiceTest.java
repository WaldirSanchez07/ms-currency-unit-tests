package pe.wcsp.currency.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.wcsp.currency.dto.response.ObjectResponse;
import pe.wcsp.currency.service.CurrencyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static pe.wcsp.currency.service.utils.CurrencyTestUtil.*;

@ExtendWith(SpringExtension.class)
class CurrencyRestServiceTest {

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private CurrencyRestService currencyRestService;

    @Test
    void findCurrencies_ListEmpty() {
        Mockito.when(currencyService.findCurrencies()).thenReturn(new ArrayList<>());

        ResponseEntity<ObjectResponse> response = currencyRestService.findCurrencies();
        ObjectResponse body = response.getBody();
        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertNotNull(body);
        Assertions.assertTrue(((List<?>) Objects.requireNonNull(body).getData()).isEmpty());
    }

    @Test
    void findCurrencies_ListNotEmpty() {
        Mockito.when(currencyService.findCurrencies()).thenReturn(buildCurrencyModelList());

        ResponseEntity<ObjectResponse> response = currencyRestService.findCurrencies();
        ObjectResponse body = response.getBody();
        Assertions.assertEquals(200, response.getStatusCode().value());
        Assertions.assertNotNull(body);
        Assertions.assertEquals(3, ((List<?>) Objects.requireNonNull(body).getData()).size());
    }

}
