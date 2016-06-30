package com.cristik.pdf;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

/**
 * @Package: com.cristik.pdf.PdfTest
 * @ClassName: PdfTest.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/28 17:32
 * @Version: v1.0
 */
public class PdfTest {

    public static void main(String[] args) {
        try {
            String sourceDir = "D:\\Project\\travelalone\\server\\designpatternsen.pdf";
            String destinationDir = "D:\\pic\\";
            File oldFile = new File(sourceDir);
            if (oldFile.exists()) {
                PDDocument document = PDDocument.load(sourceDir);

                List<PDPage> list = document.getDocumentCatalog().getAllPages();

                String fileName = oldFile.getName().replace(".pdf", "_cover");
                int totalImages = 1;
                for (PDPage page : list) {
                    PDResources pdResources = page.getResources();

                    Map pageImages = pdResources.getImages();
                    if (pageImages != null) {

                        Iterator imageIter = pageImages.keySet().iterator();
                        while (imageIter.hasNext()) {
                            String key = (String) imageIter.next();
                            PDXObjectImage pdxObjectImage = (PDXObjectImage) pageImages.get(key);
                            pdxObjectImage.write2file(destinationDir + fileName + "_" + totalImages);
                            totalImages++;
                        }
                    }
                }
            } else {
                System.err.println("File not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

