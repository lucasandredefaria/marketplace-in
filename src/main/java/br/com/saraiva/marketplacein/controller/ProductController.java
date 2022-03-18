package br.com.saraiva.marketplacein.controller;

import br.com.saraiva.marketplacein.exception.ProductException;
import br.com.saraiva.marketplacein.model.PriceProduct;
import br.com.saraiva.marketplacein.model.Product;
import br.com.saraiva.marketplacein.model.StockProduct;
import br.com.saraiva.marketplacein.queue.RabbitMQSender;
import br.com.saraiva.marketplacein.queue.RabbitMqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/marketplace/v1/products")
public class ProductController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
    private RabbitMqConfig config;

    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<String> product(@Valid @RequestBody Product product, Errors errors) throws ProductException {

        if (errors.hasErrors())
            throw new ProductException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);

		try {
            rabbitMQSender.send(config.ProductQueue().getName(), product);
			return ResponseEntity.status(HttpStatus.OK).body("Product sent successfully" + "\n" + product +"\n");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to send product, please try again!\n");
		}
    }

    @PutMapping("/stock")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> updateStock(@Valid @RequestBody StockProduct stockProduct, Errors errors) throws ProductException {

        if (errors.hasErrors())
            throw new ProductException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);

        try {
            rabbitMQSender.send(config.StockQueue().getName(), stockProduct);
            return ResponseEntity.status(HttpStatus.OK).body("Stock update sent successfully! " + "\n" + stockProduct +"\n");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to send stock update, please try again!\n");
        }
    }

    @PutMapping("/price")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<String> updatePrice(@Valid @RequestBody PriceProduct priceProduct, Errors errors) throws ProductException {

        if (errors.hasErrors())
            throw new ProductException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);

        try {
            rabbitMQSender.send(config.PriceQueue().getName(), priceProduct);
            return ResponseEntity.status(HttpStatus.OK).body("Price update sent successfully! " + "\n" + priceProduct +"\n");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to send price update, please try again!\n");
        }
    }

}
