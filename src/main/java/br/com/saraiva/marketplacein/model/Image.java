package br.com.saraiva.marketplacein.model;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data @ToString
public class Image implements Serializable {

    @NotEmpty(message = "UrlInterna cannot be empty.")
    private String urlInterna;

    private String name;

    private boolean capa;

}
