package pe.wcsp.currency.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ObjectResponse {
    private Integer statusCode;
    private Object data;
    private String message;
}
