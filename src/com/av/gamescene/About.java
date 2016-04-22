package com.av.gamescene;

import com.av.gameobject.Heart;
import lib.GameEngine;
import lib.Scene;
import lib.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by root on 4/21/16.
 */
public class About extends Scene {
    Heart h;
    Heart h1;
    Heart h2;
    public About(GameEngine game) {
        super(game);
        h = new Heart(4,4,30,30);
        h1 = new Heart(300,40,30,30);
        h2 = new Heart(100,200,30,30);
    }

    @Override
    public void init() {

    }

    @Override
    public void update(double tpf) {
        h.update(tpf);
        h1.update(tpf);
        h2.update(tpf);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0, Settings.CANVAS_WIDTH, Settings.CANVAS_HEIGHT);
        h.render(g2d);
        h1.render(g2d);
        h2.render(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            game.changeScene(new Title(game));
        }
    }
}
