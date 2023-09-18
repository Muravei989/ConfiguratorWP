//package de.energie.ritter.configuratorwp.service.impl;
//
//import de.energie.ritter.configuratorwp.model.FormData;
//import de.energie.ritter.configuratorwp.service.DocService;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.UUID;
//
//@Service
//@Profile("DocOut")
//public class WordDocService implements DocService {
//    @Value("${templatePath}")
//    private String templatePath;
//
//    @Override
//    public String generateOffer(FormData formData) {
//        String filePath = getClass().getClassLoader().getResource(templatePath).getPath();
//        String newFilePath = filePath.replace("TestTemplate", "Result" + UUID.randomUUID());
//        try (
//                InputStream in = new FileInputStream(filePath);
//                FileOutputStream out = new FileOutputStream(newFilePath);
//                XWPFDocument doc = new XWPFDocument(in);
//        ) {
//            doc
//                    .getParagraphs()
//                    .forEach(p -> {
//                        p
//                                .getRuns()
//                                .forEach(r -> {
//                                    String text = r.getText(0);
//                                    int hl = formData.heatLoad();
//                                    if (text.equals("Heat Load {{Value1}}")) {
//                                        String updatedRunText = text.replace("{{Value1}}", String.valueOf(hl));
//                                        r.setText(updatedRunText, 0);
//                                    } else if (text.equals("Price {{Value2}}")) {
//                                        String updatedRunText = text.replace("{{Value2}}", hl > 10 ? "Many" : "Not Many");
//                                        r.setText(updatedRunText, 0);
//                                    }
//                                });
//                    });
//
//            doc.write(out);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return newFilePath;
//    }
//}
