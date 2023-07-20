package com.hong.grpc.server.service;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: zhangDeHong
 * @Describe: TODO
 * @Date Create by  00:35 2023/7/19
 */
@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public void hello (HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        String name = request.getName();

        LOGGER.info("HelloServiceImpl hello {}", name);
        responseObserver.onNext(HelloProto.HelloResponse.newBuilder().setResult("grpc boot service impl").build());
        // 结束
        responseObserver.onCompleted();
    }
}
