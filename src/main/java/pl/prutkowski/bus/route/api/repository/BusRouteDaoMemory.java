package pl.prutkowski.bus.route.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Repository;
import pl.prutkowski.bus.route.api.domain.BusRoute;
import pl.prutkowski.bus.route.api.domain.BusRouteParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class BusRouteDaoMemory implements BusRouteDao {

    private final String fileName;
    private final List<BusRoute> busRoutes = new ArrayList<>();

    @Autowired
    public BusRouteDaoMemory(ApplicationArguments args) throws IOException {
        fileName = args.getNonOptionArgs().get(0);
        fillBusRoutes();
    }

    @Override
    public List<BusRoute> getBusRoutes() {
        return busRoutes;
    }

    private void fillBusRoutes() throws IOException {
        Path path = Paths.get(fileName);
        BusRouteParser busRouteParser = new BusRouteParser();
        try (Stream<String > lines = Files.lines(path).skip(1)) {
            lines.forEach(line -> busRoutes.add(busRouteParser.fromLine(line)));
        }
    }
}
