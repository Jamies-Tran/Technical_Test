package com.example.assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assignment.Dtos.Item;
import com.example.assignment.Dtos.ItemQuantity;
import com.example.assignment.repositories.ItemRespository;

import jakarta.servlet.http.HttpSession;

@Controller
public class QuantityController {

    @Autowired
    private ItemRespository itemRepo;

    // @GetMapping("/quantity")
    // @SuppressWarnings("unchecked")
    // public String directQuantity(Model model, HttpSession session,
    // @ModelAttribute Item item) {
    // List<Item> items = (List<Item>) session.getAttribute("items");
    // model.addAttribute("items", items);

    // return "quantity";
    // }

    @GetMapping("/quantity")
    public String directQuantity(Model model, HttpSession session, @ModelAttribute ItemQuantity itemQuantity) {
        Item item = (Item) session.getAttribute("item");
        model.addAttribute("item", item);

        return "quantity";
    }

    @PostMapping("/specify-quantity/{itemName}")
    public String specifyQuantity(Model model, HttpSession session, @PathVariable String itemName,
            @ModelAttribute ItemQuantity itemQuantity) {
        Item item = itemRepo.findItemByName(itemName);
        if (itemQuantity.getQuantity() == null) {
            itemQuantity.setQuantity(1);
        }
        item.setQuantity(itemQuantity.getQuantity());

        session.setAttribute("item", item);

        return "redirect:/order";
    }
}
