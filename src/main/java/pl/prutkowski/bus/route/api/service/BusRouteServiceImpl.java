package pl.prutkowski.bus.route.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prutkowski.bus.route.api.domain.BusRoute;
import pl.prutkowski.bus.route.api.domain.DirectBusRouteResponse;
import pl.prutkowski.bus.route.api.repository.BusRouteDao;

import java.util.Optional;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusRouteServiceImpl.class);

    private final BusRouteDao busRouteDao;

    @Autowired
    public BusRouteServiceImpl(BusRouteDao busRouteDao) {
        this.busRouteDao = busRouteDao;
    }

    @Override
    public DirectBusRouteResponse getDirectBusRouteResponse(int depStationId, int arrStationId) {
//        LOGGER.info("Direct route: {} -> {}", depStationId, arrStationId);
        Optional<BusRoute> busRouteOptional = busRouteDao.getBusRoutes()
                .parallelStream()
                .filter(busRoute -> {
                    int depStationPos = busRoute.getStationIds().indexOf(depStationId);
                    int arrStationPos = busRoute.getStationIds().indexOf(arrStationId);
                    return depStationPos < arrStationPos && depStationPos != -1 && arrStationPos != -1;
                })
                .findFirst();

        return new DirectBusRouteResponse(depStationId, arrStationId, busRouteOptional.isPresent() ? true : false);
    }
}
