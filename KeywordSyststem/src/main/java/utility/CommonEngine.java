package utility;
import config.LoginKeyWords;

import java.lang.reflect.Method;
public class CommonEngine {
    //	执行关键字中的方法
    public static void Action(String Keywords,Object actionKeyWords,String r,int sRowNum,boolean bResult){
        if (actionKeyWords instanceof LoginKeyWords){
            Constants.excelName = Constants.loginExcelName;}
        else {
            Constants.excelName = Constants.setQuestionExcelName;}

//		new LoginKeyWords();
//		java反射拿到对应的所有方法
        /*actionKeyWords= new LoginKeyWords();*/
        Method[] method=actionKeyWords.getClass().getMethods();
        for(int i=0;i<method.length;i++){
            if(method[i].getName().trim().equals(Keywords)){


                System.out.println(method[i].getName()+"#######"+actionKeyWords+Keywords+"#######"+r);

                try {
                    method[i].invoke(actionKeyWords);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(bResult == true){
                    ExcelUtils.setCellData(Constants.pass, sRowNum, Constants.caseResult, Constants.excelFile+ Constants.excelName, Constants.caseSheet);
                }else{
                    ExcelUtils.setCellData(Constants.fail, sRowNum, Constants.caseResult, Constants.excelFile+ Constants.excelName, Constants.caseSheet);
                    /*actionKeyWords.CloseBrowser(r);*/
                }
                break;
            }
        }
    }
}
