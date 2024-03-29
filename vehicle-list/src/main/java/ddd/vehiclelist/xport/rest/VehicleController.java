package ddd.vehiclelist.xport.rest;

import ddd.vehiclelist.domain.dto.VehicleIdDto;
import ddd.vehiclelist.domain.models.Vehicle;
import ddd.vehiclelist.service.VehicleService;
import ddd.vehiclelist.service.form.VehicleForm;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/vehicle")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/listAll")
    public List<Vehicle> listAll(){
        return this.vehicleService.findAll();
    }

    @GetMapping("/pagination/{page}/{size}")
    public Page<Vehicle> listAllWithPagination(@PathVariable Integer page,
                                               @PathVariable Integer size){
        return this.vehicleService.findAllWithPagination(PageRequest.of(page, size));
    }
    @PostMapping("/create")
    public ResponseEntity<Vehicle> create(@RequestBody VehicleForm vehicleForm){
        return this.vehicleService.createVehicle(vehicleForm)
                .map(vehicle -> ResponseEntity.ok().body(vehicle))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping(value = "/getVehicle")
    public ResponseEntity<Vehicle> getVehicle(@RequestBody VehicleIdDto vehicleIdDto){
        return this.vehicleService.getVehicle(vehicleIdDto)
                .map(vehicle -> ResponseEntity.ok().body(vehicle))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

//    @PostMapping(value = "/rent")
//    public ResponseEntity<Vehicle> rentVehicle(@RequestBody VehicleIdDto vehicleIdDto){
//        return this.vehicleService.rentVehicle(vehicleIdDto)
//                .map(vehicle -> ResponseEntity.ok().body(vehicle))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
//
//    @PostMapping(value = "/unRent")
//    public ResponseEntity<Vehicle> unRentVehicle(@RequestBody VehicleIdDto vehicleIdDto){
//        return this.vehicleService.unRentVehicle(vehicleIdDto)
//                .map(vehicle -> ResponseEntity.ok().body(vehicle))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
}
