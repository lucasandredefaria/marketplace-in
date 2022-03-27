package br.com.saraiva.marketplacein.model;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data @ToString
public class Product implements Serializable {

    @Size(max = 100, message = "Name must be maximum of 100 characters.")
    @NotBlank(message = "Name cannot be blank.")
    private String nome;

    private String descricao;

    @NotNull(message = "IdCategoriaSaraiva cannot be empty.")
    private Long idCategoriaSaraiva;

    @NotNull(message = "IdMarcaSaraiva cannot be empty.")
    private Long idMarcaSaraiva;

    @NotNull(message = "Skus cannot be empty.")
    private SkuInserirRequestMessage Skus;
}
