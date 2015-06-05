package trieu.doan.templates.components;

import info.magnolia.dam.app.ui.config.DamConfig;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by trieudoan on 6/4/2015.
 */
@Controller
@Template(title = "Text", id = "bookStoreModule:components/text")
@Promo
public class TextComponent {
    @RequestMapping("/text")
    public String render() {
        return "components/text.jsp";
    }

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, DamConfig dam, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("heading").label("Heading"),
                dam.fields.assetLink("photo").label("Photo"),
                cfg.fields.richText("body").label("Text body")
        );
    }
}
