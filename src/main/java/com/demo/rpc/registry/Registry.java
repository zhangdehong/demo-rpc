package com.demo.rpc.registry;

import java.util.List;

import org.apache.curator.x.discovery.ServiceInstance;

/**
 * @author zhangdehong
 */
public interface Registry<T> {

    /**
     * 注册服务实例
     *
     * @param service
     * @throws Exception
     */
    void registerService (ServiceInstance<T> service) throws Exception;

    /**
     * 取消注册服务实例
     *
     * @param service
     * @throws Exception
     */
    void unregisterService (ServiceInstance<T> service) throws Exception;

    /**
     * 查询注册实例
     *
     * @param name
     * @return
     * @throws Exception
     */
    List<ServiceInstance<T>> queryForInstances (String name) throws Exception;
}
