package pe.wcsp.currency.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.wcsp.currency.core.constant.ErrorConstant;
import pe.wcsp.currency.dao.entity.CurrencyEntity;
import pe.wcsp.currency.core.exception.BusinessException;
import pe.wcsp.currency.dao.repository.CurrencyRepository;
import pe.wcsp.currency.mapper.CurrencyMapper;
import pe.wcsp.currency.model.Currency;
import pe.wcsp.currency.service.CurrencyService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public List<Currency> findCurrencies() {
        return currencyRepository.findAll()
                .stream()
                .map(CurrencyMapper.INSTANCE::toModel)
                .toList();
    }

    @Override
    public List<String> findAllCurrencyCode() {
        return currencyRepository.findAllCurrencyCode().stream().sorted().toList();
    }

    @Override
    public Currency findFirstCurrencyWithSalePriceGreaterThanUSD() {
        Currency currencyUSD = findCurrency("USD");
        List<Currency> currencies = findCurrencies()
                .stream()
                .filter(c -> c.getSalePrice().compareTo(currencyUSD.getSalePrice()) < 0)
                .toList();
        return currencies.isEmpty() ? null : currencies.get(0);
    }

    @Override
    public Currency findCurrency(String currencyCode) {
        Optional<CurrencyEntity> currencyEntity = currencyRepository.findByCurrencyCode(currencyCode);
        if (currencyEntity.isPresent()) return CurrencyMapper.INSTANCE.toModel(currencyEntity.get());

        throw new BusinessException(ErrorConstant.CURRENCY_CODE_NOT_EXISTS);
    }

    @Override
    @Transactional
    public void deleteByCurrencyCode(String currencyCode) {
        Optional<CurrencyEntity> currencyEntity = currencyRepository.findByCurrencyCode(currencyCode);
        if (currencyEntity.isEmpty()) {
            throw new BusinessException(ErrorConstant.CURRENCY_CODE_NOT_EXISTS_TO_DELETE);
        }

        currencyRepository.deleteByCurrencyCode(currencyCode);
    }
}
