//package com.das.consultation.util;
//
//import jxl.Workbook;
//import jxl.write.WritableImage;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * @Author: LJS
// * @Date: 2023/3/19 15:42
// */
//public class ExcelToImageUtil2 {
//
//    public static void main(String[] args) {
//        WritableWorkbook workbook = null;
//        try {
//            workbook = Workbook.createWorkbook(new File("C:\\Users\\LJS\\Desktop\\oppm项目管理模板-以衡水为例.xlsx"));
//            WritableSheet sheet = workbook.createSheet("picture", 0);
//            WritableImage image = new WritableImage(0, 0, 2, 5, new File("C:\\Users\\LJS\\Desktop\\pic.png"));
//            sheet.addImage(image);
//            workbook.write();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                workbook.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
