package ddd.rentmanagement.xport.client;

import ddd.rentmanagement.domain.valueobjects.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public UserClient(@Value("${app.users-service.url}") String serverUrl){
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public User getUserWithGivenId(String uuid){
        Map<String, String> map = new HashMap<>();
        map.put("id", uuid);
        return restTemplate.postForObject(uri().path("/rest/user/detailsWithId").build().toUri(), map, User.class);
    }

    public User userDetails(String email){
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        return restTemplate.postForObject(uri().path("/rest/user/details").build().toUri(), map, User.class);
    }

    public void rentCar(String email, Double amount){
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("amount", amount.toString());
        restTemplate.postForObject(uri().path("/rest/user/rentCar").build().toUri(), map, User.class);
    }
}
