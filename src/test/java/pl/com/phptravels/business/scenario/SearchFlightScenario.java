package pl.com.phptravels.business.scenario;

import lombok.AllArgsConstructor;
import pl.com.phptravels.business.model.FlightData;
import pl.com.phptravels.business.page.ResultsPage;
import pl.com.phptravels.business.page.SearchFlightPage;
import pl.com.phptravels.core.base.BaseScenario;

@AllArgsConstructor
public class SearchFlightScenario implements BaseScenario<SearchFlightPage, ResultsPage> {

    private FlightData flightData;

    @Override
    public ResultsPage run(SearchFlightPage searchPage) {
        return searchPage
                .clearAndSetAirportFrom(flightData.getAirportFrom())
                .clearAndSetAirportFrom(flightData.getAirportTo())
              //  .setDepartDate(flightData.getDepartDate())
                .setAdultsNumber(flightData.getAdultsNumber())
                .setChildrenNumber(flightData.getChildrenNumber())
                .setInfantNumber(flightData.getInfantsNumber())
                .searchFlights();
    }
}
