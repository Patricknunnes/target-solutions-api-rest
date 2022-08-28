package br.com.targetsolutions.challenge.client;

import br.com.targetsolutions.challenge.client.dto.ExchangeQuotationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class DollarQuotationClient {

    private final RestTemplate restTemplate;
    private final String quotationUrl;
    private final String defaultDollarQuotation;

    public DollarQuotationClient(RestTemplate restTemplate, @Value("${exchange.quotation.default}") String defaultDollarQuotation, @Value("${exchange.quotation.url}") String quotationUrl) {
        this.restTemplate = restTemplate;
        this.quotationUrl = quotationUrl;
        this.defaultDollarQuotation = defaultDollarQuotation;
    }

    public BigDecimal getDollarQuotationNow() {
        try {
            ExchangeQuotationResponse dollarQuotation = restTemplate.getForObject(quotationUrl, ExchangeQuotationResponse.class);

            if (dollarQuotation == null) {
                return new BigDecimal(defaultDollarQuotation);
            }

            return new BigDecimal(dollarQuotation.brlToDollarQuotation.getAsk());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
