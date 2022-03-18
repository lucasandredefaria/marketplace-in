package br.com.saraiva.marketplacein.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class CaracteristicaSku implements Serializable {

    private String id;
    private String valor;

}
