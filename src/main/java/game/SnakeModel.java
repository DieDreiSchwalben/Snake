package game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SnakeModel {

    private List<Integer[]> snakeBody = new ArrayList<>();

    private boolean foundEgg = false;

    private int cols;
    private int rows;

    public SnakeModel(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    public void startGame() throws InterruptedException {
        Integer[] head = {1, rows/2};
        Integer[] body = {0, rows/2};
        snakeBody.add(head);
        snakeBody.add(body);

        gameLoop();
    }

    public void gameLoop() throws InterruptedException {
        while(true) {
            TimeUnit.MILLISECONDS.sleep(1000);

            System.out.println("Before size=" + snakeBody.size() + " / COL (head) = " +snakeBody.get(0)[0] + " / COL (body) = " + snakeBody.get(1)[0]);

            // Remove tail
            System.out.println("Removing at: " + snakeBody.get(snakeBody.size() - 1)[0]);

            if(foundEgg) {
                snakeBody.remove(snakeBody.size() - 1);
                foundEgg = false;
            }

            System.out.println("New size=" + snakeBody.size() + " - COL (old head -> new body) = " + snakeBody.get(0)[0]);

            // Calculate and add new head
            Integer[] headcut = {0,0};
            headcut[0] = snakeBody.get(0)[0] + 1;
            headcut[1] = snakeBody.get(0)[1];

            // Add calculated head position
            snakeBody.add(0, headcut);
            System.out.println("Added at COL: " + snakeBody.get(1)[0]);

            System.out.println("After size=" + snakeBody.size() + " / COL (head) = " +snakeBody.get(0)[0] + " / COL (body) = " + snakeBody.get(1)[0]);

        }
    }
}
