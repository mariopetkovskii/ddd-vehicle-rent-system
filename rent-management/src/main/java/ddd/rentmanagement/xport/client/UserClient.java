package ddd.rentmanagement.xport.client;

import ddd.rentmanagement.domain.dto.UserIdDto;
import ddd.rentmanagement.domain.valueobjects.Vehicle;
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

//    public UserIdDto getUserWithGivenId(String uuid){
//        Map<String, String> map = new HashMap<>();
//        map.put("id", uuid);
//        return restTemplate.postForObject(uri().path("/rest/vehicle/getVehicle").build().toUri(), map, Vehicle.class);
//
//    }
}
