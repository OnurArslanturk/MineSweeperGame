import java.util.Scanner;

public class Main {
    static void game(int i, int j){
        String matrix[][] = new String[i][j];
        String showBoard[][] = new String[i][j];
        Scanner inp = new Scanner(System.in);
        int sldi = 0, sldj=0, count = 0;

        // fill whole cells with " - "
        for (int a = 0; a< matrix.length;a++){
            for (int b =0; b< matrix[a].length; b++){
                matrix[a][b] = " - ";
                showBoard[a][b] = " - ";
            }
        }

        // calculate number  of bomb ad number of game turn
        int bombNumber = (int) ((i*j)/4), x = 0, y= 0, gameTurn = ((i*j) -bombNumber);

        // spread the bombs on the array_board
        for (;bombNumber>0;bombNumber--){
            x = (int)(Math.random()*i);
            y = (int)(Math.random()*j);
            if(matrix[x][y] != " * ") matrix[x][y] = " * ";
            else bombNumber ++;
        }

        //print arrays
        toString(matrix);
        toString(showBoard);

        //game starts in this while loop
        while(true) {

            System.out.print("Please enter row index between 0-" + (i - 1) + " and enter column index between 0-" + (j - 1) + " : ");

            sldi = inp.nextInt();
            sldj = inp.nextInt();

            if (sldi<=i-1 && sldj<=j-1) {

                //Game over condition
                if (matrix[sldi][sldj] == " * ") {
                    System.out.println("========================================================================");
                    System.out.println("========================================================================");
                    System.out.println("                              GAME OVER                                 ");
                    System.out.println("========================================================================");
                    System.out.println("========================================================================");
                    break;
                } else if (showBoard[sldi][sldj] == " - ") {
                    if (sldi - 1 >= 0 && sldj - 1 >= 0) {
                        if (matrix[sldi - 1][sldj - 1] == " * ") count++;
                    }
                    if (sldj - 1 >= 0) {
                        if (matrix[sldi][sldj - 1] == " * ") count++;
                    }
                    if (sldi + 1 < i && sldj - 1 >= 0) {
                        if (matrix[sldi + 1][sldj - 1] == " * ") count++;
                    }
                    if (sldi - 1 >= 0) {
                        if (matrix[sldi - 1][sldj] == " * ") count++;
                    }
                    if (sldi + 1 < i) {
                        if (matrix[sldi + 1][sldj] == " * ") count++;
                    }
                    if (sldi - 1 >= 0 && sldj + 1 < j) {
                        if (matrix[sldi - 1][sldj + 1] == " * ") count++;
                    }
                    if (sldj + 1 < j) {
                        if (matrix[sldi][sldj + 1] == " * ") count++;
                    }
                    if (sldi + 1 < i && sldj + 1 < j) {
                        if (matrix[sldi + 1][sldj + 1] == " * ") count++;
                    }
                    showBoard[sldi][sldj] = " " + count + " ";
                    count = 0;
                    gameTurn--;
                } else System.out.println("You have already try this cell. Make your choice again please..");

                toString(matrix);
                toString(showBoard);
                if (gameTurn == 0) {
                    System.out.println("========================================================================");
                    System.out.println("========================================================================");
                    System.out.println("               Congratulations!!! You won the game.........             ");
                    System.out.println("========================================================================");
                    System.out.println("========================================================================");
                    break;
                }
            }
            else System.out.println("You entered a number out of bounds for length! Try Again");
        }
    }


    static void toString(String array[][]){

        for (String[] row : array){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println("========================================================================");

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Mine Sweeper Game!");
        System.out.println("========================================================================");
        Scanner inp = new Scanner(System.in);
        int j=0, i=0;
        while (true) {
            System.out.print("Number of columns between 2 and 100 : ");
            j = inp.nextInt();
            System.out.print("Number of rows between 2 and 100 : ");
            i = inp.nextInt();
            if (i>1 && j>1 && i<101 && j<101) break;
            else System.out.println("Game board needs to be bigger than 1x1(at least 2x2) and smaller than 101x101(max 100x100)");
        }
        game(i, j);
    }
}

//https://app.patika.dev/onurarslanturk
//https://github.com/OnurArslanturk?tab=repositories
//https://www.hackerrank.com/onur_arslanturk
//www.patika.dev
