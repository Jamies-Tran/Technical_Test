package com.example.assignment.Util;

import org.springframework.util.StringUtils;

import com.example.assignment.Dtos.Consumer;
import com.example.assignment.Dtos.Shipping;

public class ErrorHandlerUtil {

    public static String shippingErrString(Shipping shipping) {
        if (!StringUtils.hasLength(shipping.getPhoneNumber()) || shipping.getPhoneNumber() == "") {
            return "Enter phone number";
        } else if (!StringUtils.hasLength(shipping.getCountryCode()) || shipping.getCountryCode() == "") {
            return "Enter country code";
        } else if (!StringUtils.hasLength(shipping.getName()) || shipping.getName() == "") {
            return "Enter name";
        } else if (!StringUtils.hasLength(shipping.getPostCode()) || shipping.getPostCode() == "") {
            return "Enter post code";
        } else if (!StringUtils.hasLength(shipping.getSuburb()) || shipping.getSuburb() == "") {
            return "Enter suburb";
        } else if (!StringUtils.hasLength(shipping.getLine1()) || shipping.getLine1() == "") {
            return "Enter address";
        }

        if (shipping.getCountryCode().length() > 2) {
            return "Invalid country code";
        }
        return null;
    }

    public static String consumerErrString(Consumer consumer) {
        if (!StringUtils.hasLength(consumer.getGivenNames()) || consumer.getGivenNames() == "") {
            return "Enter your first name";
        } else if (!StringUtils.hasLength(consumer.getSurname()) || consumer.getSurname() == "") {
            return "Enter your surname";
        }
        return null;
    }
}
