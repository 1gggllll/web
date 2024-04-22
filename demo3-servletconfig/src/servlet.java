import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Name;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName: servlet
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/19 19:13
 * @Version 1.0
 */
@WebServlet(
        urlPatterns = "/servlet1",
        initParams = {@WebInitParam(name = "key",value = "value")}

)
public class servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String key= servletConfig.getInitParameter("key");
        System.out.println("key:"+key);
        Enumeration<String> initPaeameterNames = servletConfig.getInitParameterNames();
        while (initPaeameterNames.hasMoreElements()){
            String pname=initPaeameterNames.nextElement();
            System.out.println(pname+"="+getInitParameter(pname));
            //SeverletContext的应用与上述基本类似
            //ServletContext的更多应用API
            //1.获取真实路径getRealPath
            ServletContext servletContext = getServletContext();
            String path=servletContext.getRealPath("upload");
            FileOutputStream fo=new FileOutputStream(path+"/a.text");
            //2.获取项目部署的上下文路径getContextPath
            String contextPath =servletContext.getContextPath();
            System.out.println(contextPath);///demo3_servletconfig_war_exploded
            //3.| void setAttribute(String key,Object value); | 向域中存储/修改数据 |
            //| Object getAttribute(String key);            | 获得域中的数据      |
            //| void removeAttribute(String key);           | 移除域中的数据      |
        }
    }
}
