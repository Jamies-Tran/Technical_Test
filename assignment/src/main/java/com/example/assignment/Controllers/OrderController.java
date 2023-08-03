package com.example.assignment.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assignment.Dtos.Consumer;
import com.example.assignment.Dtos.Item;
import com.example.assignment.Dtos.OrderRequest;
import com.example.assignment.Dtos.OrderResponse;
import com.example.assignment.Dtos.Shipping;
import com.example.assignment.Dtos.TotalAmount;
import com.example.assignment.Services.OrderService;
import com.example.assignment.Util.ErrorHandlerUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String redirectOrder(Model model, HttpSession session, @ModelAttribute Shipping shipping) {

        Item item = (Item) session.getAttribute("item");
        List<Item> chosenItems = new ArrayList<>();

        if (session.getAttribute("items") != null) {
            chosenItems.addAll((List<Item>) session.getAttribute("items"));

        }

        chosenItems.add(item);

        TotalAmount totalAmount = orderService.createTotalAmount(chosenItems);

        Consumer consumer = (Consumer) session.getAttribute("consumer");

        model.addAttribute("chosenItems", chosenItems);

        model.addAttribute("totalAmount", totalAmount);

        model.addAttribute("consumer", consumer);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setTotalAmount(totalAmount);
        orderRequest.setItems(chosenItems);
        orderRequest.setConsumer(consumer);
        session.setAttribute("orderRequest", orderRequest);

        return "order";

    }

    @GetMapping("/choose-more-item")
    public String chooseMoreItem(Model model, HttpSession session) {
        OrderRequest orderRequest = (OrderRequest) session.getAttribute("orderRequest");

        session.setAttribute("items", orderRequest.getItems());

        return "redirect:/item";
    }

    @PostMapping("/create-order")
    public String createOrder(Model model, HttpSession session, @ModelAttribute Shipping shipping) {
        OrderRequest orderRequest = (OrderRequest) session.getAttribute("orderRequest");
        String errorStr = ErrorHandlerUtil.shippingErrString(shipping);

        if (errorStr != null) {
            model.addAttribute("errorStr", errorStr);
            model.addAttribute("totalAmount", orderRequest.getTotalAmount());
            model.addAttribute("chosenItems", orderRequest.getItems());
            return "order";
        }

        orderRequest.setShipping(shipping);
        OrderResponse orderResponse = orderService.createOrder(orderRequest);
        session.setAttribute("orderResponse", orderResponse);

        return "redirect:" + orderResponse.getCheckoutUrl();
    }
}
