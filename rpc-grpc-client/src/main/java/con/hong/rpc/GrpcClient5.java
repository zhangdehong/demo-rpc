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
public class GrpcClient5 {

    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            HelloServiceGrpc.HelloServiceStub helloServiceStub = HelloServiceGrpc.newStub(managedChannel);
            StreamObserver<HelloProto.HelloRequest> streamObserver = helloServiceStub.cs2s(new StreamObserver<HelloProto.HelloResponse>() {
                @Override
                public void onNext (HelloProto.HelloResponse helloResponse) {
                    // 监控响应
                    System.out.println("服务端响应了内容：" + helloResponse.getResult());
                }

                @Override
                public void onError (Throwable throwable) {

                }

                @Override
                public void onCompleted () {
                    System.out.println("服务端响应结束。。。。");
                }
            });
            // 客户端发送数据到服务端，不定时发送
            for (int i = 0; i < 10; i++) {
                HelloProto.HelloRequest.Builder builder = HelloProto.HelloRequest.newBuilder();
                builder.setName("晴天" + i);
                HelloProto.HelloRequest helloRequest = builder.build();
                streamObserver.onNext(helloRequest);
                Thread.sleep(1000);
            }
            streamObserver.onCompleted();
            managedChannel.awaitTermination(12, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }
    }
}
