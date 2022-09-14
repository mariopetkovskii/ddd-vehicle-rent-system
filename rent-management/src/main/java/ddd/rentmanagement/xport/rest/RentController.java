package ddd.rentmanagement.xport.rest;

import ddd.rentmanagement.domain.dto.UserIdDto;
import ddd.rentmanagement.domain.dto.VehicleIdDto;
import ddd.rentmanagement.domain.dto.VehicleUserIdsDto;
import ddd.rentmanagement.domain.valueobjects.User;
import ddd.rentmanagement.domain.valueobjects.Vehicle;
import ddd.rentmanagement.service.RentService;
import ddd.rentmanagement.xport.client.UserClient;
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
@CrossOrigin("http://localhost:3000/")
public class RentController {
    private final VehicleClient vehicleClient;
    private final RentService rentService;

    private final UserClient userClient;

    @GetMapping
    private List<Vehicle> listAll(){
        return this.vehicleClient.findAll();
    }

    @PostMapping(value = "/vehicle")
    private Vehicle getVehicle(@RequestBody VehicleIdDto vehicleIdDto){
        return this.vehicleClient.getVehicleWithGivenId(vehicleIdDto.getId());
    }

    @PostMapping(value = "/vehicle/rent")
    private ResponseEntity<String> rentVehicle(@RequestBody VehicleUserIdsDto vehicleUserIdsDto){
        return this.rentService.rentVehicle(vehicleUserIdsDto)
                .map(v -> ResponseEntity.ok().body("Successfully"))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping(value = "/vehicle/getUserVehicles")
    private List<Vehicle> rentVehicle(@RequestBody UserIdDto userIdDto){
        return this.rentService.findAllByUser(userIdDto);
    }
}
