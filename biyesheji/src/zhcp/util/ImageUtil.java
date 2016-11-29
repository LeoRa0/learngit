package zhcp.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public final class ImageUtil {
	//字库
	private static final String[] chars = { 
	 "2", "3", "4", "5", "6","7", "8", "9",
	"A", "B", "C", "D", "E", "F", "G", "H", "J",
    "K", "L", "M", "N", "P","Q", "R", "S", "T", 
    "U", "V","W", "X", "Y", "Z" };
	private static final int SIZE=4;
	private static final int LINES=15;
	private static final int WIDTH=200;
	private static final int HEIGHT=100;
	private static final int FONT_SIZE=70;
	
	public static Map<String,BufferedImage> createImage(){
		StringBuffer sb=new StringBuffer();
		//创建一个画布
		BufferedImage image=new BufferedImage(WIDTH,HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		//创建画笔(从画布上获得)。创建供绘制闭屏图像使用的图形上下文。
		Graphics graphic=image.getGraphics();
		graphic.setColor(Color.LIGHT_GRAY);//画笔颜色
		graphic.fillRect(0, 0, WIDTH, HEIGHT);//填充矩形画布
		
		/*Image img=null;
		try {
			 img = ImageIO.read(new File("src/img/image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//在缓冲图对象image上绘制图像（验证码图片背景）
	    image.getGraphics().drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		*/
		
		Random ran=new Random();
		
		//画随机字符
		for(int i=0;i<SIZE;i++){
			int r=ran.nextInt(chars.length);
			graphic.setColor(getRandomColor());
			graphic.setFont(new Font(
					null,Font.BOLD+Font.ITALIC,FONT_SIZE));
			
			//将生成的字母旋转制定角度
			Graphics2D gs2d=(Graphics2D)graphic;
			AffineTransform trans=new AffineTransform();
			trans.rotate(ran.nextInt(45)*3.14/180,22*i+8,7);
			
			//随机缩放字母
			float scaleSize=ran.nextFloat()+0.8f;
			if(scaleSize>1f){
				scaleSize=1f;
			}
			trans.scale(scaleSize,scaleSize);//缩放
			gs2d.setTransform(trans);//设置AffineTransform对象
			
			//在画布上绘制指定的字符串
			graphic.drawString(
					chars[r], i*WIDTH/(SIZE+1)+25,HEIGHT/2);
			
			sb.append(chars[r]);//将字符保存，存入session
		}
		
		//画干扰线
		for(int i=1;i<LINES;i++){
			//”画笔“换一种颜色
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), 
					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		
		Map<String,BufferedImage> map=new HashMap<String,BufferedImage>();
		map.put(sb.toString(),image);
		return map;
	}
	
	public static Color getRandomColor(){
		Random ran=new Random();
		Color color=new Color(ran.nextInt(256),
				ran.nextInt(256),ran.nextInt(256));
		return color;
	}
}
