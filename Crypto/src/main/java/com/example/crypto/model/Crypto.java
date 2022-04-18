package com.example.crypto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.annotation.Documented;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Crypto {
    @Id
    @JsonProperty("id")
    private  String id;
    @JsonProperty("symbol")
    private  String symbol;
    @JsonProperty("name")
    private  String name;
    @JsonProperty("image")
    private  String image;
    @JsonProperty("current_price")
    private  double currentPrice;
    @JsonProperty("high_24h")
    private  double high24h;
    @JsonProperty("low_24h")
    private double  low24h;
    @JsonProperty("market_cap_rank")
    private int marketCapRank;
}
