package com.av.gameobject;

import com.av.AssetManager;
import lib.GameObject;
import lib.Settings;

import java.awt.*;

/**
 * Created by root on 4/21/16.
 */
public class Heart extends GameObject {
    public Image image;
    int xspeed = 1;
    int yspeed = 1;
    public Heart(int x, int y, int width, int height) {
        super(x, y, width, height);
        image = AssetManager.getInstance().logo;
    }

    @Override
    public void update(double tpf) {
        if(x<=0){
            xspeed*=-1;
        }
        if(y<=0){
            yspeed*=-1;
        }
        if(x+width>= Settings.CANVAS_WIDTH){
            xspeed*=-1;
        }
        if(y+height>= Settings.CANVAS_HEIGHT){
            yspeed*=-1;
        }
        x+=xspeed;
        y+=yspeed;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(image,x,y,width,height,null);
    }
}
