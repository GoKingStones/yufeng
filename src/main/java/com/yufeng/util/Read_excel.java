package com.yufeng.util;
import java.io.File;
import jxl.*;

/**
 * Created by kingstones on 16/8/1.
 */

public class Read_excel{

    public static void main(String[] args) {
        createCollegeCity();
    }


    public static void createCollegeCity(){

        int i;
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3,cell4,cell5;
        try {
            //t.xls为要读取的excel文件名
            book= Workbook.getWorkbook(new File("/Users/kingstones/Desktop/yufeng/2016最新全国普通高校名单、共2845所.xls"));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet=book.getSheet(0);
            //获取左上角的单元格
            cell1=sheet.getCell(0,0);
            System.out.println("标题："+cell1.getContents());

            i=1;
            while(true)
            {
                //获取每一行的单元格
                cell1=sheet.getCell(0,i);//（列，行）
                cell2=sheet.getCell(1,i);
                cell3=sheet.getCell(2,i);
                cell4=sheet.getCell(3,i);
                cell5=sheet.getCell(4,i);
                if("".equals(cell1.getContents())==true)    //如果读取的数据为空
                    break;
//                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()
//                +"\t"+cell4.getContents()+"\t"+cell5.getContents());
                StringBuilder sb=new StringBuilder();
                sb.append("insert into city_college_table(collegeName,cityName,collegeType) values(");
                sb.append("'"+cell2.getContents()+"'");
                sb.append(",'"+cell4.getContents()+"'");
                sb.append(",'"+cell5.getContents()+"'");
                sb.append(");");
                System.out.println(sb.toString());

                i++;
            }
            book.close();
        }
        catch(Exception e)  { }
    }

    public static void createCollegeId(){

        int i;
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2;
        try {
            //t.xls为要读取的excel文件名
            book= Workbook.getWorkbook(new File("/Users/kingstones/Desktop/yufeng/中国大学院校编码.xls"));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet=book.getSheet(0);
            //获取左上角的单元格
            cell1=sheet.getCell(0,0);
            System.out.println("标题："+cell1.getContents());

            i=1;
            while(true)
            {
                //获取每一行的单元格
                cell1=sheet.getCell(0,i);//（列，行）
                cell2=sheet.getCell(1,i);

                if("".equals(cell1.getContents())==true)    //如果读取的数据为空
                    break;
//                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()
//                +"\t"+cell4.getContents()+"\t"+cell5.getContents());
                StringBuilder sb=new StringBuilder();
                sb.append("insert into city_college_table(id,college) values(");
                sb.append("'"+cell1.getContents()+"'");
                sb.append(",'"+cell2.getContents()+"'");
                sb.append(");");
                System.out.println(sb.toString());

                i++;
            }
            book.close();
        }
        catch(Exception e)  { }
    }


}
