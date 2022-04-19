package ss4_class_and_object.bai_tap.StopWatch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {

    }

    public long getStartTime() {
        return startTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}
