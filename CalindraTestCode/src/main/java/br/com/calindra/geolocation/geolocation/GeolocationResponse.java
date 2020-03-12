package br.com.calindra.geolocation.geolocation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GeolocationResponse {
    private List<Results> results;
    private String status;
}
