package Service;

import Pojo.Brand;
import Pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void updata(Brand brand);

    void  add(Brand brand);

    void deleteByIds(int[] ids);

    void deleteById(int id);
//
//    PageBean selectByPage(int currentpage,int pagesize);

    PageBean selectByPageAndCondition(int currentpage,int pagesize,Brand brand);
}
