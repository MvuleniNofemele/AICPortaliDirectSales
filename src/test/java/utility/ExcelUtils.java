package utility;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.*;
import testCases.Driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
    static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook = null;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static int curr_row=0;
    public static int data_row=0;
    public static int itr_size=1;

    public static String iteration_Flag = "Yes";
    public String resultExcelPath = "C:\\result.xlsx";

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
    public void setExcelFile(String Path,String SheetName) throws Exception
    {

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        }
        catch (Exception e)
        {
            throw (e);
        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public String getCellData(int RowNum, int ColNum) {

        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        }
        catch (Exception e)
        {
            return"";
        }
    }

    //This method is to write in the Excel cell, Row num and Col num are the parameters
	public static void setCellData(String Result,  int RowNum, int ColNum) {
//	    try
//        {
//            Row  = ExcelWSheet.getRow(RowNum);
//            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
//            if (Cell == null)
//            {
//                Cell = Row.createCell(ColNum);
//                Cell.setCellValue(Result);
//            }
//            else
//            {
//                Cell.setCellValue(Result);
//            }
//
//            // Constant variables Test Data path and Test Data file name
//            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
//            ExcelWBook.write(fileOut);
//            fileOut.flush();
//            fileOut.close();
//        }
//        catch(Exception e)
//        {
//            throw (e);
//        }
	}

    public static void closeExcelFile(String Path)throws Exception {
        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelFile.close();
    }


    public void setCellDataString(String Result,  int RowNum, int ColNum) throws Exception
    {

        try{
            Row  = ExcelWSheet.getRow(RowNum);
            if(Row == null){
                ExcelWSheet.createRow(RowNum);
                Row  = ExcelWSheet.getRow(RowNum);
            }
            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
            if (Cell == null)
            {
                XSSFCellStyle my_style = ExcelWBook.createCellStyle();
                cellBorderStyle(my_style,ColNum);
                Cell.setCellValue(Result);
            }

            else
            {
                Cell.setCellValue(Result);
            }


            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(resultExcelPath);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch(Exception e)
        {
            throw (e);
        }
    }

    public void setCellDataInteger(int Result,  int RowNum, int ColNum) throws Exception
    {

        try{
            Row  = ExcelWSheet.getRow(RowNum);
            if(Row == null){
                ExcelWSheet.createRow(RowNum);
                Row  = ExcelWSheet.getRow(RowNum);
            }
            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
            if (Cell == null)
            {
                XSSFCellStyle my_style = ExcelWBook.createCellStyle();
                cellBorderStyle(my_style,ColNum);
                Cell.setCellValue(Result);
            }
            else
            {
                Cell.setCellValue(Result);
            }

            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(resultExcelPath);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch(Exception e)
        {
            throw (e);
        }
    }

    public void cellBorderStyle(XSSFCellStyle my_style,int ColNum) {

        my_style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        my_style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        my_style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        my_style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        my_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        Cell = Row.createCell(ColNum);
        Cell.setCellStyle(my_style);
    }

    public void setCellDataHyperLink(int RowNum , int ColNum , int stepNo , String linkPath) throws Exception
    {
        XSSFCreationHelper helper= ExcelUtils.ExcelWBook.getCreationHelper();
        XSSFHyperlink url_link=helper.createHyperlink(Hyperlink.LINK_FILE);
        String path = "";//obHTML.dirPath.replace("\\", "/");
        String pth = linkPath.replace(".","");
        String screenshotPath = "file:///"+path+pth+"/Step-" + stepNo + ".png";
        if(screenshotPath.contains(" ")){
            screenshotPath = screenshotPath.replaceAll(" ", "%20");
        }
        url_link.setAddress(screenshotPath);
        url_link.setTooltip("Click Here To open the screenshot");
        try{
            Row  = ExcelWSheet.getRow(RowNum);
            if(Row == null){
                ExcelWSheet.createRow(RowNum);
                Row  = ExcelWSheet.getRow(RowNum);
            }
            Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
            if (Cell == null)
            {
                XSSFCellStyle my_style = ExcelWBook.createCellStyle();
                cellBorderStyle(my_style,ColNum);
                Cell.setCellValue("Click Here");
                Cell.setHyperlink(url_link);
            }
            else
            {
                Cell.setCellValue("Click Here");
                Cell.setHyperlink(url_link);
            }

            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(resultExcelPath);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch(Exception e)
        {
            throw (e);
        }
    }

    public Map<String, String> getCurrentTestData(String tc_id) {
        try {

            if(data_row==0)
            {

                //setExcelFile(Constant.Path_TestData + Constant.File_TestData,"TestData");
                setExcelFile(Constant.Path_TestData + Driver.file_TestData,"TestData");

                int j=1;
                int i=0;

                while(j==1)
                {

                    if(getCellData(i,0).equals(tc_id))
                    {
                        //System.out.println(getCellData(i,0));
                        curr_row=i;
                        int s_size=0;
                        int k=1;
                        int z=i+1; //i will pe field name row, z is field data row

                        while(k==1)
                        {

                            int x_size=getCellData(z,0).length() ;
                            if(x_size != 0)
                            {
                                itr_size=s_size;
                                j=0;
                                k=0;
                                //System.out.println(itr_size);

                            }
                            s_size++;
                            z++;
                        }
                    }
                    i++;
                }
                data_row=curr_row+1;
            }

            Map<String, String> dictionary = new HashMap<String, String> ();
            //setExcelFile(Constant.Path_TestData + Constant.File_TestData,"TestData");
            setExcelFile(Constant.Path_TestData + Driver.file_TestData,"TestData");

            int k=1;
            int i=1; //chenged ot fetch TC name
            while(k==1)
            {
                if(i==2){
                    int iter_flag = getCellData(curr_row,i).length();
                    String interationFlagText = getCellData(curr_row,i) ;
                    if(iter_flag != 0 && interationFlagText.equalsIgnoreCase("iterationFlag")){
                        iteration_Flag = getCellData(data_row,i);
                    }else{
                        iteration_Flag = "Yes";
                    }
                    String key=getCellData(curr_row,i);
                    String value="" + getCellData(data_row, i);
                    dictionary.put(key, value);
                    i++;
                }else{
                    int x_size=getCellData(curr_row,i).length();
                    if(x_size!=0)
                    {
                        String key=getCellData(curr_row,i);
                        String value="" + getCellData(data_row, i);
                        dictionary.put(key, value);
                        i++;
                    }
                    else
                    {
                        k=0;
                    }

                }

            }
            return dictionary;
        } catch (Exception e)
        {
            System.out.println("error while reading config - " + e );
            return null;
        }

    }



}
