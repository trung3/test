package pc01815.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.lab4.bean.DB;

@Controller
public class ItemController {
    @RequestMapping("/item/index")
    public String list(Model m) {
    	m.addAttribute("items",DB.items.values());
    	return "item/index";
    }
}
