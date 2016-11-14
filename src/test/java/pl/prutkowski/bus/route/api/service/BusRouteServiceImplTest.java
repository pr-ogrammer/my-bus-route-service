package pl.prutkowski.bus.route.api.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.prutkowski.bus.route.api.domain.BusRoute;
import pl.prutkowski.bus.route.api.domain.BusRouteBuilder;
import pl.prutkowski.bus.route.api.repository.BusRouteDao;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class BusRouteServiceImplTest {

    @Mock
    private BusRouteDao busRouteDao;

    @InjectMocks
    @Resource
    private BusRouteServiceImpl busRouteService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(busRouteDao.getBusRoutes()).thenReturn(getBusRoutes());
    }

    @Test
    public void testGetDirectBusRouteResponse() throws Exception {
        assertTrue(busRouteService.getDirectBusRouteResponse(3, 6).isDirectBusRoute());
        assertTrue(busRouteService.getDirectBusRouteResponse(0, 4).isDirectBusRoute());
        assertTrue(busRouteService.getDirectBusRouteResponse(6, 4).isDirectBusRoute());
        assertTrue(busRouteService.getDirectBusRouteResponse(1, 6).isDirectBusRoute());
        assertTrue(busRouteService.getDirectBusRouteResponse(6, 5).isDirectBusRoute());
        assertTrue(busRouteService.getDirectBusRouteResponse(2, 3).isDirectBusRoute());

        assertFalse(busRouteService.getDirectBusRouteResponse(3, 0).isDirectBusRoute());
        assertFalse(busRouteService.getDirectBusRouteResponse(3, 7).isDirectBusRoute());
        assertFalse(busRouteService.getDirectBusRouteResponse(15, 44).isDirectBusRoute());
        assertFalse(busRouteService.getDirectBusRouteResponse(6, 2).isDirectBusRoute());
        assertFalse(busRouteService.getDirectBusRouteResponse(4, 1).isDirectBusRoute());
        assertFalse(busRouteService.getDirectBusRouteResponse(5, 2).isDirectBusRoute());
    }

    private List<BusRoute> getBusRoutes() {
        List<BusRoute> busRoutes = new ArrayList<>();
        busRoutes.add(BusRouteBuilder.aBusRoute().withBusId(1).withStationIds(Arrays.asList(0, 1, 2, 3, 4)).build());
        busRoutes.add(BusRouteBuilder.aBusRoute().withBusId(2).withStationIds(Arrays.asList(3, 1, 6, 5)).build());
        busRoutes.add(BusRouteBuilder.aBusRoute().withBusId(3).withStationIds(Arrays.asList(0, 6, 4)).build());
        busRoutes.add(BusRouteBuilder.aBusRoute().withBusId(4).withStationIds(Arrays.asList(2, 3, 6, 4)).build());
        return busRoutes;
    }
}