package pe.wcsp.currency.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.wcsp.currency.dao.entity.CurrencyEntity;
import pe.wcsp.currency.model.Currency;

@Mapper
public interface CurrencyMapper {

    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    Currency toModel(CurrencyEntity entity);

}
