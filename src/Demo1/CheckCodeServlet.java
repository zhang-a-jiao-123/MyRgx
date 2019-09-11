package Demo1;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.画张图片
        int width=150;
        int height=50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //2.拿个笔
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);//渲染背景
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);//设置边框
        //3.往里面写字
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体",Font.PLAIN,30));
        String str="abcdefgABCDEFG1234567890";//生成随机数字
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }
        //4.画干扰线
        g.setColor(Color.GRAY);
        for (int i = 1; i <= 30; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //5.将图片写出去
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
