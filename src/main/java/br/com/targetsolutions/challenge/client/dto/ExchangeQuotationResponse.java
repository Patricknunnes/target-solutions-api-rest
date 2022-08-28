package br.com.targetsolutions.challenge.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeQuotationResponse {

    @JsonProperty("USDBRL")
    public CurrencyQuotation brlToDollarQuotation;
}
