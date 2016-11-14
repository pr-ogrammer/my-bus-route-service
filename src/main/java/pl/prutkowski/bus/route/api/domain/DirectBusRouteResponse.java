package pl.prutkowski.bus.route.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class DirectBusRouteResponse implements Serializable {

    private static final long serialVersionUID = -4686404143746420703L;

    private final int depStationId;
    private final int arrStationId;
    private final boolean directBusRoute;

    public DirectBusRouteResponse(int depStationId, int arrStationId, boolean directBusRoute) {
        this.depStationId = depStationId;
        this.arrStationId = arrStationId;
        this.directBusRoute = directBusRoute;
    }

    @JsonProperty("dep_sid")
    public int getDepStationId() {
        return depStationId;
    }

    @JsonProperty("arr_sid")
    public int getArrStationId() {
        return arrStationId;
    }

    @JsonProperty("direct_bus_route")
    public boolean isDirectBusRoute() {
        return directBusRoute;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectBusRouteResponse that = (DirectBusRouteResponse) o;

        if (depStationId != that.depStationId) return false;
        if (arrStationId != that.arrStationId) return false;
        return directBusRoute == that.directBusRoute;

    }

    @Override
    public int hashCode() {
        int result = depStationId;
        result = 31 * result + arrStationId;
        result = 31 * result + (directBusRoute ? 1 : 0);
        return result;
    }
}
