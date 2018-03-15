package com.yisutech.iisp.webapp;

import freemarker.template.utility.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;

/**
 * 首页控制器
 *
 * @author guangzhong.wgz
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage(Model model) {

        model.addAttribute("test", "当前时间为" + Calendar.getInstance().getTime());

        return "homePage";
    }
}
