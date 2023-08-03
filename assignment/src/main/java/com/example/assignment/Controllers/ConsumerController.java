package com.example.assignment.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assignment.Dtos.Consumer;
import com.example.assignment.Util.ErrorHandlerUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class ConsumerController {

    @GetMapping("/")
    public String directConsumerInfo(Model model, @ModelAttribute Consumer consumer) {

        return "consumer";
    }

    @PostMapping("/consumer")
    public String inputConsumerInfo(Model model, HttpSession session, @ModelAttribute Consumer consumer) {
        String errorMsg = ErrorHandlerUtil.consumerErrString(consumer);
        if (errorMsg != null) {
            model.addAttribute("errorMsg", errorMsg);
            return "consumer";
        }

        session.setAttribute("consumer", consumer);

        return "redirect:/item";
    }
}
