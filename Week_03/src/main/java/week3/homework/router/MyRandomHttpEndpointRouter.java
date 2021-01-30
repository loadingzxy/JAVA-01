package week3.homework.router;

import java.util.List;
import java.util.Random;

public class MyRandomHttpEndpointRouter implements MyHttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());

        return urls.get(random.nextInt(size));
    }
}
