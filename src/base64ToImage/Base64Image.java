package base64ToImage;

import java.io.FileOutputStream;
import java.io.OutputStream;

import Decoder.BASE64Decoder;
  

/**
 * 将图片转为base64；
 * base64转为图片
 * @author BZP
 *没有找到BASE64Encodeer的jar包
 */
public class Base64Image {  
    public static void main(String[] args) {  
        // 测试从Base64编码转换为图片文件  
        String strImg = "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";  
        GenerateImage(strImg, "D:\\wangyc.jpg");  
          
        // 测试从图片文件转换为Base64编码  
        //System.out.println(GetImageStr("d:\\wangyc.jpg"));  
    }  
  
    /*public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        byte[] data = null;  
          
        // 读取图片字节数组  
        try {  
            InputStream in = new FileInputStream(imgFilePath);  
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        // 对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串  
    }  */
  
    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) // 图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try {  
            // Base64解码  
            byte[] bytes = decoder.decodeBuffer(imgStr);  
            for (int i = 0; i < bytes.length; ++i) {  
                if (bytes[i] < 0) {// 调整异常数据  
                    bytes[i] += 256;  
                }  
            }  
            // 生成jpeg图片  
            OutputStream out = new FileOutputStream(imgFilePath);  
            out.write(bytes);  
            out.flush();  
            out.close();  
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
    }  
}  
