package Lesson1;

public class Cat implements GeneralClass {
    private String nameCat;
    private int climbHeightCat;
    private int runDistanceCat;

    public Cat(String nameCat, int climbHeightCat, int runDistanceCat) {
        this.nameCat = nameCat;
        this.climbHeightCat = climbHeightCat;
        this.runDistanceCat = runDistanceCat;
    }

    @Override
    public String toString() {
        return "Кот " + nameCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public int getClimbHeightCat() {
        return climbHeightCat;
    }

    public void setClimbHeightCat(int climbHeightCat) {
        this.climbHeightCat = climbHeightCat;
    }

    public int getRunDistanceCat() {
        return runDistanceCat;
    }

    public void setRunDistanceCat(int runDistanceCat) {
        this.runDistanceCat = runDistanceCat;
    }
    public void notJump () {
        System.out.println("Меня зовут -" + nameCat + " Я - кот. Мне не перепрыгнуть через эту стену выстой " + Wall.getHeightWall() + " метра(ов)!");
    }

    public void notRun () {
        System.out.println("Я - " + nameCat + " Я кот. Мне не пробежать расстояние в " + Treadmill.getTreadmill() + " метра(ов)!");
    }

    @Override
    public int jump() {
        System.out.println("Я кот - " + nameCat + " !" + " Я умею прыгать!");
        return climbHeightCat;
    }
    public int run() {
        System.out.println("Я кот - " + nameCat + " Я могу бегать на небольшие расстояния! " + runDistanceCat + " метра(ов)!");
       return runDistanceCat;
    }

}
