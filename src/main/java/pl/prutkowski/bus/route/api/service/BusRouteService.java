package pl.prutkowski.bus.route.api.service;

import pl.prutkowski.bus.route.api.domain.DirectBusRouteResponse;

public interface BusRouteService {

    DirectBusRouteResponse getDirectBusRouteResponse(int depStationId, int arrStationId);
}
