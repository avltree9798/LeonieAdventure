package com.av.gamescene;

import com.av.AssetManager;
import com.av.gameobject.Hero;
import lib.GameEngine;
import lib.Scene;
import lib.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by root on 4/21/16.
 */
public class MainScene extends Scene {
    public MainScene(GameEngine game) {
        super(game);
    }
    Hero p;
    short map[][];
    @Override
    public void init() {
        p = new Hero(30,30,50,50);
        map = AssetManager.getInstance().map;
    }

    @Override
    public void update(double tpf){
        p.update(tpf);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(AssetManager.getInstance().background,0,0, Settings.CANVAS_WIDTH,Settings.CANVAS_HEIGHT,null);
        for(int y=0;y<12;y++){
            for(int x=0;x<16 && x+cam.x<map[y].length;x++){
                if(map[y][x+cam.x]==1){
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(x*50,y*50,50,50);
                }
            }
        }
        p.render(g2d);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            p.left = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            p.right = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            p.left = true;
            cam.moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            p.right = true;
            cam.moveRight();
        }
    }
}
