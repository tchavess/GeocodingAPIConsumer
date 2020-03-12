package br.com.calindra.geolocation.geolocationResource;

import br.com.calindra.geolocation.geolocation.GeolocationResponse;
import br.com.calindra.geolocation.geolocationService.GeolocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/geocoding-api")
public class GeolocationResource {

    private static final Logger logger = LoggerFactory.getLogger(GeolocationResource.class);

    @Autowired
    GeolocationService geolocationService;


    @GetMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeolocationResponse> resourceSearch(){
        GeolocationResponse response = new GeolocationResponse();
        Date dateInit = new Date();
        try{


             response =  geolocationService.obterGeolocation();


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
