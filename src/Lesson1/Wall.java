package Lesson1;

public class Wall implements Obstacles {
    static int heightWall;

    public Wall(int height) {
        this.heightWall = height;
    }

    public static int getHeightWall() {
        return heightWall;
    }

    public void setHeightWall(int heightWall) {
        this.heightWall = heightWall;
    }

    private String wallHeight () {
        return "Высота стены " + heightWall + " метра.";
    }
//    private void climbedWall () {
//        System.out.println("Перелез через стену!");
//    }

    @Override
    public boolean overcomeObstacle(GeneralClass generalClasses) {
        if (generalClasses.jump() >= heightWall) {
            System.out.println(generalClasses + " перепрыгнул через стену высотой " + heightWall + " метра(ов)!");
            return true;
        }
        else {
            generalClasses.notJump();
            System.out.println(generalClasses + " не перепрыгнул стену высотой " + heightWall + " метра(ов)!");
            return false;
        }
    }
}
