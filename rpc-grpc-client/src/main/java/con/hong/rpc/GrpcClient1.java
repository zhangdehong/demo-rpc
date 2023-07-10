package con.hong.rpc;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2023/7/11
 */
public class GrpcClient1 {

    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            // 2.获得代理对象
            HelloServiceGrpc.HelloServiceBlockingStub helloService = HelloServiceGrpc.newBlockingStub(managedChannel);
            // 3.完成rpc调用
            // 3.1准备参数
            HelloProto.HelloRequest.Builder builder = HelloProto.HelloRequest.newBuilder();
            builder.setName("hello grpc");
            HelloProto.HelloRequest helloRequest = builder.build();
            // 3.2 进行rpc调用
            HelloProto.HelloResponse hello = helloService.hello(helloRequest);
            System.out.println(hello.getResult());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            managedChannel.shutdown();
        }
    }
}
