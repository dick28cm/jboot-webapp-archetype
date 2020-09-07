#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.jboot.app.JbootApplication;

/**
 * jboot启动器
 */
public class MyJbootStarter {

    public static void main(String[] args) {
        JbootApplication.run(args);
    }
}
