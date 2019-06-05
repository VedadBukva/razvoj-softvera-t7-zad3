package ba.unsa.etf.rs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int temp;
        temp = scanner.nextInt();
        while (temp != 0) {
            lista.add(temp);
            temp = scanner.nextInt();
        }

        Comparator c = (Comparator<Integer>) (o1, o2) -> {
            int sumFirst = 0;
            while (o1 != 0) {
                sumFirst += o1  % 10;
                o1 /= 10;
            }

            int sumSecond = 0;
            while (o2 != 0) {
                sumSecond += o2  % 10;
                o2 /= 10;
            }
            return sumFirst - sumSecond;
        };

        ArrayList<Integer> listaStreamApi = (ArrayList<Integer>) lista.stream().sorted(c).collect(Collectors.toList());
        System.out.println("\nSortiran niz uz pomoc stream API:");
        for (int a : listaStreamApi) {
            System.out.print(a + " ");
        }
        int[] niz = new int[2];
        niz[0] = 9;
        niz[1] = 11;
        Arrays.sort(new int[][]{niz}, c);
        for(int a: niz) {
            System.out.print("\n"+a + " ");
        }

    }
}
