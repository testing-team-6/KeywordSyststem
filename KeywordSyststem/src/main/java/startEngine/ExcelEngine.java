package startEngine;

import config.LoginKeyWords;
import utility.CommonEngine;
import utility.Contants;
import utility.ExcelUtils;
//这个类的处理逻辑是和Excel表格对应的，如果要更改Excel只需要改这个类，或者新增加一个和Excel对应的类
public class ExcelEngine {
    public static String Keywords=null;
    public static String r;
    public static boolean bResult;

    public static void StartEngine(Object actionKeyWords) throws Exception {
        if (actionKeyWords instanceof LoginKeyWords){Contants.excelName = Contants.loginExcelName;}
        else {Contants.excelName = Contants.setQuestionExcelName;}

        /*LOGINKEYWORDS ACTIONKEYWORDS=NEW LOGINKEYWORDS();*/
        ExcelUtils.setExcelFile(Contants.excelFile+Contants.excelName );
        bResult = true;
//		循环读取suitSheet里面的值，找出运行的场景
        for(int j=1;j<=ExcelUtils.getLastRowNums(Contants.suitSheet);j++){

            String Runmode=ExcelUtils.getCellDate(j, Contants.suitRunmode,Contants.suitSheet);
            String suitTestSuiteId=ExcelUtils.getCellDate(j, Contants.suitTestSuiteId,Contants.suitSheet);
            int sRowNum;

            if(Runmode.equals("YES")){
//				根据stepTestSuiteId在caseSheet中循环查找相对应的执行步骤
                for(sRowNum=1;sRowNum<=ExcelUtils.getLastRowNums(Contants.caseSheet);sRowNum++){
                    String stepTestSuiteId=ExcelUtils.getCellDate(sRowNum, Contants.stepTestSuiteId,Contants.caseSheet);
                    System.out.println(ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum,Contants.caseSheet));
                    if(stepTestSuiteId.trim().equals(suitTestSuiteId)){
                        Keywords=ExcelUtils.getCellDate(sRowNum, Contants.excelKWCloNum,Contants.caseSheet);
                        r=ExcelUtils.getCellDate(sRowNum, Contants.excelPOCloNum,Contants.caseSheet);
                        CommonEngine.Action(Keywords,actionKeyWords, r, sRowNum, bResult);
                        if(bResult == false){
                            ExcelUtils.setCellData(Contants.fail, j, Contants.suitResult,Contants.excelFile+Contants.excelName, Contants.suitSheet);

                        }
                    }
                }
                if(bResult == true){
                    ExcelUtils.setCellData(Contants.pass, j, Contants.suitResult,Contants.excelFile+Contants.excelName, Contants.suitSheet);
                }

            }else{
                System.out.println("没有要执行的用例");
                break;
            }
        }
    }
}
