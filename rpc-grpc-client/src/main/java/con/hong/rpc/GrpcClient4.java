package con.hong.rpc;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

/**
 * 服务端流式rpc-2---HelloServiceStub的使用
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2023/7/11
 */
public class GrpcClient4 {

    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            HelloServiceGrpc.HelloServiceStub helloServiceStub = HelloServiceGrpc.newStub(managedChannel);

            HelloProto.HelloRequest.Builder builder = HelloProto.HelloRequest.newBuilder();
            builder.setName("小鹦鹉");
            HelloProto.HelloRequest helloRequest = builder.build();

            helloServiceStub.c2ss(helloRequest, new StreamObserver<>() {
                @Override
                public void onNext (HelloProto.HelloResponse helloResponse) {
                    // 拿到服务端的消息后开始
                    System.out.println("服务端每一次响应的消息：" + helloResponse.getResult());
                }

                @Override
                public void onError (Throwable throwable) {
                    // 服务端异常响应后处理
                }

                @Override
                public void onCompleted () {
                    // 拿到服务端的所有数据后开始处理
                    System.out.println("服务器端响应处理结束，根据需要统一处理服务端响应的内容！");
                }
            });
            managedChannel.awaitTermination(15, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            managedChannel.shutdown();
        }
    }
}
