package com.example.assignment.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.example.assignment.Dtos.OrderRequest;
import com.example.assignment.Dtos.OrderResponse;
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

    public OrderResponse createOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = null;
        orderRequest.getMerchant().setRedirectCancelUrl(REDIRECT_CANCLE);
        orderRequest.getMerchant().setRedirectConfirmUrl(REDIRECT_CONFIRM);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + AUTH_KEY);
        orderResponse = restTemplateUtil.createRestTemplate().postForObject(CREATE_ORDER, orderRequest,
                OrderResponse.class, headers);

        return orderResponse;
    }

}
