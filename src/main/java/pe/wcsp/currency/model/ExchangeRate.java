package pe.wcsp.currency.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {
    private String currencyOrigin;
    private String currencyTarget;
    private BigDecimal exchangeValue;
}
