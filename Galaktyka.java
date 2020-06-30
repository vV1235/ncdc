public class Galaktyka {
    private static final String starSpace = "* ";
    private static final String spaceStar = " *";
    private static final String star      =  "*";
    private static final String space     =  " ";

    private static void checkInput(String arg0) {
        char direction = arg0.charAt(1);
        switch(direction) {
            case 'W':
            case 'E':
            case 'N':
            case 'S':
                break;
            default:
                System.out.print("klops");
                System.exit(0);
        }
        int galaxyLen = Character.getNumericValue(arg0.charAt(0));
        if(galaxyLen < 1 || galaxyLen > 10000) {
            System.out.print("klops");
            System.exit(0);
        }
    }

    private static int lightYears(final int in) {
        int adder = 3;
        int result = 3;
        for(int i = 0; i < in - 1; i++) {
            result += adder;
            adder++;
        }
        return result;
    }

    private static void galaxy(final int in, final char dir) {
        StringBuilder[] galaxy;
        if(in % 4 == 2) {
            galaxy = new StringBuilder[in + 3];
            for (int i = 0; i < galaxy.length; i++) {
                galaxy[i] = new StringBuilder();
            }
            galaxy[0].append(star.repeat(in + 2));
            galaxy[0].append("\n");
            galaxy[1].append(space.repeat(in + 1));
            galaxy[1].append(star);
            galaxy[1].append("\n");
            for (int i = 2, l = 0, r = 1; l < (in / 4); i += 2, l++, r++) {
                galaxy[i].append(starSpace.repeat(l));
                galaxy[i].append(star.repeat(in - l * 4));
                galaxy[i].append(spaceStar.repeat(r));
                galaxy[i].append("\n");
                galaxy[i + 1].append(starSpace.repeat(l + 1));
                galaxy[i + 1].append(space.repeat(in - (l + 1) * 4));
                galaxy[i + 1].append(spaceStar.repeat(r + 1));
                galaxy[i + 1].append("\n");
            }
            galaxy[in / 2 + 1].append(starSpace.repeat(in / 4));
            galaxy[in / 2 + 1].append(star.repeat(2));
            galaxy[in / 2 + 1].append(spaceStar.repeat((in / 4) + 1));
            galaxy[in / 2 + 1].append("\n");
            for (int i = in / 2 + 2, s = (in / 4); i < galaxy.length; i += 2, s--) {
                galaxy[i].append(starSpace.repeat(s + 1));
                galaxy[i].append(space.repeat(in - ((s + 1) * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s + 1));
                galaxy[i].append("\n");
                galaxy[i + 1].append(starSpace.repeat(s));
                galaxy[i + 1].append(star.repeat(in - (s * 4 - 2)));
                galaxy[i + 1].append(spaceStar.repeat(s));
                galaxy[i + 1].append("\n");
            }
        } else if(in % 4 == 0) {
            galaxy = new StringBuilder[in + 3];
            for (int i = 0; i < galaxy.length; i++) {
                galaxy[i] = new StringBuilder();
            }
            galaxy[0].append(star.repeat(in + 2));
            galaxy[0].append("\n");
            galaxy[1].append(space.repeat(in + 1));
            galaxy[1].append(star);
            galaxy[1].append("\n");
            for(int i = 2, l = 0, r = 1; l < (in / 4); i+=2, l++, r++) {
                galaxy[i].append(starSpace.repeat(l));
                galaxy[i].append(star.repeat(in - l * 4));
                galaxy[i].append(spaceStar.repeat(r));
                galaxy[i].append("\n");
                galaxy[i + 1].append(starSpace.repeat(l + 1));
                galaxy[i + 1].append(space.repeat(in - (l + 1) * 4));
                galaxy[i + 1].append(spaceStar.repeat(r + 1));
                galaxy[i + 1].append("\n");
            }
            for(int i = in / 2 + 2, s = (in / 4); i < galaxy.length; i+=2, s--) {
                galaxy[i].append(starSpace.repeat(s));
                galaxy[i].append(star.repeat(in - (s * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s));
                galaxy[i].append("\n");
            }
            for(int i = in / 2 + 3, s = (in / 4); i < galaxy.length; i+=2, s--) {
                galaxy[i].append(starSpace.repeat(s));
                galaxy[i].append(space.repeat(in - (s * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s));
                galaxy[i].append("\n");
            }
        } else if(in % 4 == 1) {
            galaxy = new StringBuilder[in + 3];
            for (int i = 0; i < galaxy.length; i++) {
                galaxy[i] = new StringBuilder();
            }
            galaxy[0].append(star.repeat(in + 2));
            galaxy[0].append("\n");
            galaxy[1].append(space.repeat(in + 1));
            galaxy[1].append(star);
            galaxy[1].append("\n");
            for(int i = 2, l = 0, r = 1; l < (in / 4) + 1; i+=2, l++, r++) {
                galaxy[i].append(starSpace.repeat(l));
                galaxy[i].append(star.repeat(in - l * 4));
                galaxy[i].append(spaceStar.repeat(r));
                galaxy[i].append("\n");
            }
            for(int i = 3, l = 1, r = 2; l < (in / 4) + 1; i+=2, l++, r++) {
                galaxy[i].append(starSpace.repeat(l));
                galaxy[i].append(space.repeat(in - (l * 4)));
                galaxy[i].append(spaceStar.repeat(r));
                galaxy[i].append("\n");
            }
            for(int i = in / 2 + 3, s = (in / 4); i < galaxy.length; i+=2, s--) {
                galaxy[i].append(starSpace.repeat(s));
                galaxy[i].append(star.repeat(in - (s * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s));
                galaxy[i].append("\n");
            }
            for(int i = in / 2 + 4, s = (in / 4); i < galaxy.length - 1; i+=2, s--) {
                galaxy[i].append(starSpace.repeat(s));
                galaxy[i].append(space.repeat(in - (s * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s));
                galaxy[i].append("\n");
            }
        } else {
            galaxy = new StringBuilder[in + 3];
            for (int i = 0; i < galaxy.length; i++) {
                galaxy[i] = new StringBuilder();
            }
            galaxy[0].append(star.repeat(in + 2));
            galaxy[0].append("\n");
            galaxy[1].append(space.repeat(in + 1));
            galaxy[1].append(star);
            galaxy[1].append("\n");
            for(int i = 2, l = 0, r = 1; l < (in / 4) + 1; i+=2, l++, r++) {
                galaxy[i].append(starSpace.repeat(l));
                galaxy[i].append(star.repeat(in - l * 4));
                galaxy[i].append(spaceStar.repeat(r));
                galaxy[i].append("\n");
            }
            for(int i = 3, l = 1, r = 2; l < (in / 4) + 1; i+=2, l++, r++) {
                galaxy[i].append(starSpace.repeat(l));
                galaxy[i].append(space.repeat(in - (l * 4)));
                galaxy[i].append(spaceStar.repeat(r));
                galaxy[i].append("\n");
            }
            for(int i = (in / 2) + 3, s = (in / 4) + 1; i < galaxy.length; i+=2, s--) {
                galaxy[i].append(starSpace.repeat(s));
                galaxy[i].append(space.repeat(in - (s * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s));
                galaxy[i].append("\n");
            }
            for(int i = (in / 2) + 2, s = (in / 4) + 1; i < galaxy.length; i+=2, s--) {
                galaxy[i].append(starSpace.repeat(s));
                galaxy[i].append(star.repeat(in - (s * 4 - 2)));
                galaxy[i].append(spaceStar.repeat(s));
                galaxy[i].append("\n");
            }
        }
        switch(dir) {
            case 'E':
                galaxy[galaxy.length - 1].deleteCharAt(in + 2);
                for(int i = galaxy.length - 1; i >= 0; i--) {
                    System.out.print(galaxy[i].reverse());
                }
                break;
            case 'W':
                galaxy[galaxy.length - 1].deleteCharAt(in + 2);
                for (StringBuilder i: galaxy) {
                    System.out.print(i);
                }
                break;
            default:
                StringBuilder[] arr2;
                arr2 = new StringBuilder[in + 2];
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = new StringBuilder();
                }
                for(int i = 0; i < arr2.length; i++) {
                    for(int j = galaxy.length - 1; j >= 0; j--) {
                        arr2[i].append(galaxy[j].charAt(i));
                    }
                    arr2[i].append("\n");
                }
                if(dir == 'N') {
                    arr2[arr2.length - 1].deleteCharAt(in + 3);
                    for (StringBuilder i: arr2) {
                        System.out.print(i);
                    }
                } else {
                    arr2[arr2.length - 1].deleteCharAt(in + 3);
                    for (int i = arr2.length - 1; i >= 0; i--) {
                        System.out.print(arr2[i].reverse());
                    }
                }
                break;
        }
    }

    public static void main(String args[]) {
        checkInput(args[0]);
        int in = Character.getNumericValue(args[0].charAt(0));
        char dir = args[0].charAt(1);
        galaxy(in, dir);
        System.out.print("\n" + lightYears(in));
    }
}