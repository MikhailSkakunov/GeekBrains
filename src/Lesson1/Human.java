package Lesson1;

public class Human implements GeneralClass {
    private static String name;
    private static int climbHeightHuman;
    private int runDistanceHuman;


    public Human(String name, int climbHeightHuman, int runDistanceHuman) {
        this.name = name;
        this.climbHeightHuman = climbHeightHuman;
        this.runDistanceHuman = runDistanceHuman;
    }

    @Override
    public String toString() {
        return "Человек " + name;
    }

    public static int getClimbHeightHuman() {
        return climbHeightHuman;
    }

    public void setClimbHeightHuman(int climbHeightHuman) {
        this.climbHeightHuman = climbHeightHuman;
    }

    public int getRunDistanceHuman() {
        return runDistanceHuman;
    }

    public void setRunDistanceHuman(int runDistanceHuman) {
        this.runDistanceHuman = runDistanceHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void notJump () {
        System.out.println("Меня зовут -" + name + " Я - человек. Мне не перепрыгнуть через эту стену выстой " + Wall.getHeightWall());
    }

    public void notRun () {
        System.out.println("Я - " + name + " Я человек. Мне не пробежать расстояние в" + Treadmill.getTreadmill() + " метра(ов)!");
    }

        @Override
    public int jump() {
        System.out.println("Я человек. Меня зовут - " + name + "." + " Я смогу перепрыгнуть стену высотой " + Wall.getHeightWall() + " метра(ов)!");
        return Wall.getHeightWall();
    }
     @Override
    public int run() {
        System.out.println("Я с легкостью пробегу " + Treadmill.getTreadmill() + " метра(ов)!");
      return Treadmill.getTreadmill();
    }



}
