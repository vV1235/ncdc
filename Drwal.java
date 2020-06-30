import java.util.ArrayList;
import java.util.Scanner;

//www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
//https://en.wikipedia.org/wiki/Flood_fill
public class Drwal {
    /*orientacja na dla algorytmy: czyli wejsciowy x to moj y a wejsciowy y to moj x
     ------> y
    |
    |
    |
    \/
    x
     */
    //prevC - co ma zostac zamienione, newC - czym ma zostac zamienione
    private static void floodFillUtil(char screen[][], int x, int y, char prevC, char newC, int M, int N) {
        if(x < 0 || x >= M || y < 0 || y >= N) {
            //System.out.println("klops bo x < 0 || x >= M || y < 0 || y >= N");
            return;
        }
        if(screen[x][y] != prevC) {
            //System.out.println("screen[x][y]: " + screen[x][y] + x + y + " != prevC: '" + prevC + "'");
            return;
        }
        screen[x][y] = newC;

        //Call for N, E, S, W
        floodFillUtil(screen, x + 1, y,     prevC, newC, M, N);
        floodFillUtil(screen, x - 1, y,     prevC, newC, M, N);
        floodFillUtil(screen,    x,  y + 1, prevC, newC, M, N);
        floodFillUtil(screen,    x,  y - 1, prevC, newC, M, N);
    }

    private static void floodFill(char screen[][], int x, int y, char newC, int M, int N) {
        char prevC = screen[x][y];
        floodFillUtil(screen, x, y, prevC, newC, M, N);
    }

    private static void displayMatrix(char[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tmp = new ArrayList<>();
        while(scanner.hasNextLine()) {
            tmp.add(scanner.nextLine());
        }
        char mat[][] = new char[tmp.size()][];
        mat[0] = tmp.get(0).stripTrailing().toCharArray();
        for(int i = 0; i < tmp.size(); i++) {
            mat[i] = tmp.get(i).stripTrailing().toCharArray();
        }
        return mat;
    }

    private static void checkInput(int xStart, int yStart, int szerokosc, int wysokosc) {
        if(szerokosc < 0 || szerokosc > 50 || wysokosc < 0 || wysokosc > 50 || xStart > wysokosc || yStart > szerokosc) {
            System.out.print("klops");
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        /*
        x = yStart, y = xStart
        int xStart    = Integer.parseInt(args[0]);
        int yStart    = Integer.parseInt(args[1]);
        char kolor    = args[2].charAt(0);
        int szerokosc = Integer.parseInt(args[3]);
        int wysokosc   = Integer.parseInt(args[4]);*/
        checkInput(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        char[][] mat = createMatrix();
        floodFill(mat, Integer.parseInt(args[1]), Integer.parseInt(args[0]), args[2].charAt(0), Integer.parseInt(args[4]), Integer.parseInt(args[3]));
        displayMatrix(mat);
    }
}
