import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: Servletclass
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/16 17:06
 * @Version 1.0
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request获取请求中的信息
       String username= request.getParameter("username");
        //处理业务代码
String info="YES";
if("zhangsan".equals(username)){
    info="NO";
}
//设置response的Content-Type响应头
        //response.setHeader("Content-Type","text/html");
        response.setContentType("text/html");
        //将要响应的数据放到response对象
        PrintWriter writer = response.getWriter();
writer.write(info);
    }
}
