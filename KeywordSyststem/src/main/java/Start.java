
import config.*;
import script.*;
public class Start {

    public static void main(String[] args){
        //测试：运行后会自动打开浏览器。如果打不开浏览器请配置好驱动
//        LoginKeyWords.OpenBrowser();

        //完成所有lab5任务代码后执行
        try {
//            Test.Login();
            Test.setQuestion();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
