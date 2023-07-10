package com.hong.service;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * 1 提交client的请求参数
 * 2 业务处理 service + dao 调用对应的业务功能
 * 3 提供返回值，响应数据
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:04 2023/7/11
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {


    /**
     * * 1 提交client的请求参数
     * * 2 业务处理 service + dao 调用对应的业务功能
     * * 3 提供返回值，响应数据
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void hello (HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        // 1 接受客户端的请求参数
        String name = request.getName();
        // 2 业务处理
        System.out.println("name parameter "+name);
        // 3 封装响应
        // 3.1创建响应对象的构造者
        HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();

        // 3.2填充数据
        builder.setResult("hello method invoke success!");
        // 3.3封装响应
        HelloProto.HelloResponse response = builder.build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();

        // super.hello(request, responseObserver);
    }
}
