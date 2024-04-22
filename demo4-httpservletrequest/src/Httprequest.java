import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
    }
}
