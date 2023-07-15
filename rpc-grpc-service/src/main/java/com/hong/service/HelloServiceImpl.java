package com.hong.service;

import com.google.protobuf.ProtocolStringList;
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
        System.out.println("name parameter： " + name);
        // 3 封装响应
        // 3.1创建响应对象的构造者
        HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();

        // 3.2填充数据
        builder.setResult("hello method invoke success!");
        // 3.3封装响应
        HelloProto.HelloResponse response = builder.build();

        // 将处理后的响应数据通过网络回传客户端
        responseObserver.onNext(response);

        // 通知客户端响应已经结束
        responseObserver.onCompleted();

    }

    @Override
    public void hello1 (HelloProto.HelloRequest1 request, StreamObserver<HelloProto.HelloResponse1> responseObserver) {
        ProtocolStringList nameList = request.getNameList();
        for (String name : nameList) {
            System.out.println("HelloServiceImpl hello1 name: " + name);
        }
        HelloProto.HelloResponse1.Builder builder = HelloProto.HelloResponse1.newBuilder();
        builder.setResult("ok");
        HelloProto.HelloResponse1 build = builder.build();
        responseObserver.onNext(build);
        // 处理完成
        responseObserver.onCompleted();
    }

    /**
     * 服务端流式rpc
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void c2ss (HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        // 1 接受client的请求参数
        String name = request.getName();
        // 2 做业务处理
        System.out.println("HelloServiceImpl c2ss: " + name);
        // 3 根据业务处理的结果，提供响应
        for (int i = 0; i < 10; i++) {
            HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();
            builder.setResult("处理结果：" + i);
            HelloProto.HelloResponse build = builder.build();
            responseObserver.onNext(build);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        // 处理完成
        responseObserver.onCompleted();
    }

    /**
     * 客户端流式rpc
     *
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<HelloProto.HelloRequest> cs2s (StreamObserver<HelloProto.HelloResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext (HelloProto.HelloRequest helloRequest) {
                System.out.println("接收到客户端发送的一条消息：" + helloRequest.getName());
            }

            @Override
            public void onError (Throwable throwable) {
                System.out.println("服务端异常！"+throwable);
            }

            @Override
            public void onCompleted () {
                System.out.println("client的所有消息都发送到了服务端！");
                // 开始响应，接受了client的所有数据后处理完成开始响应
                HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();
                builder.setResult("client stream end ,this is result");
                HelloProto.HelloResponse build = builder.build();
                responseObserver.onNext(build);
                responseObserver.onCompleted();
            }
        };
    }
}
