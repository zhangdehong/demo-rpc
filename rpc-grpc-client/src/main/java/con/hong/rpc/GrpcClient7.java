package con.hong.rpc;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.hong.grpc.generated.FeatureProto;
import com.hong.grpc.generated.FeatureServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 服务端流式rpc-2---HelloServiceStub的使用
 *
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  00:45 2023/7/11
 */
public class GrpcClient7 {

    /**
     * 双向流rpc客户端
     *
     * @param arges
     */
    public static void main (String[] arges) {
        // 1.创建通信管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9888).usePlaintext().build();
        try {
            FeatureServiceGrpc.FeatureServiceFutureStub futureStub = FeatureServiceGrpc.newFutureStub(managedChannel);
            ListenableFuture<FeatureProto.FeatureResponse> featureTest = futureStub.featureTest(FeatureProto.FeatureRequest.newBuilder().setName("feature test").build());

            /**
             * 同步操作
             */
            // FeatureProto.FeatureResponse featureResponse = featureTest.get();
            // String result = featureResponse.getResult();


            // 异步处理
            // featureTest.addListener(() -> {
            //     System.out.println("异步的rpc响应回来了！");
            // }, Executors.newCachedThreadPool());

            Futures.addCallback(featureTest, new FutureCallback<FeatureProto.FeatureResponse>() {
                @Override
                public void onSuccess (FeatureProto.FeatureResponse featureResponse) {
                    String result = featureResponse.getResult();
                    System.out.println("call back result " + result);
                }

                @Override
                public void onFailure (Throwable throwable) {

                }
            }, Executors.newCachedThreadPool());

            System.out.println("feature stub result ");

            managedChannel.awaitTermination(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managedChannel.shutdown();
        }
    }
}
