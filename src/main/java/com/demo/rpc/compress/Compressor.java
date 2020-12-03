package com.demo.rpc.compress;

import java.io.IOException;

/**
 * @author zhangdehong
 */
public interface Compressor {

    /**
     * 压缩式数据
     *
     * @param array
     * @return
     * @throws IOException
     */
    byte[] compress (byte[] array) throws IOException;

    /**
     * 解压缩数据
     *
     * @param array
     * @return
     * @throws IOException
     */
    byte[] unCompress (byte[] array) throws IOException;
}
