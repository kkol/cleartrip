package com.travels.aut.autSubname.ux.framework.dataprovider;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter @Setter
public class FlightSet {
    private String airportFrom, airportTo, adults, childrens, infants, error;
    public FlightSet(JSONObject object){
        setAirportFrom(object.get("airportFrom").toString());
        setAirportTo(object.get("airportTo").toString());
        setAdults(object.get("adults").toString());
        setChildrens(object.get("children").toString());
        setInfants(object.get("infants").toString());
        setError(object.get("error") == null ? "N/A" : object.get("error").toString());
    }


}
