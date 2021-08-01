package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

    static boolean gameFinished = false;

    static String[][] grid = { {"_", "_", "_"},
                               {"_", "_", "_"},
                               {"_", "_", "_"} };

    static boolean turn = true;

    public static void drawGrid() {

        System.out.println("\n---------");

        System.out.print("| ");
        System.out.print(grid[0][0] + " ");
        System.out.print(grid[0][1] + " ");
        System.out.print(grid[0][2] + " ");
        System.out.println("|");

        System.out.print("| ");
        System.out.print(grid[1][0] + " ");
        System.out.print(grid[1][1] + " ");
        System.out.print(grid[1][2] + " ");
        System.out.println("|");

        System.out.print("| ");
        System.out.print(grid[2][0] + " ");
        System.out.print(grid[2][1] + " ");
        System.out.print(grid[2][2] + " ");
        System.out.println("|");

        System.out.println("---------");

    }

    public static void start() {

        System.out.println("Welcome to Tic Tac Toe game!\n");

        System.out.println("Coordinates grid: " +
                        "\n(0 0) (0 1) (0 2)" +
                        "\n(1 0) (1 1) (1 2)" +
                        "\n(2 0) (2 1) (2 2)");

        drawGrid();
        game();
    }

    public static void checkResult() {

        boolean xWins =

                        ("X".equals(grid[0][0]) && "X".equals(grid[0][1]) && "X".equals(grid[0][2])) ||
                        ("X".equals(grid[1][0]) && "X".equals(grid[1][1]) && "X".equals(grid[1][2])) ||
                        ("X".equals(grid[2][0]) && "X".equals(grid[2][1]) && "X".equals(grid[2][2])) ||

                        ("X".equals(grid[0][0]) && "X".equals(grid[1][0]) && "X".equals(grid[2][0])) ||
                        ("X".equals(grid[0][1]) && "X".equals(grid[1][1]) && "X".equals(grid[2][1])) ||
                        ("X".equals(grid[0][2]) && "X".equals(grid[1][2]) && "X".equals(grid[2][2])) ||

                        ("X".equals(grid[0][0]) && "X".equals(grid[1][1]) && "X".equals(grid[2][2])) ||
                        ("X".equals(grid[0][2]) && "X".equals(grid[1][1]) && "X".equals(grid[2][0]));


        boolean oWins =

                        ("O".equals(grid[0][0]) && "O".equals(grid[0][1]) && "O".equals(grid[0][2])) ||
                        ("O".equals(grid[1][0]) && "O".equals(grid[1][1]) && "O".equals(grid[1][2])) ||
                        ("O".equals(grid[2][0]) && "O".equals(grid[2][1]) && "O".equals(grid[2][2])) ||

                        ("O".equals(grid[0][0]) && "O".equals(grid[1][0]) && "O".equals(grid[2][0])) ||
                        ("O".equals(grid[0][1]) && "O".equals(grid[1][1]) && "O".equals(grid[2][1])) ||
                        ("O".equals(grid[0][2]) && "O".equals(grid[1][2]) && "O".equals(grid[2][2])) ||

                        ("O".equals(grid[0][0]) && "O".equals(grid[1][1]) && "O".equals(grid[2][2])) ||
                        ("O".equals(grid[0][2]) && "O".equals(grid[1][1]) && "O".equals(grid[2][0]));

        boolean draw = !xWins && !oWins && Arrays.stream(grid).flatMap(Arrays::stream).noneMatch(e -> e.equals("_"));

        if (xWins) {
            System.out.println("\nX wins");
            gameFinished = true;
            return;
        }

        if (oWins) {
            System.out.println("\nO wins");
            gameFinished = true;
            return;
        }

        if (draw) {
            System.out.println("\nDraw");
            gameFinished = true;
        }

    }

    public static void game() {

        while (!gameFinished) {

            if (Arrays.stream(grid).flatMap(Arrays::stream).noneMatch(e -> e.equals("_"))) {
                break;
            }

            String cellValue = turn ? "X" : "O";

            System.out.print("\nPlayer " + cellValue + ", enter the coordinates: ");

            Scanner scanner = new Scanner(System.in);

            String pattern = "[0-2] [0-2]";

            String inputCoordinates = scanner.nextLine();

            if (inputCoordinates.matches(pattern)) {

                String[] coordinates = inputCoordinates.split(" ");

                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (!grid[x][y].equals("X") && !grid[x][y].equals("O")) {

                    grid[x][y] = cellValue;
                    turn = !turn;
                    drawGrid();
                    checkResult();

                } else {

                    System.out.println("This cell is occupied! Choose another one!");

                }

            } else {
                System.out.println("Please use pattern like " +
                        "<x y> for coordinates! Each number should be 0 to 2. For example: 0 1");
            }

        }
    }
}



