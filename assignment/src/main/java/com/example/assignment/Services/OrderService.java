package com.example.assignment.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.example.assignment.Dtos.Item;
import com.example.assignment.Dtos.Merchant;
import com.example.assignment.Dtos.OrderRequest;
import com.example.assignment.Dtos.OrderResponse;
import com.example.assignment.Dtos.TotalAmount;
import com.example.assignment.Util.RestTemplateUtil;

@Component
public class OrderService {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Value("${create.order}")
    private String CREATE_ORDER;

    @Value("${auth.key}")
    private String AUTH_KEY;

    @Value("${redirect.cancel}")
    private String REDIRECT_CANCLE;

    @Value("${redirect.confirm}")
    private String REDIRECT_CONFIRM;

    public TotalAmount createTotalAmount(List<Item> items) {
        TotalAmount totalAmount = new TotalAmount();
        int totalPrice = 0;
        List<String> currencries = new ArrayList<>();
        for (Item item : items) {
            currencries.add(item.getPrice().getCurrency());
            int itemPrice = Integer.parseInt(item.getPrice().getAmount());
            itemPrice *= item.getQuantity();
            totalPrice += itemPrice;
        }
        String getCurrency = currencries.stream().findFirst().get();
        totalAmount.setAmount(String.valueOf(totalPrice));
        totalAmount.setCurrency(getCurrency);

        return totalAmount;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        ResponseEntity<OrderResponse> orderResponse = null;
        Merchant merchant = new Merchant(REDIRECT_CANCLE, REDIRECT_CONFIRM);
        orderRequest.setMerchant(merchant);

        // HttpHeaders headers = new HttpHeaders();

        // headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.add("Authorization", "Bearer " + AUTH_KEY);
        // headers.add("accept", "application/json");
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("Authorization", "Bearer " + AUTH_KEY);
        HttpEntity<OrderRequest> request = new HttpEntity<OrderRequest>(orderRequest,
                headers);
        orderResponse = restTemplateUtil.createRestTemplate().postForEntity(CREATE_ORDER, request,
                OrderResponse.class);

        return orderResponse.getBody();
    }

}
