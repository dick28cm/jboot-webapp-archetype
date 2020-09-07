#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.jboot.app.config.JbootConfigDecryptor;

/**
 * 自定义的配置解密器,参考文档http://jboot.io/docs/config.html${symbol_pound}配置内容加密解密
 */
public class MyConfigDecriptor implements JbootConfigDecryptor {

    /**
     * 解密
     *
     * @param key
     * @param originalContent
     * @return
     */
    public String decrypt(String key, String originalContent) {
        //原样输出
        return originalContent;
    }

}
