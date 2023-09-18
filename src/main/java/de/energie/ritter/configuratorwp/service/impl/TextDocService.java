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
                .replace("{{heatload}}", String.valueOf(formData.getHeatLoad()))
                .replace("{{distancetoboard}}", String.valueOf(formData.getDistancetoboard()))
                .replace("{{eheater}}", formData.getEheater())
                .replace("{{calcpos}}", formData.getCalcpos())
                .replace("{{checkplace}}", formData.getCheckplace())
                .replace("{{newplace}}", formData.getNewplace())
                .replace("{{distance}}", formData.getDistance())
                .replace("{{newdistance}}", formData.getNewdistance())
                .replace("{{VBoption}}", formData.getVBoption())
                .replace("{{acoustic}}", formData.getAcoustic())
                .replace("{{radtemp}}", formData.getRadtemp())
                .replace("{{reconstradtemp}}", formData.getReconstradtemp())
                .replace("{{surfencradtemp}}", formData.getSurfencradtemp())
                .replace("{{woodcauldron}}", formData.getWoodcauldron())
                .replace("{{heatload8}}", formData.getHeatload8())
                .replace("{{heatload910}}", formData.getHeatload910())
                .replace("{{heatload11}}", formData.getHeatload11())
                .replace("{{heatload12ja}}", formData.getHeatload12ja())
                .replace("{{heatload12ne}}", formData.getHeatload12ne())
                .replace("{{heatload13}}", formData.getHeatload13())
                .replace("{{heatload14ja}}", formData.getHeatload14ja())
                .replace("{{heatload14ne}}", formData.getHeatload14ne())
                .replace("{{heatload15}}", formData.getHeatload15())
                .replace("{{heatload16}}", formData.getHeatload16())
                .replace("{{heatload1725}}", formData.getHeatload1725())
                .replace("{{heatload2650}}", formData.getHeatload2650());

        Files.writeString(Paths.get(resultPath), resultContent);
        return newFileName;
    }
}
