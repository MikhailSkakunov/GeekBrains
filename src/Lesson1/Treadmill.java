package Lesson1;

public class Treadmill implements Obstacles {
    static int treadmillLength;

    public Treadmill(int treadmillLength) {
        this.treadmillLength = treadmillLength;
    }

    public static int getTreadmill() {
        return treadmillLength;
    }

    public void setTreadmill(int treadmillLength) {
        this.treadmillLength = treadmillLength;
    }

//    public String treadmillLength () {
//        System.out.println("Длина беговой дорожки " + treadmillLength + " метров.");
//        return  "Длина беговой дорожки " + treadmillLength + " метров.";
//    }

    @Override
    public boolean overcomeObstacle(GeneralClass generalClasses) {
        if (generalClasses.run() >= treadmillLength) {
            System.out.println(generalClasses + " пробежал дистанцию длиной " + treadmillLength + " метра(ов)!");
            return true;
        }
        else {
            generalClasses.notRun();
            System.out.println(generalClasses + " не смог пробежать дистанцию длиной " + treadmillLength + " метра(ов)!");
            return false;
        }
    }
}
