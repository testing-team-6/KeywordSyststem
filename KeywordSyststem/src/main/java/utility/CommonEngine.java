package utility;
import config.LoginKeyWords;

import java.lang.reflect.Method;
public class CommonEngine {
    //	执行关键字中的方法
    public static void Action(String Keywords,Object actionKeyWords,String r,int sRowNum,boolean bResult){
        if (actionKeyWords instanceof LoginKeyWords){Contants.excelName = Contants.loginExcelName;}
        else {Contants.excelName = Contants.setQuestionExcelName;}

//		new LoginKeyWords();
//		java反射拿到对应的所有方法
        /*actionKeyWords= new LoginKeyWords();*/
        Method[] method=actionKeyWords.getClass().getMethods();
        for(int i=0;i<method.length;i++){
            if(method[i].getName().trim().equals(Keywords)){


                System.out.println(method[i].getName()+"#######"+actionKeyWords+Keywords+"#######"+r);

                try {
                    method[i].invoke(actionKeyWords,r);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(bResult == true){
                    ExcelUtils.setCellData(Contants.pass, sRowNum, Contants.caseResult,Contants.excelFile+Contants.excelName, Contants.caseSheet);
                }else{
                    ExcelUtils.setCellData(Contants.fail, sRowNum, Contants.caseResult,Contants.excelFile+Contants.excelName, Contants.caseSheet);
                    /*actionKeyWords.CloseBrowser(r);*/
                }
                break;
            }
        }
    }
}
