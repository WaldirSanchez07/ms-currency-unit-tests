package pe.wcsp.currency.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.wcsp.currency.dto.response.ObjectResponse;
import pe.wcsp.currency.service.CurrencyService;

@RestController
@RequestMapping("api/currency")
@RequiredArgsConstructor
public class CurrencyRestService {

    private final CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<ObjectResponse> findCurrencies() {
        return ResponseEntity.ok(ObjectResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(currencyService.findCurrencies())
                .build());
    }

    @GetMapping("/find-all-currency-code")
    public ResponseEntity<ObjectResponse> findAllCurrencyCode() {
        return ResponseEntity.ok(ObjectResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(currencyService.findAllCurrencyCode())
                .build());
    }

    @GetMapping("/find-first-greater-than-usd")
    public ResponseEntity<ObjectResponse> findFirstCurrencyWithSalePriceGreaterThanUSD() {
        return ResponseEntity.ok(ObjectResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(currencyService.findFirstCurrencyWithSalePriceGreaterThanUSD())
                .build());
    }

    @GetMapping("/find")
    public ResponseEntity<ObjectResponse> findCurrency(@RequestParam("code") String currencyCode) {
        return ResponseEntity.ok(ObjectResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(currencyService.findCurrency(currencyCode))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<ObjectResponse> deleteCurrency(@RequestParam("code") String currencyCode) {
        currencyService.deleteByCurrencyCode(currencyCode);
        return ResponseEntity.ok(ObjectResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("La moneda ha sido eliminada.")
                .build());
    }
}
