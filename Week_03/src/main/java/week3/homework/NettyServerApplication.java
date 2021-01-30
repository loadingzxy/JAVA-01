package week3.homework;


import week3.homework.inbound.MyHttpInboundServer;

import java.util.Arrays;

/**
 * @program: week3
 * @description: netty启动类
 * @author: zhxy
 * @create: 2021-01-30 22:30
 **/
public class NettyServerApplication {

    public final static String GATEWAY_NAME = "MyNIOGateway";


    public static void main(String[] args) {

        String proxyPort = System.getProperty("proxyPort","8888");
        String proxyServers = System.getProperty("proxyServers","http://localhost:8801,http://localhost:8802");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " +" starting...");
        MyHttpInboundServer server = new MyHttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " "  +" started at http://localhost:" + port + " for server:" + server.toString());
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
