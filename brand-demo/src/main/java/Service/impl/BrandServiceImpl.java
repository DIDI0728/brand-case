package Service.impl;

import Mapper.BrandMapper;
import Pojo.Brand;
import Pojo.PageBean;
import Service.BrandService;
import Utils.sqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    SqlSessionFactory sqlSessionFactory= sqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return  brands;

    }

    @Override
    public void updata(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.updata(brand);
        sqlSession.commit();
        sqlSession.close();
    }


    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }

//    @Override
//    public PageBean selectByPage(int currentpage, int pagesize) {
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//
//        int begin=(currentpage-1)*pagesize;
//        int size=pagesize;
//
//        List<Brand> rows = mapper.selectByPage(begin, size);
//
//        int total = mapper.selectTotal();
//
//        PageBean pageBean=new PageBean();
//        pageBean.setList(rows);
//        pageBean.setTotal(total);
//
//        return pageBean;
//
//
//    }

    @Override
    public PageBean selectByPageAndCondition(int currentpage, int pagesize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin=(currentpage-1)*pagesize;
        int size=pagesize;

        //参数模糊处理

        String brand_name = brand.getBrand_name();
        String company_name = brand.getCompany_name();


        if(brand_name!=null && brand_name.length()>0){
            brand.setBrand_name("%"+brand_name+"%");
        }


        if(company_name!=null && company_name.length()>0){
            brand.setCompany_name("%"+company_name+"%");
        }


        List<Brand> rows = mapper.selectByPageAndCondition(begin, size,brand);

        int totalmount = mapper.selectTotalCondition();


        return new PageBean(totalmount,rows);
    }
}
