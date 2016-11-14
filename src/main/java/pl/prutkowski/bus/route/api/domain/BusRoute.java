package pl.prutkowski.bus.route.api.domain;

import java.util.List;

public class BusRoute {

    int busId;
    List<Integer> stationIds;

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public List<Integer> getStationIds() {
        return stationIds;
    }

    public void setStationIds(List<Integer> stationIds) {
        this.stationIds = stationIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusRoute busRoute = (BusRoute) o;

        if (busId != busRoute.busId) return false;
        return stationIds != null ? stationIds.equals(busRoute.stationIds) : busRoute.stationIds == null;
    }

    @Override
    public int hashCode() {
        int result = busId;
        result = 31 * result + (stationIds != null ? stationIds.hashCode() : 0);
        return result;
    }
}
