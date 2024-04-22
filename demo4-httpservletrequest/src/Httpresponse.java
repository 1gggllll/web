import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: Httpresponse
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/22 20:29
 * @Version 1.0
 */
@WebServlet(
        urlPatterns = "/servlet05"
)
public class Httpresponse extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头相关的API
        resp.setStatus(200);
        String info = "<h1>hello</h1>";
        //设置响应头相关的API
//        resp.setHeader("aaa","valuea"); 可以自己随便写
//        resp.setHeader("Content-Type","text/html");
//        resp.setHeader("Content-Length","14");
        resp.setContentType("text/html");
        resp.setContentLength(info.getBytes().length);
        //设置响应体的API
        //获得一个向响应体输入文本字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write(info);
        //获得一个向响应体中输入二进制信息的字节输出流
        //ServletOutputStream outputStream = resp.getOutputStream();
    }
}
