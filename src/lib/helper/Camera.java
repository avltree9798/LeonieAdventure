package lib.helper;

/**
 * Created by root on 4/21/16.
 */
public class Camera {
    public int x,y;
    public Camera(){
        x = 0;
        y = 12;
    }
    public void moveRight(){
        if(x<40-16){
            x++;
        }
    }
    public void moveLeft(){
        if(x>0){
            x--;
        }
    }
}
