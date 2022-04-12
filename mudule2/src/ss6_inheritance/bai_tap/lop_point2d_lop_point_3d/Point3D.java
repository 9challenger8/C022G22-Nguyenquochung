package ss6_inheritance.bai_tap.lop_point2d_lop_point_3d;

public class Point3D extends  Point2D{
    private float z=0f;

    public Point3D(){

    }
    public Point3D(float x,float y,float z){
        super(x,y);
        this.z=z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }
    public void setXYZ(float x,float y,float z){
        setXY(x,y);
        this.z=z;
    }
    public float[] getXYZ(){
        float[] array3D= {getX(),getY(),this.z};
        return  array3D;
    }
    @Override
    public String toString(){
        return getX() +" ,"+ getY() +" ," + getZ();
    }
}
