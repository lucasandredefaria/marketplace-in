package br.com.saraiva.marketplacein.model;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data @ToString
public class SkuInserirRequestMessage implements Serializable {

    @NotEmpty(message = "skuLojista cannot be empty.")
    private String skuLojista;

    private String skuSaraiva;

    @NotEmpty(message = "EAN cannot be empty.")
    private String ean;

    @NotEmpty(message = "ISBN cannot be empty.")
    private String isbn;

    private String releaseDate;

    private String title;

    @NotNull(message = "PrecoDe cannot be empty.")
    @DecimalMin(value = "0.0", inclusive = false, message = "PrecoDe must be greater than ZERO")
    private BigDecimal precoDe;

    @NotNull(message = "PrecoPor cannot be empty.")
    @DecimalMin(value = "0.0", inclusive = false, message = "PrecoPor must be greater than ZERO")
    private BigDecimal precoPor;

    @NotNull(message = "Estoque cannot be empty.")
    private int estoque;

    @NotEmpty(message = "Tipo cannot be empty. Values accepted: New, Used or Refurbished.")
    private String tipo;

    @DecimalMin(value = "0.0",inclusive = false, message = "Peso must be greater than ZERO")
    @NotNull(message = "Peso cannot be empty.")
    private Double peso;

    @NotEmpty(message = "Status cannot be empty. Values accepted: Active, Inactive or Blocked.")
    private String status;

    private List<CaracteristicaSku> caracteristicas;

    @NotEmpty(message = "Imagens cannot be empty.")
    private List<Image> imagens;

}
