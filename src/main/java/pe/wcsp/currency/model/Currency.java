package pe.wcsp.currency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private String currencyCode;
    private String currencySymbol;
    private String currencyName;
    private BigDecimal salePrice;
}
