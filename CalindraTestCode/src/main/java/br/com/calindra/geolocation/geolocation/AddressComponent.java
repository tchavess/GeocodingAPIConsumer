package br.com.calindra.geolocation.geolocation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class AddressComponent {
    private String long_name;
    private String short_name;
    private Object types;
}
