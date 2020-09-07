#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test;

import com.jfinal.kit.PathKit;
import io.jboot.app.JbootApplication;
import io.jboot.codegen.model.JbootBaseModelGenerator;
import io.jboot.codegen.model.JbootModelGenerator;
import io.jboot.codegen.service.JbootServiceImplGenerator;
import io.jboot.codegen.service.JbootServiceInterfaceGenerator;

/**
 * 代码生成器
 */
public class CodeGen {

    //链接字符串
    private static final String DB_URL = "jdbc:mysql://127.${version}/demo?characterEncoding=utf8&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
    // 用户名
    private static final String DB_USER = "root";
    //密码
    private static final String DB_PWD = "root";
    //model包名
    private static final String MODEL_PACKAGE_NAME = "${package}.model";
    //service包名
    private static final String SERVICE_PACKAGE_NAME = "${package}.service";

    //右键->运行
    public static void main(String[] args) {
        // 配置数据库的数据源
        JbootApplication.setBootArg("jboot.datasource.url", DB_URL);
        JbootApplication.setBootArg("jboot.datasource.user", DB_USER);
        JbootApplication.setBootArg("jboot.datasource.password", DB_PWD);

        String modelPackage = MODEL_PACKAGE_NAME;
        String baseModelPackage = modelPackage + ".base";

        String modelDir = PathKit.getWebRootPath() + "/src/main/java/" + modelPackage.replace(".", "/");
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/" + baseModelPackage.replace(".", "/");

        System.out.println("start generate...");
        System.out.println("generate dir:" + modelDir);

        // 生成 Model
        new JbootBaseModelGenerator(baseModelPackage, baseModelDir).setGenerateRemarks(true).generate();
        new JbootModelGenerator(modelPackage, baseModelPackage, modelDir).generate();

        String servicePackage = SERVICE_PACKAGE_NAME;
        String serviceImplPackage = SERVICE_PACKAGE_NAME + ".impl";

        String serviceOutputDir = PathKit.getWebRootPath() + "/src/main/java/" + servicePackage.replace(".", "/");
        String serviceImplOutputDir = PathKit.getWebRootPath() + "/src/main/java/"
                + serviceImplPackage.replace(".", "/");

        // 生成 Service 接口 及其 实现类
        new JbootServiceInterfaceGenerator(servicePackage, serviceOutputDir, modelPackage).generate();
        new JbootServiceImplGenerator(servicePackage, serviceImplOutputDir, modelPackage).setImplName("impl")
                .generate();

        System.out.println("generate done!!!");
    }
}
