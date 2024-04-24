import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/23 20:01
 * @Version 1.0
 */
@WebServlet(
        urlPatterns = "/aaa",
        initParams = {@WebInitParam(name = "key",value = "中")}


)
public class luanma extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String key= servletConfig.getInitParameter("key");
       //resp.setContentType("text/html;charset=GBK");
        resp.setCharacterEncoding("GBK");
        PrintWriter writer = resp.getWriter();
        System.out.println("6666"+key);
        writer.write(key);
    }
}
