package br.com.calindra.geolocation.geolocation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GeolocationBean {

    private String street;
    private String number;
    private String location;
    private String state;
    private String uf;
    private String zipCode;
}
