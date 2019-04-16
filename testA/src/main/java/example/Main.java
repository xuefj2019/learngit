package example;

/**
 * Created by Administrator on 2019/4/3.
 */
import org.apache.ibatis.session.SqlSession;


public class Main {

    public static void main(String[] args) throws Exception {

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.openSession();
            AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);

            Admin admin = adminMapper.getAdmin(1);
            System.out.println(admin);

            sqlSession.commit();

        } catch (Exception e) {
            System.out.println(e);
            sqlSession.rollback();
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

}