package com.demo.rpc.protocol;

/**
 * @author zhangdehong
 */
public class Header {

    /**
     * 魔数
     */
    private short magic;
    /**
     * 版本号
     */
    private byte version;
    /**
     * 附加信息
     */
    private byte extraInfo;
    /**
     * 消息ID
     */
    private Long messageId;
    /**
     * 消息体长度
     */
    private Integer size;

    public Header (short magic, byte version) {
        this.magic = magic;
        this.version = version;
        this.extraInfo = 0;
    }

    public Header (short magic, byte version, byte extraInfo, Long messageId, Integer size) {
        this.magic = magic;
        this.version = version;
        this.extraInfo = extraInfo;
        this.messageId = messageId;
        this.size = size;
    }

    public short getMagic () {
        return magic;
    }

    public void setMagic (short magic) {
        this.magic = magic;
    }

    public byte getVersion () {
        return version;
    }

    public void setVersion (byte version) {
        this.version = version;
    }

    public byte getExtraInfo () {
        return extraInfo;
    }

    public void setExtraInfo (byte extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Long getMessageId () {
        return messageId;
    }

    public void setMessageId (Long messageId) {
        this.messageId = messageId;
    }

    public Integer getSize () {
        return size;
    }

    public void setSize (Integer size) {
        this.size = size;
    }

    public void setSerialization (byte serialization) {
        this.extraInfo |= serialization;
    }

    public void setCompressor (byte compressor) {
        this.extraInfo |= compressor;
    }
}

