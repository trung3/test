package pc01815.lab4.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pc01815.lab4.bean.CookieService;
import pc01815.lab4.bean.ParamService;
import pc01815.lab4.bean.SessionService;

@Controller
public class AccountController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
    	return "account/login";
    }
    @PostMapping("/account/login")
    public String login2(Model m,@RequestParam("file") MultipartFile file) {
    	String name = paramService.getString("usename","");
    	String pass = paramService.getString("password","");
    	boolean rm = paramService.getBoolean("remember", false);
    	if(name.equals("poly") && pass.equals("123")) {
    		sessionService.setAttribute("usename", name);
    		if(rm) {
    			cookieService.add("user", name, 10);
    			cookieService.add("pass", pass, 10);
    			m.addAttribute("luu","Đã lưu lại tài khoản");
    		}else {
    			cookieService.remove("user");
    			cookieService.remove("pass");
    		}
    		m.addAttribute("tb","Đăng nhập thành công");
    		
    	}else {
    		m.addAttribute("tb","Đăng nhập thất bại");
    	}	   
    		   File savefile =paramService.save(file,"hinh");
    	 
    		
    
    		
    	
    	return "account/login";
    }
}
