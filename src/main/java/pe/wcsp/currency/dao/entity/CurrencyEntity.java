package pe.wcsp.currency.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "tbl_currency")
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Long currencyId;
    @Column(name = "code", columnDefinition = "VARCHAR(3)")
    private String currencyCode;
    @Column(name = "symbol", columnDefinition = "VARCHAR(5)")
    private String currencySymbol;
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String currencyName;
    @Column(name = "sale_price", columnDefinition = "NUMERIC(12, 6)")
    private BigDecimal salePrice;

}
