package com.av;

import com.av.gamescene.Title;
import lib.GameEngine;

import javax.swing.*;

/**
 * Created by root on 4/20/16.
 */
public class Game extends GameEngine{
    public static int FRAME_WIDTH = 0;
    public static int FRAME_HEIGHT = 0;
    private boolean zoom = true;
    private float spaceCount = 0;
    public Game(){
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(AssetManager.getInstance().logo);
        frame.setTitle("Peonie Adventure");
        activeScene = new Title(this);
        frame.add(this);
        setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        start();
        setFocusable(true);
    }
    @Override
    public void init() {
        activeScene.init();
    }

    @Override
    public void update(double tpf) {
        FRAME_WIDTH = frame.getWidth();
        FRAME_HEIGHT = frame.getHeight();
        activeScene.update(tpf);
        if(zoom)spaceCount += 50*tpf;
        else spaceCount -= 50*tpf;
        if(spaceCount>200)zoom = false;
        if(spaceCount<0)zoom = true;
        String s = "";for(int j=0;j<spaceCount;j++)s+=" ";
        s+= "Peonie Adventure";
        frame.setTitle(s);
        activeScene.update(tpf);
    }
}
