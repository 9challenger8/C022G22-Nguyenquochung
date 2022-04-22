package ss14_xu_li_ngoai_le_va_debug.bai_tap;

public class Triangle {
    private int edgeA;
    private int edgeB;
    private int edgeC;

    public Triangle() {
    }

    public Triangle(int edgeA,int edgeB,int edgeC) throws IllegalTriangleException {
        if (edgeA <= 0 || edgeB <= 0 || edgeC <= 0) {
            throw new IllegalTriangleException("Exception: Triangle edge is less than or equal to 0");
        } else if (edgeA + edgeB <= edgeC || edgeB + edgeC <= edgeA || edgeA + edgeC <= edgeB) {
            throw new IllegalTriangleException("Exception: Sum of 2 triangle edge is less than the other.");
        } else {
            this.edgeA = edgeA;
            this.edgeB = edgeB;
            this.edgeC = edgeC;
        }
    }
    public int getPerimeter() {
        return edgeA + edgeB + edgeC;
    }
}
