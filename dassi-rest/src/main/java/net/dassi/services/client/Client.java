package net.dassi.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class Client {
    protected String baseUrl = "";
    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployees() {
        return restTemplate.getForObject("http://localhost:8090/api/services/employees", String.class);
    }
}
