package startEngine;

import config.LoginKeyWords;
import utility.CommonEngine;
import utility.Constants;
import utility.ExcelUtils;
//这个类的处理逻辑是和Excel表格对应的，如果要更改Excel只需要改这个类，或者新增加一个和Excel对应的类
public class ExcelEngine {
    public static String Keywords=null;
    public static String r;
    public static boolean bResult;

    public static void StartEngine(Object actionKeyWords) throws Exception {
        if (actionKeyWords instanceof LoginKeyWords){
            Constants.excelName = Constants.loginExcelName;}
        else {
            Constants.excelName = Constants.setQuestionExcelName;}

        /*LOGINKEYWORDS ACTIONKEYWORDS=NEW LOGINKEYWORDS();*/
        ExcelUtils.setExcelFile(Constants.excelFile+ Constants.excelName );
        bResult = true;
//		循环读取suitSheet里面的值，找出运行的场景
        for(int j = 1; j<=ExcelUtils.getLastRowNums(Constants.suitSheet); j++){

            String Runmode=ExcelUtils.getCellDate(j, Constants.suitRunmode, Constants.suitSheet);
            String suitTestSuiteId=ExcelUtils.getCellDate(j, Constants.suitTestSuiteId, Constants.suitSheet);
            int sRowNum;

            if(Runmode.equals("YES")){
//				根据stepTestSuiteId在caseSheet中循环查找相对应的执行步骤
                for(sRowNum=1; sRowNum<=ExcelUtils.getLastRowNums(Constants.caseSheet); sRowNum++){
                    String stepTestSuiteId=ExcelUtils.getCellDate(sRowNum, Constants.stepTestSuiteId, Constants.caseSheet);
                    System.out.println(ExcelUtils.getCellDate(sRowNum, Constants.excelKWCloNum, Constants.caseSheet));
                    if(stepTestSuiteId.trim().equals(suitTestSuiteId)){
                        Keywords=ExcelUtils.getCellDate(sRowNum, Constants.excelKWCloNum, Constants.caseSheet);
                        r=ExcelUtils.getCellDate(sRowNum, Constants.excelPOCloNum, Constants.caseSheet);
                        CommonEngine.Action(Keywords,actionKeyWords, r, sRowNum, bResult);
                        if(bResult == false){
                            ExcelUtils.setCellData(Constants.fail, j, Constants.suitResult, Constants.excelFile+ Constants.excelName, Constants.suitSheet);

                        }
                    }
                }
                if(bResult == true){
                    ExcelUtils.setCellData(Constants.pass, j, Constants.suitResult, Constants.excelFile+ Constants.excelName, Constants.suitSheet);
                }

            }else{
                System.out.println("没有要执行的用例");
                break;
            }
        }
    }
}
