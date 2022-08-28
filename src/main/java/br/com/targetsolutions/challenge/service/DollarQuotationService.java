package br.com.targetsolutions.challenge.service;

import br.com.targetsolutions.challenge.client.DollarQuotationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class DollarQuotationService {

    private static final Logger LOG = LoggerFactory.getLogger(DollarQuotationService.class);

    private final DollarQuotationClient dollarQuotationClient;

    private Instant lastQuotationRequestInstant = null;
    private BigDecimal lastDollarQuotation = null;

    public DollarQuotationService(DollarQuotationClient dollarQuotationClient) {
        this.dollarQuotationClient = dollarQuotationClient;
    }

    public BigDecimal getDollarQuotationNow() {
        if (shouldGetNewQuotation()) {
            LOG.info("m=getDollarQuotationNow, message=Last quotation expired, getting new dollar quotation");
            lastDollarQuotation = dollarQuotationClient.getDollarQuotationNow();
            lastQuotationRequestInstant = Instant.now();
        }

        return lastDollarQuotation;
    }

    private boolean shouldGetNewQuotation() {
        return lastQuotationRequestInstant == null || lastQuotationRequestInstant.plusSeconds(30).isBefore(Instant.now());
    }
}
