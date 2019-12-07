package cn.kspshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {

    @RequestMapping("/forum")
    public String forumIndex(){
        return "forum";
    }

    @RequestMapping("/forum/list")
    public String topicList(){
        return "topicList";
    }

    @RequestMapping("/forum/new")
    public String topicNew(){
        return "topicNew";
    }

    @RequestMapping("/forum/detail")
    public String topicDetail(){
        return "topicDetail";
    }
}
