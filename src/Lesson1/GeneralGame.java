package Lesson1;

import java.util.ArrayList;

public class GeneralGame {
    private Obstacles[] obstacle;
    private GeneralClass[] generalClasses;

    public void setObstacle (Obstacles... obstacle) {
        this.obstacle = obstacle;
    }
    public void setGeneralClass (GeneralClass... generalClasses) {
        this.generalClasses = generalClasses;
    }

    private boolean overcomeAll (GeneralClass generalClasses) {
        for (Obstacles obstacles : obstacle)
            if (!obstacles.overcomeObstacle(generalClasses))
                return false;
        System.out.println();
        return true;
    }

    ArrayList<GeneralClass> winners = new ArrayList<>();

    public void allGeneralClasses() {
        for (GeneralClass generalClass : generalClasses) {
            boolean passed = overcomeAll(generalClass);
            if (!passed) {
                System.out.println(generalClass +  " не смог пройти препятсвие(я)!" + " Сошел с дистанции!");
            }
            else {
                System.out.println(generalClass + " - Победил!");
                winners.add(generalClass);
            }
            System.out.println();
        }
        for (GeneralClass winner : winners)
        System.out.println("Победителем(ями) стал(и): " + winner);
    }
}
