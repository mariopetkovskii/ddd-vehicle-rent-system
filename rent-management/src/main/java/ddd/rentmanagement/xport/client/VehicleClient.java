package ddd.rentmanagement.xport.client;

import ddd.rentmanagement.domain.dto.VehicleIdDto;
import ddd.rentmanagement.domain.valueobjects.Vehicle;
import ddd.rentmanagement.domain.valueobjects.VehicleId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class VehicleClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public VehicleClient(@Value("${app.vehicle-list.url}") String serverUrl){
        this.serverUrl = "http://vehicle-list-service";
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Vehicle> findAll(){
        try{
            return restTemplate.exchange(uri().path("/rest/vehicle/listAll").
                    build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Vehicle>>() {
            }).getBody();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public Vehicle getVehicleWithGivenId(String uuid){
        Map<String, String> map = new HashMap<>();
        map.put("id", uuid);
        Vehicle vehicle = restTemplate.postForObject(uri().path("/rest/vehicle/getVehicle").build().toUri(), map, Vehicle.class);
        return vehicle;

    }

}
