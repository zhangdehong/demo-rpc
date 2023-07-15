package con.hong.rpc;

import com.hong.grpc.generated.HelloProto;
import com.hong.grpc.generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

/**
 * 服务端流式rpc-1----HelloServiceBlockingStub的使用
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2023/7/11
 */
public class GrpcClient3 {

    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            HelloServiceGrpc.HelloServiceBlockingStub helloService = HelloServiceGrpc.newBlockingStub(managedChannel);

            HelloProto.HelloRequest.Builder helloRequest = HelloProto.HelloRequest.newBuilder();
            helloRequest.setName("晴天");
            HelloProto.HelloRequest request = helloRequest.build();

            Iterator<HelloProto.HelloResponse> responseIterator = helloService.c2ss(request);

            while (responseIterator.hasNext()) {
                HelloProto.HelloResponse helloResponse = responseIterator.next();
                System.out.println("helloResponse: " + helloResponse.getResult());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }
    }
}
