package pl.prutkowski.bus.route.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.prutkowski.bus.route.api.domain.DirectBusRouteResponse;
import pl.prutkowski.bus.route.api.service.BusRouteService;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BusRouteController.class)
public class BusRouteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BusRouteService busRouteService;

    @Test
    public void isDirectBusRouteTest() throws Exception {

        given(busRouteService.getDirectBusRouteResponse(3, 6)).willReturn(new DirectBusRouteResponse(3, 6, true));

        MvcResult mvcResult = mvc.perform(get("/api/direct?dep_sid=3&arr_sid=6").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(request().asyncResult(instanceOf(DirectBusRouteResponse.class)))
                .andReturn();

        this.mvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("dep_sid").value(3))
                .andExpect(jsonPath("arr_sid").value(6))
                .andExpect(jsonPath("direct_bus_route").value(true));
    }


}