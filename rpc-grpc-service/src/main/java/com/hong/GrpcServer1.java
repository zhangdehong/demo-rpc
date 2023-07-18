package com.hong;

import com.hong.service.FeatureServiceImpl;
import com.hong.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:21 2023/7/11
 */
public class GrpcServer1 {

    public static void main (String[] args) throws IOException, InterruptedException {
        // 绑定端口
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(9888);

        // 发布服务
        serverBuilder.addService(new HelloServiceImpl());
        serverBuilder.addService(new FeatureServiceImpl());

        // 创建服务对象
        Server server = serverBuilder.build();

        server.start();
        server.awaitTermination();

    }
}
