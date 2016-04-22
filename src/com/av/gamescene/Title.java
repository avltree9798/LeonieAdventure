package com.av.gamescene;

import lib.GameEngine;
import lib.Scene;
import lib.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by root on 4/21/16.
 */
public class Title extends Scene{
    private String[] menus = new String[]{"Play","About","Exit"};
    private int menu = 0;
    public Title(GameEngine simpleApplication) {
        super(simpleApplication);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(double tpf) {

    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0, Settings.CANVAS_WIDTH, Settings.CANVAS_HEIGHT);
        for(int i=0;i<menus.length;i++){
            g2d.setColor(Color.WHITE);
            if(i==menu)g2d.setColor(Color.RED);
            int x = (Settings.CANVAS_WIDTH + menus[i].length())/2;
            int y = 50 * i+200;
            g2d.drawString(menus[i],x,y);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            if(menu==0){
                menu = 2;
            }else{
                menu--;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(menu==2){
                menu = 0;
            }else{
                menu++;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(menu==0){
                game.changeScene(new MainScene(game));
            }else if(menu==1){
                game.changeScene(new About(game));
            }else if(menu==2){
                game.close();
            }
        }
    }
}
