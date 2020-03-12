package br.com.calindra.geolocation.geolocation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Geometry {
    private Location location;
    private String location_type;
    private ViewPort viewport;
}
