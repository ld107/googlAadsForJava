package com.google.ads.googleads.examples.AboutProjectForPlay;

import com.google.ads.googleads.examples.AboutProjectForPlay.excel.domain.*;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.util.MyExcelUtil;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.common.collect.Range;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022/1/8
 * @Author lifei
 */
public class MyExcelUtilTest {
    /*
    * 将数据内容写入excel文件
     */

    public void createNewExcelWriteContentTest(ArrayList<Customer> customerList,int rowNum) {
        String excelFilePath = "/customer.xlsx";
        ExcelContent excelContent = new ExcelContent();
        List<ExcelSheetContent> sheetContentList = new ArrayList<>();
        // 添加第一个sheet页的内容
        sheetContentList.add(createFirstSheet(customerList,rowNum));
        // 添加多个sheet页的内容
        excelContent.setSheetContentList(sheetContentList);
        MyExcelUtil.createNewExcelWriteContent(excelContent, excelFilePath);
    }

    /**
     * 创建第一个sheet
     * @return
     */
    private ExcelSheetContent createFirstSheet(ArrayList<Customer> customerList,int rowNum) {
        // 第一个sheet页
        ExcelSheetContent firstSheetContent = new ExcelSheetContent();
        // 设置sheet页的名称
        firstSheetContent.setSheetName("customer");
        List<TableContent> firstSheetTableList = new ArrayList<>();
        // 第一个sheet页里的第一个表格
        TableContent tableContent1 = createSheetFirstTable(customerList,rowNum);
        // 添加表格
        firstSheetTableList.add(tableContent1);
        // 往第一个sheet页中，添加多个表格
        firstSheetContent.setTableContentList(firstSheetTableList);
        return firstSheetContent;
    }


    /**
     * 创建第一个表格
     * @return
     */
    private TableContent createSheetFirstTable(ArrayList<Customer> customerList,int rowNum) {


        TableContent tableContent = new TableContent();
//        tableContent.setTitle("第一个sheet页的第一个表格");
        int colNum = 5;
        CellContent[][] table = new CellContent[rowNum+1][colNum];
        table[0] = new CellContent[]{
                new CellContent.Builder().cellValue("ID").builder(),
                new CellContent.Builder().cellValue("name").builder(),
                new CellContent.Builder().cellValue("code").builder(),
                new CellContent.Builder().cellValue("TimeZone").builder(),
                new CellContent.Builder().cellValue("TrackingUrl").builder()
        };
        for (int i = 0; i < rowNum; i++) {
            Customer customer = customerList.get(i);
            table[i+1] = new CellContent[]{
                    new CellContent.Builder().cellValue(customer.getId()).builder(),
                    new CellContent.Builder().cellValue(customer.getDescriptiveName()).builder(),
                    new CellContent.Builder().cellValue(customer.getCurrencyCode()).builder(),
                    new CellContent.Builder().cellValue(customer.getTimeZone()).myCellBGColor(new MyCellColor(51, 204, 51)).builder(),
                    new CellContent.Builder().cellValue(customer.getTrackingUrlTemplate()).builder()
            };
        }

        tableContent.setTable(table);
        // 添加标题颜色
        tableContent.setTitleBGColor(new MyCellColor(153, 255, 153));
        // 设置列宽
        tableContent.setColumnWidthsBase256(new int[]{20, 20, 20, 20, 20});
        // 设置标题居左
        tableContent.setTitleAlignment(HorizontalAlignment.LEFT);

        return tableContent;
    }
}