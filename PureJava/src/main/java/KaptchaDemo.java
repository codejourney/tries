import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.google.code.kaptcha.util.Configurable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class KaptchaDemo {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.border.color", "105,179,90");
        properties.put("kaptcha.textproducer.font.color", "blue");
        properties.put("kaptcha.image.width", "210");
        properties.put("kaptcha.image.height", "45");
        properties.put("kaptcha.textproducer.font.size", "35");
        properties.put("kaptcha.session.key", "code");
        properties.put("kaptcha.textproducer.char.length", "15");
        properties.put("kaptcha.textproducer.font.names", "simsun, Arial, Courier");


        Config config = new Config(properties);

        KaptchaDemo demo = new KaptchaDemo();
        String text = "你好kaptcha";

        //使用原始不透明kaptcha
        Producer kap = demo.originKaptcha(config);
        BufferedImage bi = kap.createImage(text);
        demo.writeImageFile(bi, "/imgs/kaptcha0.png");

        //方案1. 使用透明kaptcha，直接修改背景，不使用kaptcha.background.impl
//        properties.put("kaptcha.background.impl", "");
        Config config1 = new Config(properties);

        Producer kap1 = demo.translucentKaptchaByModified(config1);
        BufferedImage bi1 = kap1.createImage(text);
        demo.writeImageFile(bi1, "/imgs/kaptcha1.png");

        //方案2. 普通的kaptcha，使用定制kaptcha.background.impl
        properties.put("kaptcha.background.impl", "TranslucentBackground");
        Config config2 = new Config(properties);

        Producer kap2 = demo.translucentKaptchaWithBkImpl(config2);
        BufferedImage bi2 = kap2.createImage(text);
        demo.writeImageFile(bi2, "/imgs/kaptcha2.png");
    }

    public Producer originKaptcha(Config config ) {

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return (Producer)defaultKaptcha;
    }

    //方案1
    public Producer translucentKaptchaByModified(Config config ) {

        Configurable translucentKaptcha = new TranslucentKaptcha();
        translucentKaptcha.setConfig(config);
        return (Producer)translucentKaptcha;
    }


    //方案2
    public Producer translucentKaptchaWithBkImpl(Config config ) {

        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return (Producer)defaultKaptcha;
    }

    public void writeImageFile(BufferedImage bi, String path) {
        File outputfile = new File(path);
        try {
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
