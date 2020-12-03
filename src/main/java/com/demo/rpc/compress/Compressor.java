package com.demo.rpc.compress;

import java.io.IOException;

/**
 * @author zhangdehong
 */
public interface Compressor {

    byte[] compress(byte[] array) throws IOException;

    byte[] unCompress(byte[] array) throws IOException;
}
