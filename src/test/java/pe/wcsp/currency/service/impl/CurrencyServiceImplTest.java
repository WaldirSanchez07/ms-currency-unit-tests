package pe.wcsp.currency.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.wcsp.currency.core.constant.ErrorConstant;
import pe.wcsp.currency.dao.entity.CurrencyEntity;
import pe.wcsp.currency.model.Currency;
import pe.wcsp.currency.core.exception.BusinessException;
import pe.wcsp.currency.dao.repository.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pe.wcsp.currency.service.utils.CurrencyTestUtil.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CurrencyServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

//    @AfterEach
//    void onAfterEach() {
//        Mockito.reset(currencyRepository);
//    }

    @Test
    void findCurrencies_EmptyList() {
        Mockito.when(currencyRepository.findAll()).thenReturn(new ArrayList<>());
        List<Currency> currencies = currencyService.findCurrencies();

        Assertions.assertTrue(currencies.isEmpty());
    }

    @Test
    void findCurrencies_NotEmptyList() {
        Mockito.when(currencyRepository.findAll()).thenReturn(buildCurrencyList());
        List<Currency> currencies = currencyService.findCurrencies();

        Assertions.assertFalse(currencies.isEmpty());
        Assertions.assertEquals(3, currencies.size());
    }

    @Test
    void findAllCurrencyCode() {
        List<String> expected = List.of("ARS","EUR","PEN","PHP","USD");
        Mockito.when(currencyRepository.findAllCurrencyCode()).thenReturn(buildAllCurrencyCode());
        List<String> currencyCodeList = currencyService.findAllCurrencyCode();

        Assertions.assertNotEquals(0, currencyCodeList.size());
        Assertions.assertIterableEquals(expected, currencyCodeList);
    }

    @Test
    void findFirstCurrencyWithSalePriceGreaterThanUSD_IsNull() {
        List<CurrencyEntity> currencyEntityList = buildCurrencyList();
        currencyEntityList.remove(2);
        Mockito.when(currencyRepository.findByCurrencyCode(anyString())).thenReturn(buildCurrencyUSD());
        Mockito.when(currencyRepository.findAll()).thenReturn(currencyEntityList);

        Currency currency = currencyService.findFirstCurrencyWithSalePriceGreaterThanUSD();

        Assertions.assertNull(currency);
    }

    @Test
    void findFirstCurrencyWithSalePriceGreaterThanUSD_NotNull() {
        Mockito.when(currencyRepository.findByCurrencyCode(anyString())).thenReturn(buildCurrencyUSD());
        Mockito.when(currencyRepository.findAll()).thenReturn(buildCurrencyList());

        Currency currency = currencyService.findFirstCurrencyWithSalePriceGreaterThanUSD();

        Assertions.assertNotNull(currency);
    }

    @Test
    void findCurrency_NotNull() {
        Mockito.when(currencyRepository.findByCurrencyCode(anyString())).thenReturn(buildCurrency());
        Currency currency = currencyService.findCurrency("PEN");

        Assertions.assertNotNull(currency);
        Assertions.assertEquals("PEN", currency.getCurrencyCode());
    }

    @Test
    void findCurrency_ThrowExceptionCurrencyCodeNotExists() {
        Mockito.when(currencyRepository.findByCurrencyCode(anyString())).thenReturn(Optional.empty());

        BusinessException exception = Assertions.assertThrows(BusinessException.class,
                () -> currencyService.findCurrency("CNY"));
        Assertions.assertEquals(ErrorConstant.CURRENCY_CODE_NOT_EXISTS, exception.getErrorMessage());
    }

    @Test
    void deleteByCurrencyCode_Success() {
        Mockito.when(currencyRepository.findByCurrencyCode(anyString())).thenReturn(buildCurrency());

        Assertions.assertDoesNotThrow(() -> currencyService.deleteByCurrencyCode("PEN"));
    }

    @Test
    void deleteByCurrencyCode_ThrowExceptionCurrencyCodeNotExists() {
        Mockito.when(currencyRepository.findByCurrencyCode(anyString())).thenReturn(Optional.empty());

        BusinessException exception = Assertions.assertThrows(BusinessException.class,
                () -> currencyService.deleteByCurrencyCode("CNY"));
        Assertions.assertEquals(ErrorConstant.CURRENCY_CODE_NOT_EXISTS_TO_DELETE, exception.getErrorMessage());
    }

//    @Test
//    void deleteByCurrencyCode_ThrowExceptionFindAllFailed() {
//        Mockito.doThrow(BusinessException.class).when(currencyRepository).findAll();
//
//        Assertions.assertThrows(BusinessException.class,
//                () -> currencyService.deleteByCurrencyCode("CNY"));
//    }
}
