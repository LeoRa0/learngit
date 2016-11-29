package zhcp.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import zhcp.util.ImageUtil;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageAction extends BaseAction{
    private InputStream imageStream;
   
    public String execute(){
    	//生产验证码集合
    	Map<String,BufferedImage> map=ImageUtil.createImage();
    	
    	//从map中获取验证码字符串
    	String code=map.keySet().iterator().next();
    	session.put("code", code);
    	//System.out.println(code);
    	
    	//从map中获取验证码图片
    	BufferedImage image=map.get(code);
    	
    	//将image转换为JPEG图片格式，并将其类型转化为InputStream类型
    	ByteArrayOutputStream bos=new ByteArrayOutputStream();
    	JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(bos);
    	try {
			encoder.encode(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] bts=bos.toByteArray();
		imageStream=new ByteArrayInputStream(bts);
    	return "success";
    }
	
    public InputStream getImageStream() {
		return imageStream;
	}

	public void setImagetream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
    
}
