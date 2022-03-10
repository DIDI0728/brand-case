package Mapper;

import Pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

//    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
//
//    int selectTotal();

    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    int selectTotalCondition();

    void deleteById(int id);


    void updata(Brand brand);

}
