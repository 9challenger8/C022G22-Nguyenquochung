package ss4_class_and_object.bai_tap.StopWatch;

public class MainStopWatch {
    public static void main(String[] args) {
        StopWatch stop=new StopWatch();
        stop.start();
        int a=0,b=1,c=2;
        for(long i=0;i<100000000;i++){
            a=b;
            c=a;
        }
        stop.end();
        System.out.println(stop.getElapsedTime());
    }
}
