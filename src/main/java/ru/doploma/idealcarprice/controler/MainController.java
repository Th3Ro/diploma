package ru.doploma.idealcarprice.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        SelectedItemsByUserHelper.clearSelectedVendorCodesAndDefects();
//        SelectedItemsByUserHelper.clearSelectedDetails();
        return "index";
    }
}
