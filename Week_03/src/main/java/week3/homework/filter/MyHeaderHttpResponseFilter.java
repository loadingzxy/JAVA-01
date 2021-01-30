package week3.homework.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class MyHeaderHttpResponseFilter implements MyHttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {

        response.headers().set("test", "response");
    }
}
