package com.lq.sm4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.lq.pub.utils.Utils;

public class Test07 {
	final static byte[] key= {-31, -112, -112, 121, 110, -39, -31, 11, -32, -128, 72, 31, 89, -34, -89, 12};
	public static void  write(String path,String content ,String encoding) throws IOException{
		File file = new File(path);
		file.delete();
		file.createNewFile();
		BufferedWriter  writer =  new BufferedWriter(
	    new OutputStreamWriter(new FileOutputStream(file),encoding));
		writer.write(content);
		writer.close();
	}
	
	public static void  writeY(String path,byte[] data ,String encoding) throws IOException{
		File file = new File(path);
		file.delete();
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		//byte[] data = content.getBytes(encoding);
		fos.write(data);
		fos.close();
//		BufferedWriter  writer =  new BufferedWriter(
//				new OutputStreamWriter(new FileOutputStream(file),encoding));
//		writer.write(content);
//		writer.close();
	}
	
	public static String read(String path, String encoding) throws IOException{
		String content="";
		File file = new File(path);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file),encoding));
		String line =null;
		while((line=reader.readLine())!=null){
			content +=line+"\n";
		}
		reader.close();
 		return content;
	}
	public static String readY(String path, String encoding) throws IOException{
		String content="";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		byte[] data =new byte[100000];
		int len= fis.read(data);
		content =new String(data,0,len,"UTF-8");
		fis.close();
//		BufferedReader reader = new BufferedReader(
//				new InputStreamReader(new FileInputStream(file),encoding));
//		String line =null;
//		while((line=reader.readLine())!=null){
//			content +=line+"\n";
//		}
//		reader.close();
		return content;
	}
	
    public static void main(String[] args) throws Exception {
		 //String content ="方法不对,努力白费";
		 String path="D:/data/voucher/upload/voucher/voucher4.xml";
		 String path1="D:/data/voucher/upload/voucher/voucher3.xml";
		 String encoding ="UTF-8";
		 String encode1= Utils.getFileEncode(path);
		// Test07.write(path, content, encoding);
		 //System.out.println(Test07.read(path, encoding));
		 String plaintext=	Utils.readFile("D:\\广州财政\\加密\\xml\\22.xml");
		 encryption(plaintext,encoding,path);
		//  Utils.getFile(enOut, "D:/data/voucher/upload/voucher", "voucher.xml");
		 //解密
		 //byte[] mw= Utils.getBytes(path);
		 String jsStr= readY(path,encoding);
		 String deOutStr1 = SMS4.decodeSMS4toString(jsStr.getBytes(), key,encoding);
		 //Test07.write(path1, deOutStr1.trim(), encoding);
		 //Test07.write(path1, deOutStr, encoding);
		 System.out.println("解密:"+deOutStr1);
		 //String encode= Utils.getFileEncode(path1);
		 //System.out.println("编码："+encode);
	}
    
    private static String encryption(String content ,String encoding, String path) throws Exception{
	    //加密
	   byte[] enOut = SMS4.encodeSMS4(content.trim(), key);
	   //String strWriter= bytetoString(enOut,encoding);
		 //加密输出
	   //Test07.write(path, strWriter.trim(), encoding);
	   Test07.writeY(path, enOut, encoding);
       String EnCoding= Utils.getFileEncode(path);
	   String deOutStr = SMS4.decodeSMS4toString(enOut, key,EnCoding);
	   System.out.println("加密:"+deOutStr);
       return "";
    }
    
	private static String  bytetoString(byte[] enOut ,String encoding) throws Exception{
		//String s = new String(enOut,encoding);
		String s = new String(enOut);
		 System.out.println(s);
		 return s;
	}
	
	
	
	
}
