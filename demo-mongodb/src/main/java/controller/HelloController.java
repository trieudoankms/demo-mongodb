package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by trieudoan on 5/22/2015.
 */
@Controller
@RequestMapping("/welcome")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String printWebcome(){
       /* ModelAndView model = new ModelAndView("hello");

        model.addObject("message", "Spring 3 MVC Hello World");
        return model;*/
        return "Hello World!";
    }
}
