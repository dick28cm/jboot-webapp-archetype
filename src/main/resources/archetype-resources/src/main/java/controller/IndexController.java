#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import io.jboot.aop.annotation.ConfigValue;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * 首页控制器
 */
@RequestMapping("/")
public class IndexController extends JbootController {

    //这里测试的是nacos配置中心的值
    @ConfigValue("web.name")
    private String webname;

    //首页方法
    public void index() {
        render("index.html");
    }

    //网站名
    public void webname() {
        renderText("来自nacos中的值: " + webname);
    }
}
