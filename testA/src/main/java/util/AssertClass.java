package util;


/**
 * Created by Administrator on 2019/4/12.
 * 断言，使用PostClass类，返回response
 */
public class AssertClass {

    public PostClass postClass = new PostClass();

    public void assertStatusMethod(int qiwang){
        int shiji = 200;
        if( shiji == qiwang){
            System.out.println("返回状态码正确code");
        }
        else {
            System.out.println("请求有误，请查看");
        }

    }

    public void assertStatusMethod(int shiji ,int qiwang){

        if( shiji== qiwang){
            System.out.println("实际结果和期望结果一致，测试通过");
        }
        else {
            System.out.println("请求有误，请查看");
        }

    }

    public void assertStatusMethod(String shiji,String qiwang) {

        if (shiji == qiwang) {
            System.out.println("返回值正确");
        } else {
            System.out.println("返回值错误，请查看");
        }


//    public void assertValueMethod(String result){
//        Assert.assertEquals();
//
//    }


    }}
