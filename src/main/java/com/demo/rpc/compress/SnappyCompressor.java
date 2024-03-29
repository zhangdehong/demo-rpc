package com.demo.rpc.compress;


import java.io.IOException;

import org.xerial.snappy.Snappy;

public class SnappyCompressor implements Compressor {

    @Override
    public byte[] compress(byte[] array) throws IOException {
        if (array == null) {
            return null;
        }
        return Snappy.compress(array);
    }

    @Override
    public byte[] unCompress(byte[] array) throws IOException {
        if (array == null) {
            return null;
        }
        return Snappy.uncompress(array);
    }
}
