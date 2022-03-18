package br.com.saraiva.marketplacein.model;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data @ToString
public class StockProduct implements Serializable {

    @NotNull(message = "IdLojista cannot be empty.")
    private Long idLojista;

    @NotEmpty(message = "skuLojista cannot be empty.")
    private String skuLojista;

    @NotEmpty(message = "EAN cannot be empty.")
    private String ean;

    @NotEmpty(message = "ISBN cannot be empty.")
    private String isbn;

    @NotNull(message = "Estoque cannot be null.")
    private int estoque;

}
