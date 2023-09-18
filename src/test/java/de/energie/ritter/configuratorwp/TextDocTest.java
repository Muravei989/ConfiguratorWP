package de.energie.ritter.configuratorwp;

import de.energie.ritter.configuratorwp.model.FormData;
import de.energie.ritter.configuratorwp.service.impl.TextDocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
public class TextDocTest {
    @Autowired
    TextDocService service;

    @Test
    public void test() throws URISyntaxException, IOException {
        service.generateOffer(new FormData());
    }
}
