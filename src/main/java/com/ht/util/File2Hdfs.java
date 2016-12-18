package com.ht.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class File2Hdfs {

	public static void toHdfs(final byte[] jsonbyte,final String fileName){
		new Thread(
				new Runnable() {
					@Override
					public void run() {
//						String uri = "hdfs://192.168.1.9:9000/app/icare/appconfig/userdevice.json";
						String uri =InitParamUtil.getProperty("outputpath")+"/app/icare/appconfig/"+fileName;
						OutputStream out = null;
						Configuration conf = new Configuration();
						try {
							FileSystem fs = FileSystem.get(URI.create(uri), conf);
							out = fs.create(new Path(uri), new Progressable() {
								@Override
								public void progress() {
									System.out.println("*");
								}
							});

							out.write(jsonbyte);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							IOUtils.closeStream(out);
						}
					}
				}
		).start();
		
	}
	
	public static void toAppendHdfs(final byte[] jsonbyte){
		new Thread(
				new Runnable() {
					@Override
					public void run() {
//						String uri = "hdfs://192.168.1.9:9000/app/icare/appconfig/thresholdvalue.json";
						String outputpath=InitParamUtil.getProperty("outputpath");
						String uri =outputpath+"/app/icare/appconfig/thresholdvalue.json";
						OutputStream out = null;
						Configuration conf = new Configuration();
						conf.setBoolean("dfs.support.append", true);  
						try {
							FileSystem fs = FileSystem.get(URI.create(outputpath),conf);
							if(!fs.exists(new Path(uri))){
								fs.create(new Path(uri));
								fs.close();
								fs=null;
							}
							//Ҫ׷�ӵ��ļ�����inpathΪ�ļ�
							fs = FileSystem.get(URI.create(uri), conf);
					        InputStream in = new 
					        		ByteArrayInputStream(jsonbyte);
					        out = fs.append(new Path(uri));
					        IOUtils.copyBytes(in, out, 4096, true);
					       
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							IOUtils.closeStream(out);
						}
					}
				}
		).start();
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		toAppendHdfs("55555555".getBytes());
		
		
//        String local = "F:\\temp\\users_devices.json";
//        String uri = "hdfs://192.168.1.9:9000/app/icare/appconfig/userdevice.json";
//       
//        FileInputStream in = null;
//        OutputStream out = null;
//        Configuration conf = new Configuration();
//        try {
//            in = new FileInputStream(new File(local));
//         
//            FileSystem fs = FileSystem.get(URI.create(uri), conf);
//            out = fs.create(new Path(uri), new Progressable() {
//                @Override
//                public void progress() {
//                    System.out.println("*");
//                }
//            });
//       
//            byte[] buffer = new byte[20];
//           
//            int bytesRead = in.read(buffer);
//            if (bytesRead >= 0) {
//                out.write(buffer, 0, bytesRead);
//            }
//        }catch(Exception e){
//        	e.printStackTrace();
//        } 
//        finally {
//            IOUtils.closeStream(in);
//            IOUtils.closeStream(out);
//        }      
    }
}

