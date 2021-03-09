package cn.tedu.shoot;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Õº∆¨π§æﬂ¿‡ */
public class Images {
	public static BufferedImage sky;
	public static BufferedImage bullet;
	public static BufferedImage[] airplanes;
	public static BufferedImage[] bigairplanes;
	public static BufferedImage[] bees;
	public static BufferedImage[] heros;
	
	static{
		sky = loadImage("background.png");
		bullet = loadImage("bullet.png");
		//∂¡»°Õº∆¨
		airplanes = new BufferedImage[5];
		airplanes[0] = loadImage("airplane.png");
		bigairplanes = new BufferedImage[5];//ª∫≥ÂÕº∆¨
		bigairplanes[0] = loadImage("bigairplane.png");
		bees = new BufferedImage[5];
		bees[0] = loadImage("bee.png");
		
		for(int i=1;i<airplanes.length;i++){
			airplanes[i] = loadImage("bom"+i+".png");
			bigairplanes[i] = loadImage("bom"+i+".png");
			bees[i] = loadImage("bom"+i+".png");
		}
		
		heros = new BufferedImage[2];
		for(int i=0;i<heros.length;i++){
			heros[i] = loadImage("hero"+i+".png");
		}
	}
	
	public static BufferedImage loadImage(String fileName){
		try{
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void main(String[] args) {
		Images img = new Images();
		JFrame frame = new JFrame();
		
		img.loadImage("airplane.png");
		System.out.println(img.toString());
		JPanel panel = new JPanel();
		
		
	}
	
}

























