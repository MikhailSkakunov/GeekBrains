package Lesson1;

public class Robot implements GeneralClass {
    private String robotName;
    private int climbHeightRobot;
    private int runDistanceRobot;

    @Override
    public String toString() {
        return "Робот " + robotName;
    }

    public Robot(String robotName, int climbHeightRobot, int runDistanceRobot) {
        this.robotName = robotName;
        this.climbHeightRobot = climbHeightRobot;
        this.runDistanceRobot = runDistanceRobot;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public int getClimbHeightRobot() {
        return climbHeightRobot;
    }

    public void setClimbHeightRobot(int climbHeightRobot) {
        this.climbHeightRobot = climbHeightRobot;
    }

    public int getRunDistanceRobot() {
        return runDistanceRobot;
    }

    public void setRunDistanceRobot(int runDistanceRobot) {
        this.runDistanceRobot = runDistanceRobot;
    }

    public void notJump () {
        System.out.println("Меня зовут -" + robotName + " Я - робот. Мне не перепрыгнуть через эту стену выстой " + Wall.getHeightWall() + " метра(ов)!");
    }

    public void notRun () {
        System.out.println("Я робот - " + robotName + " Мне не пробежать расстояние в " + Treadmill.getTreadmill() + " метра(ов)!");
    }

@Override
    public int jump() {
        System.out.println("Я - " + robotName + " Я робот - " + robotName + " Я могу перепрыгнуть стену высотой " + climbHeightRobot + " метра(ов)!");
    return climbHeightRobot;
}
    public int run() {
        System.out.println("Я робот - " + robotName + " Я с легкостью пробегу " + runDistanceRobot + " метра(ов)!");
        return runDistanceRobot;
    }
}
