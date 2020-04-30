package script;

import config.*;
import startEngine.*;
//运行测试的类，基本上不用改。
//main函数里面引用后执行相关测试
public class Test {
    public static Object actionKeyWords;

    public static void Login() throws Exception {
        actionKeyWords=new LoginKeyWords();
        ExcelEngine.StartEngine(actionKeyWords);
    }

    public static void setQuestion() throws Exception {
        actionKeyWords = new SetQuestionKeyWords();
        ExcelEngine.StartEngine(actionKeyWords);
    }
}
