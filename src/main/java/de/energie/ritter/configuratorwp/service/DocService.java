package de.energie.ritter.configuratorwp.service;

import de.energie.ritter.configuratorwp.model.FormData;

import java.io.IOException;
import java.net.URISyntaxException;

public interface DocService {
    String generateOffer(FormData formData) throws URISyntaxException, IOException;
}
