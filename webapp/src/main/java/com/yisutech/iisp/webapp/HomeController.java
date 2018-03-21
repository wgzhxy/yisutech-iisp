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

    @RequestMapping("/index")
    public String homePageIndex(Model model) {

        return "index";
    }

    @RequestMapping("/tables")
    public String tables(Model model) {
        return "tables";
    }

    @RequestMapping("/tables-advanced")
    public String tables_advanced(Model model) {
        return "tables-advanced";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        return "users";
    }

    @RequestMapping("/calendar")
    public String calendar(Model model) {
        return "calendar";
    }

    @RequestMapping("/gallery")
    public String gallery(Model model) {
        return "gallery";
    }

    @RequestMapping("/gallery-v2")
    public String galleryV2(Model model) {
        return "gallery-v2";
    }

    @RequestMapping("/pricing")
    public String pricing(Model model) {
        return "pricing";
    }

    @RequestMapping("/form-elements")
    public String formElements(Model model) {
        return "form-elements";
    }

    @RequestMapping("/x-editable")
    public String xEditable(Model model) {
        return "x-editable";
    }

    @RequestMapping("/ui-elements")
    public String uiElements(Model model) {
        return "ui-elements";
    }

    @RequestMapping("/email-inbox")
    public String emailInbox(Model model) {
        return "email-inbox";
    }

    @RequestMapping("/email-detail")
    public String emailDetail(Model model) {
        return "email-detail";
    }

    @RequestMapping("/email-compose")
    public String emailCompose(Model model) {
        return "email-compose";
    }

    @RequestMapping("/graphs-morris")
    public String graphsMorris(Model model) {
        return "graphs-morris";
    }

    @RequestMapping("/graphs-flot")
    public String graphsFlot(Model model) {
        return "graphs-flot";
    }

    @RequestMapping("/graphs-dygraphs")
    public String graphsDygraphs(Model model) {
        return "graphs-dygraphs";
    }

    @RequestMapping("/graphs-xcharts")
    public String graphsXcharts(Model model) {
        return "graphs-xcharts";
    }

    @RequestMapping("/widgets")
    public String widgets(Model model) {
        return "widgets";
    }

    @RequestMapping("/maps")
    public String maps(Model model) {
        return "maps";
    }

    @RequestMapping("/user-profile")
    public String userProfile(Model model) {
        return "user-profile";
    }

    @RequestMapping("/search")
    public String search(Model model) {
        return "search";
    }

    @RequestMapping("/projects")
    public String projects(Model model) {
        return "projects";
    }

    @RequestMapping("/team-members")
    public String teamMembers(Model model) {
        return "team-members";
    }

    @RequestMapping("/timeline")
    public String timeline(Model model) {
        return "timeline";
    }

    @RequestMapping("/timeline-grid")
    public String timelineGrid(Model model) {
        return "timeline-grid";
    }

    @RequestMapping("/invoice")
    public String invoice(Model model) {
        return "invoice";
    }

    @RequestMapping("/intro")
    public String intro(Model model) {
        return "intro";
    }

}
