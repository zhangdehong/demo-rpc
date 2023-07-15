package con.hong.rpc;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * repeatde 的使用
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2023/7/11
 */
public class GrpcClient2 {

    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            // 2.获得代理对象
            HelloServiceGrpc.HelloServiceBlockingStub helloService = HelloServiceGrpc.newBlockingStub(managedChannel);
            // 3.完成rpc调用
            // 3.1准备参数
            HelloProto.HelloRequest1.Builder builder = HelloProto.HelloRequest1.newBuilder();
            builder.addName("程序猿1");
            builder.addName("程序猿2");
            builder.addName("程序猿3");
            HelloProto.HelloRequest1 build = builder.build();

            // 3.2 进行rpc调用
            HelloProto.HelloResponse1 response1 = helloService.hello1(build);
            System.out.println("hello1 service result: " + response1.getResult());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            managedChannel.shutdown();
        }
    }
}
