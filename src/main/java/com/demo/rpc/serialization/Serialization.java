package com.demo.rpc.serialization;

import java.io.IOException;

/**
 * Created on 2020-06-19
 */
public interface Serialization {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize (T obj) throws IOException;

    /**
     * 反序列化
     *
     * @param data
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize (byte[] data, Class<T> clz) throws IOException;
}