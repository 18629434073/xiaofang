package com.ht.util;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by de on 2016/5/18.
 */
public class Send {

    public static void main(String[] args) throws Exception{
        String newData = "0B-F3-A1-AA-3A-7A-3E-91-35-F3-34-7D-BB-50-4D-6E-95-A1-00-BF-E9-EA-3C-B9";
        byte [] aa = new byte[]{0x16,0x52,0x3E};

//        InetSocketAddress address = new InetSocketAddress("localhost", 27000);
           DatagramChannel datagramChannel = DatagramChannel.open();
//        datagramChannel.socket().setReceiveBufferSize(2097152);
//        datagramChannel.socket().setReuseAddress(true);
//        datagramChannel.socket().setSendBufferSize(2097152);
//        datagramChannel.socket().bind(address);



        ByteBuffer buf = ByteBuffer.allocate(100);
        buf.clear();
        buf.put(aa);
        buf.flip();

        int bytesSent = datagramChannel.send(buf, new InetSocketAddress("localhost", 27000));
    }

}
