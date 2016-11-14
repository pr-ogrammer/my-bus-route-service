package pl.prutkowski.bus.route.api.domain;

import java.util.List;

public class BusRouteBuilder {

    private int busId;
    private List<Integer> stationIds;

    private BusRouteBuilder() {
    }

    public static BusRouteBuilder aBusRoute() {
        return new BusRouteBuilder();
    }

    public BusRouteBuilder withBusId(int busId) {
        this.busId = busId;
        return this;
    }

    public BusRouteBuilder withStationIds(List<Integer> stationIds) {
        this.stationIds = stationIds;
        return this;
    }

    public BusRoute build() {
        BusRoute busRoute = new BusRoute();
        busRoute.setBusId(busId);
        busRoute.setStationIds(stationIds);
        return busRoute;
    }
}
