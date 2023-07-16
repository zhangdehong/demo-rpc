package con.hong.rpc;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

/**
 * 服务端流式rpc-2---HelloServiceStub的使用
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2023/7/11
 */
public class GrpcClient6 {

    /**
     * 双向流rpc客户端
     * @param arges
     */
    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            HelloServiceGrpc.HelloServiceStub helloServiceStub = HelloServiceGrpc.newStub(managedChannel);
            StreamObserver<HelloProto.HelloRequest> streamObserver = helloServiceStub.cs2ss(new StreamObserver<>() {
                @Override
                public void onNext (HelloProto.HelloResponse helloResponse) {
                    System.out.println("响应的结果："+helloResponse.getResult());
                }

                @Override
                public void onError (Throwable throwable) {

                }

                @Override
                public void onCompleted () {
                    System.out.println("服务端所有响应结束！");
                }
            });
            for (int i = 0; i < 10; i++) {
                streamObserver.onNext(HelloProto.HelloRequest.newBuilder().setName("晴天："+i).build());
            }
            streamObserver.onCompleted();
            managedChannel.awaitTermination(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }
    }
}
