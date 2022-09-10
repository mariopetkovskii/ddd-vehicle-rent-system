package ddd.rentmanagement.xport.rest;

import ddd.rentmanagement.domain.dto.VehicleIdDto;
import ddd.rentmanagement.domain.valueobjects.Vehicle;
import ddd.rentmanagement.service.RentService;
import ddd.rentmanagement.xport.client.VehicleClient;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/rent")
@AllArgsConstructor
public class RentController {
    private final VehicleClient vehicleClient;

    private final RentService rentService;

    @GetMapping
    private List<Vehicle> listAll(){
        return this.vehicleClient.findAll();
    }

    @PostMapping(value = "/vehicle")
    private Vehicle getVehicle(@RequestBody VehicleIdDto vehicleIdDto){
        return this.vehicleClient.getVehicleWithGivenId(vehicleIdDto.getId());
    }

    @PostMapping(value = "/vehicle/rent")
    private ResponseEntity<String> rentVehicle(@RequestBody VehicleIdDto vehicleIdDto){
        return this.rentService.rentVehicle(vehicleIdDto)
                .map(v -> ResponseEntity.ok().body("Successfully"))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
