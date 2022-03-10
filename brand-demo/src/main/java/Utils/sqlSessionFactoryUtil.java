package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.misc.Resource;

import java.io.IOException;
import java.io.InputStream;

public class sqlSessionFactoryUtil {

    private  static SqlSessionFactory sqlSessionFactory;



    static {
        try {
            String resouce="mybatis-config.xml";
            InputStream inputStream;
            inputStream = Resources.getResourceAsStream(resouce);
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
