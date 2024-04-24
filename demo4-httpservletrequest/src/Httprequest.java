import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * ClassName: Httprequest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/22 18:57
 * @Version 1.0
 */
@WebServlet(
        urlPatterns = "/servlet04"

)
public class Httprequest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        System.out.println(username);
        String[] hobbies=req.getParameterValues("hobby");
        System.out.println(hobbies);
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String pname = parameterNames.nextElement();
            String[] values=req.getParameterValues(pname);
            if(values.length>1){
                System.out.println("pname="+Arrays.toString(values));
            }else {
                System.out.println(values[0]);
            }
        }
        //map方法
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry:entries){
            String pname =entry.getKey();
            String[] value = entry.getValue();
            if(value.length>1){
                System.out.println(pname + "=" + Arrays.toString(value));
            }else {
                System.out.println(pname+"="+value[0]);
            }
        }
        //以上API专门用于key-value形式的，不论在位置在url后还是请求体里面.
       /** 获得请求体中的非键值对数据?
 获取一个从请求体中读取字符的字符输入流
BufferedReader reader = req.getReader(); JSON串
 获得一个从请求中读取二进制数据字节的输入流
 ServletInputStream inputStream = reg.getInputStream();文件
        */
       //请求转发
        /*
        1.请求转发是通过httpservletrequest对象实现的 req.getRequestDisatcher("")
       2.请求转发是服务器内部行为，对客户是屏蔽的
       3.客户端只产生的一次请求，服务器只产生了一对req，resp对象
       4.客户端的地址栏不变
       5.请求的参数是可以继续传递的
       6.目标资源可以是servlet动态资源，也可以是html静态资源
       7.目标资源可以是web-inf下受保护的资源，该方式也是web-inf下资源唯一访问的方式
       8.目标资源不可以是外部资源
         */
        //获得请求转发器
        RequestDispatcher servlet05 = req.getRequestDispatcher("servlet05");
       //RequestDispatcher servlet06 = req.getRequestDispatcher("aaaa.html");
       //RequestDispatcher servley07 = req.getRequestDispatcher("WEB-INF/web-infffff.html");
        //RequestDispatcher servley08 = req.getRequestDispatcher("http://www.atguigu.com"); 不能行
        //让请求转发器做出转发的动作
        servlet05.forward(req,resp);
    }
}

