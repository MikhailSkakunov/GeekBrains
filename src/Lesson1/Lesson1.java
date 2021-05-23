package Lesson1;

import java.util.ArrayList;
import java.util.Random;

public class Lesson1 {
    public static void main(String[] args) {

     GeneralGame game = generalAll();
     game.allGeneralClasses();

    }

    private static GeneralGame generalAll() {

        Random random = new Random();

    GeneralClass human = new Human("Виктор", random.nextInt(5), random.nextInt(3000));
    GeneralClass robot = new Robot("Грег", random.nextInt(5),random.nextInt(3000));
    GeneralClass cat = new Cat("Васька", random.nextInt(5), random.nextInt(3000));


     Obstacles wall = new Wall(random.nextInt(5));
     Obstacles treadmill = new Treadmill(random.nextInt(3000));

    GeneralGame game = new GeneralGame();
    game.setGeneralClass(human, robot, cat);
    game.setObstacle(wall, treadmill);

    return game;
    }
}

