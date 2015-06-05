package trieu.doan.templates.pages;

import info.magnolia.module.blossom.annotation.*;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import trieu.doan.templates.components.Promo;
import trieu.doan.templates.components.TextComponent;

/**
 * Created by trieudoan on 6/3/2015.
 */
@Controller
@Template(title = "Main", id = "bookStoreModule:pages/main")
public class MainTemplate {
    @RequestMapping("/main")
    public String render() {
        return "pages/main.jsp";
    }

    @Area("main")
    @Controller
    @AvailableComponentClasses({})
    public static class MainArea {

        @RequestMapping("/mainTemplate/main")
        public String render() {
            return "areas/mainArea.jsp";
        }
    }

    @Area("promos")
    @Inherits
    @AvailableComponentClasses({Promo.class})
    @Controller
    public static class PromosArea {
        @RequestMapping("mainTemplate/promos")
        public String render(){
            return "areas/promos.jsp";
        }
    }

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("title").label("Title"),
                cfg.fields.checkbox("hideInNavigation").label("Hide in navigation").description("Check this box to hide this page in navigation").buttonLabel("")
        );
    }
}
