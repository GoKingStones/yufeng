package com.yufeng.util;


import java.io.*;

/**
 * Created by kingstones on 16/8/1.
 */
public class ReadCSV {

    public static void main(String[] args) throws IOException {

        tuition(args);
    }




    public static void college(String[] args) throws IOException {

        FileInputStream inputStream=new FileInputStream(new File("/Users/kingstones/Desktop/学校表.csv"));
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line="";

        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/kingstones/Desktop/a.txt"))));
        while((line=bufferedReader.readLine())!=null) {
            String[] items=line.split(",");
            String result="insert into college_table(college_code,college_name,city_code,college_classification)  values('"+
                    items[0]+"','"+items[1]+"','"+items[3]+"','"+items[2]+"');";
            bufferedWriter.write(result);
            bufferedWriter.newLine();
            //System.out.println(result);

        }

    }



    public static void tuition(String[] args) throws IOException {

        FileInputStream inputStream=new FileInputStream(new File("/Users/kingstones/Desktop/fee.txt"));
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line="";
        while((line=bufferedReader.readLine())!=null) {
            String[] items=line.split(",");
            String result="insert into college_tuition_table(college_province,college_tuition)  values('"+
                    items[0]+"','"+items[1]+"');";

            System.out.println(result);

        }

    }



}
