package br.com.targetsolutions.challenge.service;

import br.com.targetsolutions.challenge.model.awesome.DollarPrice;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class DollarPriceService {

    public double convertCurrency(double salary) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate template = restTemplateBuilder.build();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("economia.awesomeapi.com.br")
                .path("last/USD-BRL")
                .build();

        DollarPrice dollarPrice = template.getForObject(uri.toString(), DollarPrice.class);

        double convertedSalary = Double.parseDouble(dollarPrice.uSDBRL.getHigh()) * salary;

        return convertedSalary;
    }
}
