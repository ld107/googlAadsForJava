package com.google.ads.googleads.examples.AboutProjectForPlay.excel;

import com.google.ads.googleads.examples.AboutProjectForPlay.excel.domain.CellContent;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.domain.ExcelContent;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.domain.ExcelSheetContent;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.domain.MyCellColor;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.domain.TableContent;
import com.google.ads.googleads.examples.AboutProjectForPlay.excel.util.MyExcelUtil;
import com.google.ads.googleads.v12.resources.Campaign;
import com.google.ads.googleads.v12.resources.Customer;
import com.google.ads.googleads.v12.resources.CustomerClient;

import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Date 2022/1/8
 * @Author lifei
 */
public class MyExcelAds {
    /*
    * 将数据内容写入excel文件
     */

    public void createNewExcelWriteContentTest(HashMap<CustomerClient, Campaign> hashMap ) {
        String excelFilePath = "/Ads.xlsx";
        ExcelContent excelContent = new ExcelContent();
        List<ExcelSheetContent> sheetContentList = new ArrayList<>();
        // 添加第一个sheet页的内容
        sheetContentList.add(createFirstSheet(hashMap));
        // 添加多个sheet页的内容
        excelContent.setSheetContentList(sheetContentList);
        MyExcelUtil.createNewExcelWriteContent(excelContent, excelFilePath);
    }

    /**
     * 创建第一个sheet
     * @return
     */
    private ExcelSheetContent createFirstSheet(HashMap<CustomerClient, Campaign> hashMap ) {
        // 第一个sheet页
        ExcelSheetContent firstSheetContent = new ExcelSheetContent();
        // 设置sheet页的名称
        firstSheetContent.setSheetName("广告列表");
        List<TableContent> firstSheetTableList = new ArrayList<>();
        // 第一个sheet页里的第一个表格
        TableContent tableContent1 = createSheetFirstTable(hashMap);
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
    private TableContent createSheetFirstTable(HashMap<CustomerClient, Campaign> hashMap ) {


        TableContent tableContent = new TableContent();
//        tableContent.setTitle("第一个sheet页的第一个表格");
        int colNum = 5;
        CellContent[][] table = new CellContent[hashMap.size()+1][colNum];
        table[0] = new CellContent[]{
                new CellContent.Builder().cellValue("客户ID").builder(),
                new CellContent.Builder().cellValue("客户name").builder(),
                new CellContent.Builder().cellValue("广告ID").builder(),
                new CellContent.Builder().cellValue("广告name").builder()
        };
        ArrayList<CellContent[]> list = new ArrayList();
         Set<Map.Entry<CustomerClient, Campaign>> entries = hashMap.entrySet();
        for (Map.Entry<CustomerClient, Campaign> entry : entries){
            CustomerClient customerClient = entry.getKey();
            Campaign campaign = entry.getValue();
            CellContent[] cellContents = {
                    new CellContent.Builder().cellValue(customerClient.getId()).builder(),
                    new CellContent.Builder().cellValue(customerClient.getDescriptiveName()).builder(),
                    new CellContent.Builder().cellValue(campaign.getId()).builder(),
                    new CellContent.Builder().cellValue(campaign.getName()).myCellBGColor(new MyCellColor(51, 204, 51)).builder()

            };
            list.add(cellContents);
        }
        for (int i = 0; i < hashMap.size(); i++) {
            table[i+1]  = list.get(i);
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