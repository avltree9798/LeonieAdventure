package com.av.gameobject;

import com.av.AssetManager;
import lib.Player;

import java.awt.event.KeyEvent;

/**
 * Created by root on 4/21/16.
 */
public class Hero extends Player {
    public Hero(int x, int y, int width, int height) {
        super(x, y, width, height);
        me = AssetManager.getInstance().logo;
    }
}
