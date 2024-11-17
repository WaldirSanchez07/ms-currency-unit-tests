package pe.wcsp.currency.core.constant;

import lombok.Getter;

@Getter
public class ErrorConstant {
    public static final String CURRENCY_CODE_NOT_EXISTS = "El codigo de moneda existe.";
    public static final String CURRENCY_CODE_NOT_EXISTS_TO_DELETE = "No se puede eliminar, el codigo de moneda no existe.";
}
