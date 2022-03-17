package br.com.saraiva.marketplacein.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Image {

    @NotEmpty(message = "UrlInterna cannot be empty.")
    private String urlInterna;

    private boolean capa;

}
