package ss6_inheritance.bai_tap.lop_point_lop_moveable_point;

public class MoveAblePoint extends Point {
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;

    public MoveAblePoint(float x,float y,float xSpeed, float ySpeed){
        super(x,y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public MoveAblePoint(){

    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

}
