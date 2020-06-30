/* 1. Każdy program musi się zakończyć kodem 0.
   2. Wielkość liter w danych wejściowych i wynikach jest istotna.
   3. Każdy program powinien być odporny na błędne dane wejściowe i - o ile nie zaznaczono inaczej - w przypadku błędnych danych wejściowych,
      program powinien wypisać słowo "klops" (bez cudzysłowu).
   4. STDIN pojawia się w opisach zadań nieprzypadkowo
 */

/*
   1. rozmiar rakiety może przyjmować wartości numeryczne od 1 do 75
   2. pancerz może przyjmować wartości Y lub N (odpowiednio dla włączonego lub wyłączonego pancerza)
 */

public class Kosmolot {
    private static void checkInput(String arg0, String arg1) {
        switch(arg1) {
            case "N":
            case "Y":
                break;
            default:
                System.out.print("klops");
                System.exit(0);
        }
        if(Integer.parseInt(arg0) < 1 || Integer.parseInt(arg0) > 75) {
            System.out.print("klops");
            System.exit(0);
        }
    }

    public static StringBuilder createLine(final int starCnt, final int spaceCnt) {
        final int len = starCnt + spaceCnt;
        StringBuilder baseSb = new StringBuilder(len);
        StringBuilder finalSbString = new StringBuilder((len * len) + 1);
        baseSb.append("*".repeat(Math.max(0, starCnt)));
        baseSb.append(" ".repeat(Math.max(0, spaceCnt)));
        finalSbString.append(String.valueOf(baseSb).repeat(Math.max(0, len)));
        finalSbString.append('\n');
        return finalSbString;
    }

    public static void addStars(StringBuilder sb, int ind, int n) {
        for(int i = ind; i < sb.length() - 1; i += n) {
            sb.setCharAt(i, '*');
        }
    }
    public static void addSpaces(StringBuilder sb, int ind, int n) {
        for(int i = ind; i < sb.length(); i += n) {
            sb.setCharAt(i, ' ');
        }
    }

    public static void unShielded(int len) {
        StringBuilder line = createLine(1, len - 1);
        for (int i = 0; i < len; i++) {
            System.out.print(line);
            addStars(line, i + 1, len);
        }
        for (int i = len; i > 0; i--) {
            addSpaces(line, i - 1, len);
            System.out.print(line);
        }
    }

    public static StringBuilder genFirstSeg(final int charLen, final int segLen, final String slashVal) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(">");
        tmp.append("*".repeat(Math.max(0, charLen - 2)));
        if(charLen > 1) {
            tmp.append(slashVal);
        }
        tmp.append(" ".repeat(Math.max(0, segLen - charLen)));
        return tmp;
    }

    public static StringBuilder genBaseSeg(final int charLen, final int segLen, final String slashVal) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("*".repeat(Math.max(0, charLen - 1)));
        tmp.append(slashVal);
        tmp.append(" ".repeat(Math.max(0, segLen - charLen)));
        return tmp;
    }

    public static StringBuilder genTop(final int len) {
        StringBuilder firstSeg;
        StringBuilder baseSeg;
        StringBuilder tmp = new StringBuilder();
        tmp.ensureCapacity(len * (len - 1));
        for(int j = 1; j < len; j++) {
            firstSeg = genFirstSeg(j, len, "\\");
            baseSeg = genBaseSeg(j, len, "\\");
            tmp.append(firstSeg);
            tmp.append(String.valueOf(baseSeg).repeat(len - 1));
            tmp.append("\n");
        }
        return tmp;
    }

    public static StringBuilder genMid(final int len) {
        StringBuilder tmp = new StringBuilder();
        tmp.ensureCapacity(len * len);
        tmp.append(">");
        tmp.append("*".repeat(Math.max(0, len * len - 2)));
        tmp.append(">\n");
        return tmp;
    }

    public static StringBuilder genBottom(final int len) {
        StringBuilder firstSeg;
        StringBuilder baseSeg;
        StringBuilder tmp = new StringBuilder();
        tmp.ensureCapacity(len * (len - 1));
        for(int j = len - 1; j > 0; j--) {
            firstSeg = genFirstSeg(j, len, "/");
            baseSeg = genBaseSeg(j, len, "/");
            tmp.append(firstSeg);
            tmp.append(String.valueOf(baseSeg).repeat(Math.max(0, len - 1)));
            tmp.append("\n");
        }
        return tmp;
    }

    public static void shielded(final int len) {
        StringBuilder top = genTop(len);
        StringBuilder mid = genMid(len);
        StringBuilder bottom = genBottom(len);
        System.out.print(top);
        System.out.print(mid);
        System.out.print(bottom);
    }

    public static void main(String args[]) {
        checkInput(args[0], args[1]);
        int len = Integer.parseInt(args[0]);

        switch(args[1]) {
            case "N":
                unShielded(len);
                break;
            case "Y":
                shielded(len);
                break;
        }
    }
}
