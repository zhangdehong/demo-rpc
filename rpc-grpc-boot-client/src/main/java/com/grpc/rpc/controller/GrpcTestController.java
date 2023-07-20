package com.grpc.rpc.controller;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangDeHong
 * @Describe: TODO
 * @Date Create by  00:59 2023/7/20
 */
@RestController
public class GrpcTestController {


    @GrpcClient("grpc-server")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceStub;

    @GetMapping("/test1")
    public String test1 (String name) {
        System.out.println("test1 name: " + name);
        HelloProto.HelloResponse hello = helloServiceStub.hello(HelloProto.HelloRequest.newBuilder().setName("test1").build());
        return hello.getResult();
    }
}
