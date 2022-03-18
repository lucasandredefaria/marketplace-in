package br.com.saraiva.marketplacein.model;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data @ToString
public class PriceProduct implements Serializable {

    @NotNull(message = "IdLojista cannot be empty.")
    private Long idLojista;

    @NotEmpty(message = "skuLojista cannot be empty.")
    private String skuLojista;

    private String skuSaraiva;

    @NotEmpty(message = "EAN cannot be empty.")
    private String ean;

    @NotEmpty(message = "ISBN cannot be empty.")
    private String isbn;

    @NotNull(message = "PrecoDe cannot be null.")
    @DecimalMin(value = "0.0", inclusive = false, message = "PrecoDe must be greater than ZERO")
    private BigDecimal precoDe;

    @NotNull(message = "PrecoPor cannot be null.")
    @DecimalMin(value = "0.0", inclusive = false, message = "PrecoPor must be greater than ZERO")
    private BigDecimal precoPor;

}
