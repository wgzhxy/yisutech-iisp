package com.yisutech.iisp.webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * 首页控制器
 *
 * @author guangzhong.wgz
 */
@Controller
public class HomeController {

    @Value("${runtime.env}")
    private String runtimeEnv;

    @RequestMapping("/")
    public String homePage(Model model) {

        model.addAttribute("test", Calendar.getInstance().getTime());
        model.addAttribute("env", runtimeEnv);

        return "index";
    }
}
