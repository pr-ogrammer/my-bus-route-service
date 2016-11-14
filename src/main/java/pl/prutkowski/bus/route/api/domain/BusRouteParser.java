package pl.prutkowski.bus.route.api.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BusRouteParser {

    public BusRoute fromLine(String busRouteLine) {
        return BusRouteBuilder.aBusRoute()
                .withBusId(getBusId(busRouteLine))
                .withStationIds(getBusStationIds(busRouteLine))
                .build();
    }

    private int getBusId(String busRouteLine) {
        return Integer.parseInt(busRouteLine.substring(0, 1));
    }

    private List<Integer> getBusStationIds(String busRouteLine) {
        return Arrays.stream(busRouteLine.substring(2).split("\\s"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
