package Web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI(); // ：/brand-demo/brand/add 

        int index = uri.lastIndexOf("/");

        String methodname = uri.substring(index+1);  // add

        Class<? extends BaseServlet> cls = this.getClass();

        try {
            Method method = cls.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
