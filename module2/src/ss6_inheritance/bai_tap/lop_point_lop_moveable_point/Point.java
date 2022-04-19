package ss6_inheritance.bai_tap.lop_point_lop_moveable_point;

public class Point {
    private float x=0.0f;
    private float y=0.0f;

    public Point(){

    }
    public Point(float x,float y){
        this.x=x;
        this.y=y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }
    public void setXY(float x,float y){
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        float [] array2D={this.x,this.y};
        return array2D;
    }
    @Override
    public String toString(){
        return this.x+" ," +this.y;
    }
}
