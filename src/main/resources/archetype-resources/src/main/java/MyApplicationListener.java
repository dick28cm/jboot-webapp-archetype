#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.jfinal.config.Constants;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Routes;
import com.jfinal.log.Log;
import com.jfinal.template.Engine;
import io.jboot.aop.jfinal.JfinalHandlers;
import io.jboot.aop.jfinal.JfinalPlugins;
import io.jboot.app.config.JbootConfigManager;
import io.jboot.core.listener.JbootAppListener;
import io.jboot.web.fixedinterceptor.FixedInterceptors;

/**
 * 自定义的ApplicationListener
 * 这玩意让你可以配置jfinalConfig,具体参考http://jboot.io/docs/jfinalConfig.html
 */
public class MyApplicationListener implements JbootAppListener {
    //view的路径,放/WEB-INF是为了防止别人把你的模版都搞出来,也许你不需要设置
    private static final String BASE_VIEW_PATH = "/WEB-INF/view";
    //日志就是为了看看生命周期
    private static Log log = Log.getLog(MyApplicationListener.class);

    // 初始化
    public void onInit() {
        log.debug("onInit...");

        //设置自己的解密器, 参考文档 http://jboot.io/docs/config.html${symbol_pound}配置内容加密解密
        JbootConfigManager.me().setDecryptor(new MyConfigDecriptor());
    }

    //配置jfinal路由
    public void onRouteConfig(Routes routes) {
        log.debug("onRouteConfig...");

        //设置view的路径
        routes.setBaseViewPath(BASE_VIEW_PATH);
    }

    //对照jfinal的configRoute
    public void onConstantConfig(Constants constants) {
        log.debug("onConstantConfig...");
    }

    //对照jfinal
    public void onEngineConfig(Engine engine) {
        log.debug("onEngineConfig...");
    }

    //永久拦截器
    public void onFixedInterceptorConfig(FixedInterceptors fixedInterceptors) {
        log.debug("onFixedInterceptorConfig...");
    }

    //配置jfinal处理器
    public void onHandlerConfig(JfinalHandlers handlers) {
        log.debug("onHandlerConfig...");
    }

    //配置jfinal拦截器
    public void onInterceptorConfig(Interceptors interceptors) {
        log.debug("onInterceptorConfig...");
    }

    //配置jfinal插件
    public void onPluginConfig(JfinalPlugins plugins) {
        log.debug("onPluginConfig...");
    }


    public void onStart() {
        log.debug("jboot webapp onStart...");
    }

    public void onStartBefore() {
        log.debug("onStartBefore...");
    }

    public void onStartFinish() {
        log.info("jboot webapp onStartFinish...");
    }

    public void onStop() {
        log.debug("onStop...");
    }

}
