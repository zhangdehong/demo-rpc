package com.hong.service;

import com.hong.grpc.generated.FeatureProto;
import com.hong.grpc.generated.FeatureServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @Author: zhangDeHong
 * @Describe: TODO
 * @Date Create by  23:42 2023/7/18
 */
public class FeatureServiceImpl extends FeatureServiceGrpc.FeatureServiceImplBase {

    @Override
    public void featureTest (FeatureProto.FeatureRequest request, StreamObserver<FeatureProto.FeatureResponse> responseObserver) {
        String name = request.getName();
        System.out.println("name :"+name);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(FeatureProto.FeatureResponse.newBuilder().setResult("feature end").build());
        responseObserver.onCompleted();
    }
}
