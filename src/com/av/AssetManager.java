package com.av;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by root on 4/20/16.
 */
public class AssetManager {
    private static AssetManager ourInstance = new AssetManager();
    Image logo;
    public static AssetManager getInstance() {
        return ourInstance;
    }

    private AssetManager() {
        try {
            logo = ImageIO.read(new File("assets/logo.png"));
        }catch(Exception e){}
    }
}
