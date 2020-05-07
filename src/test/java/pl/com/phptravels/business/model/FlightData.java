package pl.com.phptravels.business.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class FlightData {

    private String airportFrom;
    private String airportTo;
    private String departDate;
    private int adultsNumber;
    private int childrenNumber;
    private int infantsNumber;
}
