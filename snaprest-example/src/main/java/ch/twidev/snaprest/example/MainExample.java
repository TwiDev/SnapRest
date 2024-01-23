package ch.twidev.snaprest.example;

import ch.twidev.snaprest.core.components.RoutesController;
import ch.twidev.snaprest.network.bind.RequestType;
import ch.twidev.snaprest.network.bind.annotation.Route;

import java.util.logging.Logger;

public class MainExample {

    private static final Logger logger = Logger.getLogger("SnapExample");

    public static void main(String[] args) {

    }

    public static class UserController implements RoutesController {

        @Route(path = "/users/:id", requestType = RequestType.GET)
        public void getUser(int id) {
            logger.info("Get user with id %s".formatted(id));
        }


    }

}
