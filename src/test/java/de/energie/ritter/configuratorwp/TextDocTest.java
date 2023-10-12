package de.energie.ritter.configuratorwp;

import de.energie.ritter.configuratorwp.model.FormData;
import de.energie.ritter.configuratorwp.service.DocService;
import de.energie.ritter.configuratorwp.service.impl.WordDocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@SpringBootTest
@EnableAutoConfiguration
@ActiveProfiles({"DocOut"})
public class TextDocTest {
    @Autowired
    DocService service;


    @Test
    public void docUpdateTest() throws IOException {
        FormData fd = new FormData(1, 1,
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test"
        );
        String s = service.generateOffer(fd);
        System.out.println(s);
    }
}
