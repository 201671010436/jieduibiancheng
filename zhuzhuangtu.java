package a.a;
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileOutputStream;  
import javax.imageio.ImageIO;  
public class zhuzhuangtu {  
    private static Font mFont = new Font("ËÎÌו", Font.PLAIN, 12);  
    public static void main(String[] args){  
        double[] value = {0.57d,1.25d,0.83d,1.38d,2.35d};  
        createimage(value,2.35d);  
    }  
    private static void createimage(double[] value,double maxvalue){  
        try{  
            int ranwidth = 33,ranheight = 112;  
            int width = 764, height = 168;  
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            Graphics g = image.getGraphics();  
            g.setColor(new Color(255, 255,255));  
            g.fillRect(1, 1, width - 1, height - 1);  
            g.setColor(new Color(255, 255,255));  
            g.drawRect(0, 0, width - 1, height - 1);  
            g.setFont(mFont);  
            g.setColor(new Color(255, 26,135));  
            Color c = new Color(227, 227, 227);  
            for(int i= 0 ;i<5;i++){  
                if(i==0){  
                    g.setColor(c);  
                    g.fillRect(72, 54, 33, ranheight);  
                    g.setColor(c);  
                    g.drawRect(72, 54, 33, ranheight);  
                }else{  
                    g.setColor(c);  
                    g.fillRect(72+(ranwidth+110)*i, 54, 33, ranheight);  
                    g.setColor(c);  
                    g.drawRect(72+(ranwidth+110)*i, 54, 33, ranheight);  
                }  
            }  
            for(int i= 0 ;i<value.length;i++){  
                Color myc = null;  
                if(i == 0){  
                    myc = new Color(75,178,209);  
                }else if(i==1){  
                    myc = new Color(243,152,1);  
                }else if(i == 2){  
                    myc = new Color(90,159,105);  
                }else if(i == 3){  
                    myc = new Color(144,130,189);  
                }else{  
                    myc = new Color(154,190,66);  
                }  
                if(i==0){  
                    g.setColor(myc);  
                    g.fillRect(72, 54+(ranheight-(int)Math.round(ranheight*(value[i]/maxvalue))), 33, (int)Math.round(ranheight*(value[i]/maxvalue)));  
                    g.setColor(myc);  
                    g.fillRect(72, 54+(ranheight-(int)Math.round(ranheight*(value[i]/maxvalue))), 33, (int)Math.round(ranheight*(value[i]/maxvalue)));  
                }else{  
                    g.setColor(myc);  
                    g.fillRect(72+(ranwidth+110)*i, 54+(ranheight-(int)Math.round(ranheight*(value[i]/maxvalue))), 33, (int)Math.round(ranheight*(value[i]/maxvalue)));  
                    g.setColor(myc);  
                    g.drawRect(72+(ranwidth+110)*i, 54+(ranheight-(int)Math.round(ranheight*(value[i]/maxvalue))), 33, (int)Math.round(ranheight*(value[i]/maxvalue)));  
                }  
            }  
            c = new Color(181, 181, 181);  
            for(int i = 0;i<5;i++){  
                if(i==0){  
                    g.setColor(c);  
                    g.setFont(mFont);  
                    g.drawString(value[i]+"s", 72,48);  
                }else{  
                    g.setColor(c);  
                    g.setFont(mFont);  
                    g.drawString(value[i]+"s", 72+(ranwidth+110)*i,48);  
                }  
            }  
            g.dispose();  
            String filename = "d:\\createimg.jpg";  
            File file = new File(filename);  
            if(!file.exists()){  
                file.createNewFile();  
            }  
            FileOutputStream s = new FileOutputStream(file);  
            ImageIO.write(image, "JPEG", s);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
}  