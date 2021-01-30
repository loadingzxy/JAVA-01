package week3.homework.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface MyHttpResponseFilter {

    void filter(FullHttpResponse response);

}
