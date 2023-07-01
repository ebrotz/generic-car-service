package mazdaservice;

import org.openapitools.api.CarsApi;
import org.openapitools.model.MazdaCar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MazdaCarsApi implements CarsApi {
    @Override
    public ResponseEntity<Void> postCar(MazdaCar mazdaCar) {
        System.out.println("Received a mazda car of model " + mazdaCar.getMazdaModel());
        return ResponseEntity.ok(null);
    }
}
