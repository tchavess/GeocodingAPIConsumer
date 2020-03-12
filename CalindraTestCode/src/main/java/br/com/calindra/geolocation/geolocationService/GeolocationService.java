package br.com.calindra.geolocation.geolocationService;

import br.com.calindra.geolocation.geolocation.GeolocationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.HttpClientConfig;
import config.RestTemplateConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;


@Service
@ContextConfiguration(classes = { RestTemplateConfig.class, HttpClientConfig.class })
public class GeolocationService {

    private static final Logger logger = LoggerFactory.getLogger(GeolocationService.class);

    public GeolocationResponse obterGeolocation(){
        GeolocationResponse response = new GeolocationResponse();
        String json= null;
        Date dateInit = new Date();
        try {
            String url = "https://maps.googleapis.com/maps/api/geocode/" +
                    "json?address=1600+Amphitheatre+Parkway,"+
                    "+Mountain+View,+CA&key=AIzaSyADxZ2DfcGkasFIjsXIL6RgT5kJIYzqokw";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            InputStream in = httpClient.execute(request).getEntity()
                    .getContent();

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            br = new BufferedReader(new InputStreamReader(in));

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();

            }

             json = sb.toString();

            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(json,GeolocationResponse.class);

        } catch (IOException e) {
            e.printStackTrace();
        }finally
        {
            logger.info("######## GEOLOCATION SERVICE RESUME #########");
            logger.info("INIT: " + dateInit.toString());
            logger.info("Response: " + response.toString());
            logger.info("END: " + new Date());
            logger.info("######## END GEOLOCATION SERVICE RESUME #####");
        }

        return response;
    }}
