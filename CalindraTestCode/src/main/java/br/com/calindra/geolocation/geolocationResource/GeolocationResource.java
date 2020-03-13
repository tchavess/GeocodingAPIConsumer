package br.com.calindra.geolocation.geolocationResource;

import br.com.calindra.geolocation.geolocation.GeolocationBean;
import br.com.calindra.geolocation.geolocation.GeolocationResponse;
import br.com.calindra.geolocation.geolocationService.GeolocationService;
import config.GeolocationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/geocoding-api")
public class GeolocationResource {

    private static final Logger logger = LoggerFactory.getLogger(GeolocationResource.class);

    @Autowired
    GeolocationService geolocationService;


    @GetMapping(value = "/location", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeolocationResponse> resourceSearch(@RequestParam(value="address", required = false) String address){
        GeolocationResponse response = new GeolocationResponse();
        Date dateInit = new Date();
        GeolocationConfig geolocationConfig = new GeolocationConfig();
        try{


             response =  geolocationService.obterGeolocation(address, geolocationConfig.getKey_code());


        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            logger.info("####### GEOLOCATION RESOURCES RESUME ##########");
            logger.info("INIT: " + dateInit.toString());
            logger.info("Response: " + response.toString());
            logger.info("END: " + new Date());
            logger.info("####### END GEOLOCATION RESOURCES RESUME ##########");
        }

        return ResponseEntity.ok(response) ;
    }

}
