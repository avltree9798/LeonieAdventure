package com.av;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.PackedColorModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by root on 4/20/16.
 */
public class AssetManager {
    private static AssetManager ourInstance = new AssetManager();
    public Image logo;
    public Image about_image;
    public String backsound = "assets/back.mp3";
    public Image background;
    public short map[][] = new short[20][40];
    public static AssetManager getInstance() {
        return ourInstance;
    }

    private AssetManager() {
        try {
            logo = ImageIO.read(new File("assets/logo.png"));
            about_image = ImageIO.read(new File("assets/about.jpg"));
            BufferedReader br = new BufferedReader(new FileReader("assets/Maps/map.avl"));
            String currentLine;
            short line = 0;
            while((currentLine = br.readLine())!=null){
                String tokens[] = currentLine.split(",");
                for(int i=0;i<tokens.length;i++){
                    map[line][i] = Short.parseShort(tokens[i]);
                }
                line++;
            }
            background = ImageIO.read(new File("assets/Backgrounds/grassbg1.gif"));
        }catch(Exception e){}
    }
}
