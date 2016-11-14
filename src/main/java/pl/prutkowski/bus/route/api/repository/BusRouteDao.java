package pl.prutkowski.bus.route.api.repository;

import pl.prutkowski.bus.route.api.domain.BusRoute;

import java.util.List;

public interface BusRouteDao {

    List<BusRoute> getBusRoutes();
}
