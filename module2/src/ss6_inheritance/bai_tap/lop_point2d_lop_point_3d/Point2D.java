package ss6_inheritance.bai_tap.lop_point2d_lop_point_3d;

public class Point2D {
    private float x=0.0f;
    private float y=0.0f;

    public Point2D(){

    }
    public Point2D(float x,float y){
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
