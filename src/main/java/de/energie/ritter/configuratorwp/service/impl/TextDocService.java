package de.energie.ritter.configuratorwp.service.impl;

import de.energie.ritter.configuratorwp.model.FormData;
import de.energie.ritter.configuratorwp.service.DocService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Profile("TextOut")
public class TextDocService implements DocService {
    @Value("${templatePath}")
    private String templatePath;

    @Override
    public String generateOffer(FormData formData) throws IOException {
        String newFileName =  "Result" + UUID.randomUUID() + ".txt";
        String path = new ClassPathResource(templatePath).getFile().getPath();
        String sourcePath = path + "/template.txt";
        String resultPath = path + "/" + newFileName;

        String templateText = Files.readAllLines(Paths.get(sourcePath)).stream().collect(Collectors.joining(System.lineSeparator()));
        String resultContent = templateText
                .replace("{{t1}}", String.valueOf(formData.getHeatLoad()))
                .replace("{{t2}}", String.valueOf(formData.getDistancetoboard()));

        Files.writeString(Paths.get(resultPath), resultContent);
        return newFileName;
    }
}
