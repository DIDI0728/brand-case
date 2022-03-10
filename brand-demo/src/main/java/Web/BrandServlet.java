package Web;

import Pojo.Brand;
import Pojo.PageBean;
import Service.BrandService;
import Service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Brand/*")
public class BrandServlet extends BaseServlet {
    BrandService brandService= new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/json;charset=utf-8");
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        response.getWriter().write(jsonString);

    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        BufferedReader reader = request.getReader();
        String jsonstring = reader.readLine();

        Brand brand = JSON.parseObject(jsonstring, Brand.class);

        brandService.add(brand);
        response.getWriter().write("success");


    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        BufferedReader reader = request.getReader();
        String line = reader.readLine();//[1,2,3]

        int[] ids = JSON.parseObject(line, int[].class);

        brandService.deleteByIds(ids);
        response.getWriter().write("success");


    }

//    public void selectBypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        String _currentpage = request.getParameter("currentpage");
//        String _pagesize = request.getParameter("pagesize");
//        int pagesize = Integer.parseInt(_pagesize);
//        int currentpage = Integer.parseInt(_currentpage);
//
//        PageBean pageBean = brandService.selectByPage(currentpage, pagesize);
//
//        response.setContentType("text/json;charset=utf-8");
//
//        String jsonString = JSON.toJSONString(pageBean);
//        response.getWriter().write(jsonString);
//
//    }


    public void selectBypageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String _currentpage = request.getParameter("currentpage");
        String _pagesize = request.getParameter("pagesize");
        int pagesize = Integer.parseInt(_pagesize);
        int currentpage = Integer.parseInt(_currentpage);


        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        Brand brand = JSON.parseObject(line, Brand.class);

        PageBean pageBean = brandService.selectByPageAndCondition(currentpage, pagesize,brand);

        response.setContentType("text/json;charset=utf-8");

        String jsonString = JSON.toJSONString(pageBean);

        response.getWriter().write(jsonString);

    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String _id = request.getParameter("id");
        int id = Integer.parseInt(_id);

        brandService.deleteById(id);

        response.getWriter().write("success");


    }

    public void updata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String line = request.getReader().readLine();

        Brand brand = JSON.parseObject(line, Brand.class);

        brandService.updata(brand);

        response.getWriter().write("success");


    }







}
