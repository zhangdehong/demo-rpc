package com.demo.rpc.registry;

import java.util.List;

import org.apache.curator.x.discovery.ServiceInstance;

/**
 * @author zhangdehong
 */
public interface Registry<T> {

    void registerService(ServiceInstance<T> service) throws Exception;

    void unregisterService(ServiceInstance<T> service) throws Exception;

    List<ServiceInstance<T>> queryForInstances(String name) throws Exception;
}
