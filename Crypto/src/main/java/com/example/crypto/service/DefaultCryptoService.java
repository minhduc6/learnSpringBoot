package com.example.crypto.service;

import com.example.crypto.model.Crypto;
import com.example.crypto.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Service
public class DefaultCryptoService implements CryptoService {


    private final RestTemplate restTemplate;
    private final CryptoRepository cryptoRepository;



    private static final String URL = "https://api.coingecko.com/api/v3/";


    final String CURRENCY = "vs_currency=pln";
    final String PER_PAGE = "per_page=50";
    final String PAGE = "page=1";

    @Autowired
    public DefaultCryptoService(RestTemplate restTemplate, CryptoRepository cryptoRepository) {
        this.restTemplate = restTemplate;
        this.cryptoRepository = cryptoRepository;
    }


    @Override
    public List<Crypto> getCrypto() {
        ResponseEntity<List<Crypto>> rateResponse = restTemplate
                .exchange(URL + "coins/markets?" + CURRENCY + "&" +PER_PAGE+"&"+PAGE, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Crypto>>() {
                        });
        List<Crypto> cryptoList = rateResponse.getBody();
        //cryptoRepository.saveAll(cryptoList);
        return cryptoList;
    }

}
