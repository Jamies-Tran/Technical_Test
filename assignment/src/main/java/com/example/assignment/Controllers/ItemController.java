package com.example.assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assignment.Dtos.Item;
import com.example.assignment.Dtos.ItemListName;
import com.example.assignment.repositories.ItemRespository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {

    @Autowired
    private ItemRespository itemRepo;

    @GetMapping("/item")
    public String directItemSelection(Model model, @ModelAttribute ItemListName itemName) {
        model.addAttribute("items", itemRepo.getAll());

        return "item";
    }

    // @PostMapping("/select-item")
    // public String selectItem(Model model, HttpSession session, @ModelAttribute
    // ItemListName selectedItemListName) {
    // List<Item> selectedItemList = new ArrayList<>();
    // for (String name : selectedItemListName.getNames()) {
    // Item selectedItem = items.stream().filter((item) ->
    // item.getName().equalsIgnoreCase(name))
    // .findFirst().get();
    // selectedItemList.add(selectedItem);
    // }

    // session.setAttribute("items", selectedItemList);

    // return "redirect:/quantity";
    // }

    @PostMapping("/select-item/{itemName}")
    public String selectItem(Model model, HttpSession session, @PathVariable String itemName) {

        Item selectedItem = itemRepo.findItemByName(itemName);

        session.setAttribute("item", selectedItem);

        return "redirect:/quantity";
    }
}
