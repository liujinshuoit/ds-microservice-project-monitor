//package com.das.consultation.util;
//
//import com.spire.pdf.PdfDocument;
//import com.spire.xls.Workbook;
//import com.spire.xls.Worksheet;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import static javax.print.attribute.ResolutionSyntax.DPI;
//
///**
// * @Author: LJS
// * @Date: 2023/3/19 15:42
// */
//public class ExcelToImageUtil3 {
//
//    public static void main(String[] args) throws Exception{
//        //文件所在位置，我写的多文件，单文件去掉循环即可
//        String[] str={"E:\\WORK\\DS\\SUPPORT\\PMO\\项目监管平台\\oppm项目管理模板-以衡水为例-TEST.xlsx"};
//        for (String s : str) {
//            Workbook wb = new Workbook();
//            //位置所在位置
//            wb.loadFromFile(s);
//            Worksheet sheet = wb.getWorksheets().get(0);
//            Random random=new Random();
//            //随机起一个名称
//            sheet.saveToPdf("C:\\Users\\LJS\\Desktop\\HSXM.pdf");
//            List<byte[]> imageList = pdf2image("C:\\Users\\LJS\\Desktop\\HSXM.pdf");
//            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\LJS\\Desktop\\HSXM-1.jpg");
//            fileOutput.write(imageList.get(0), 0, 4);
//
//
//
////            PdfDocument doc = new PdfDocument();
////            doc.loadFromFile("C:\\Users\\LJS\\Desktop\\HSXM.pdf");
//            //保存PDF的每一页到图片
////            BufferedImage image;
////            for (int i = 0; i < doc.getPages().getCount(); i++) {
////                image = doc.saveAsImage(i);
////                File file = new File("C:\\Users\\LJS\\Desktop\\HSXM-2.png");
////                ImageIO.write(image, "PNG", file);
////            }
////
////            doc.close();
//        }
//    }
//
//    /**
//     * Pdf转Png
//     * @param currentProvePdfPath
//     * @return
//     * @throws IOException
//     */
//    public static List<byte[]> pdf2image(String currentProvePdfPath) throws IOException {
//        FileInputStream in = new FileInputStream(new File(currentProvePdfPath));
//        // 输出word内容文件流，提供下载
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        int len;
//        byte[] b = new byte[1024];
//        while((len = in.read(b)) != -1) {
//            byteArrayOutputStream.write(b, 0, len);
//            byteArrayOutputStream.flush();
//        }
//        in.close();
//        byte[] fileContent = byteArrayOutputStream.toByteArray();
//        List<byte[]> result = new ArrayList<>();
//        try (PDDocument document = PDDocument.load(fileContent)) {
//            PDFRenderer renderer = new PDFRenderer(document);
//            for (int i = 0; i < document.getNumberOfPages(); ++i) {
//                BufferedImage bufferedImage = renderer.renderImageWithDPI(i, DPI);
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//                ImageIO.write(bufferedImage, "png", out);
//                result.add(out.toByteArray());
//            }
//        }
//        return result;
//    }
//
//
//}
