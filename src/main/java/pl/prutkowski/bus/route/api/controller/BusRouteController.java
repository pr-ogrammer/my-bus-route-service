package pl.prutkowski.bus.route.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import pl.prutkowski.bus.route.api.domain.DirectBusRouteResponse;
import pl.prutkowski.bus.route.api.service.BusRouteService;

@RestController
@RequestMapping("/api")
public class BusRouteController {

    private final BusRouteService busRouteService;

    @Autowired
    public BusRouteController(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @GetMapping(value = "/direct", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WebAsyncTask<DirectBusRouteResponse> isDirectBusRoute(
            @RequestParam("dep_sid") int depStationId,
            @RequestParam("arr_sid") int arrStationId) {

        return new WebAsyncTask<>(15000L, "busRouteExecutor", () -> busRouteService.getDirectBusRouteResponse(depStationId, arrStationId));
    }
}
