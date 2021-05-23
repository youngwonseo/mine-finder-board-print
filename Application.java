package io.app;

public class Application {
    private final int NUM_OF_MINE = 10;
    private final int WIDTH = 10;
    private final int HEIGHT = 10;


    char[][] board = new char[HEIGHT][WIDTH];

    public Application initMine() {

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                board[y][x] = '0';
            }
        }

        for (int i = 0; i < NUM_OF_MINE; i++) {
            int x = (int) (Math.random() * WIDTH),
                    y = (int) (Math.random() * HEIGHT);

            if (board[y][x] == '@') {
                i--;
                continue;
            }

            board[y][x] = '@';

            // 주위 칸들 카운트
            for (int h = -1; h <= 1; h++) {
                for (int w = -1; w <= 1; w++) {
                    if (h == 0 && w == 0) {
                        continue;
                    }

                    if (isValidPos(x + w, y + h) && board[y + h][x + w] != '@') {
                        board[y + h][x + w] += 1;
                    }
                }
            }
        }
        return this;
    }

    private boolean isValidPos(int x, int y) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) return false;

        return true;
    }


    public void print() {
        for (int h = 0; h < HEIGHT; h++) {
            System.out.println("");
            for (int w = 0; w < WIDTH; w++) {
                System.out.print(" " + board[h][w] + " ");
            }
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        new Application().initMine().print();
    }
}
