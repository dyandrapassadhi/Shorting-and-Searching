/*
Dyandra Naresuan Vaisaka Passadhi
255150707111030
Teknologi Informasi - B
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Pemain {
    int tinggi;
    int berat;
    String tim;

    public Pemain(int tinggi, int berat, String tim) {
        this.tinggi = tinggi;
        this.berat = berat;
        this.tim = tim;
    }

    @Override
    public String toString() {
        return String.format("Tinggi: %d cm, Berat: %d kg [%s]", tinggi, berat, tim);
    }
}

public class Futsal1 {
    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
            new Pemain(168, 50, "Tim A"), new Pemain(170, 60, "Tim A"),
            new Pemain(165, 56, "Tim A"), new Pemain(168, 55, "Tim A"),
            new Pemain(175, 60, "Tim A"), new Pemain(170, 70, "Tim A"),
            new Pemain(169, 66, "Tim A"), new Pemain(165, 56, "Tim A"),
            new Pemain(168, 72, "Tim A"), new Pemain(169, 56, "Tim A")
        ));

        List<Pemain> timB = new ArrayList<>(Arrays.asList(
            new Pemain(170, 66, "Tim B"), new Pemain(177, 60, "Tim B"), 
            new Pemain(165, 59, "Tim B"), new Pemain(166, 58, "Tim B"),
            new Pemain(168, 58, "Tim B"), new Pemain(172, 71, "Tim B"),
            new Pemain(172, 68, "Tim B"), new Pemain(171, 68, "Tim B"),
            new Pemain(171, 65, "Tim B"), new Pemain(166, 60, "Tim B")
        ));

        List<Pemain> semuaPemain = new ArrayList<>();
        semuaPemain.addAll(timA);
        semuaPemain.addAll(timB);

        System.out.println("=== SORTING ===");
        
        Collections.sort(semuaPemain, new Comparator<Pemain>() {
            @Override
            public int compare(Pemain p1, Pemain p2) {
                return p1.tinggi - p2.tinggi;
            }
        });
        System.out.println("\nSorting Tinggi Badan (Ascending):");
        for (Pemain p : semuaPemain) System.out.println(p);

        Collections.sort(semuaPemain, new Comparator<Pemain>() {
            @Override
            public int compare(Pemain p1, Pemain p2) {
                return p2.berat - p1.berat; 
            }
        });
        System.out.println("\nSorting Berat Badan (Descending):");
        for (Pemain p : semuaPemain) System.out.println(p);


        System.out.println("\n=== MAX & MIN ===");
        
        Comparator<Pemain> compTinggi = (p1, p2) -> p1.tinggi - p2.tinggi;
        Comparator<Pemain> compBerat = (p1, p2) -> p1.berat - p2.berat;

        System.out.println("Tim A:");
        System.out.println("  Tinggi Max: " + Collections.max(timA, compTinggi).tinggi + " cm");
        System.out.println("  Tinggi Min: " + Collections.min(timA, compTinggi).tinggi + " cm");
        System.out.println("  Berat Max : " + Collections.max(timA, compBerat).berat + " kg");
        System.out.println("  Berat Min : " + Collections.min(timA, compBerat).berat + " kg");

        System.out.println("Tim B:");
        System.out.println("  Tinggi Max: " + Collections.max(timB, compTinggi).tinggi + " cm");
        System.out.println("  Tinggi Min: " + Collections.min(timB, compTinggi).tinggi + " cm");
        System.out.println("  Berat Max : " + Collections.max(timB, compBerat).berat + " kg");
        System.out.println("  Berat Min : " + Collections.min(timB, compBerat).berat + " kg");


        System.out.println("\n=== COPY TIM ===");
        
        List<Pemain> timC = new ArrayList<>(Arrays.asList(new Pemain[timB.size()]));
        
        Collections.copy(timC, timB);
        
        System.out.println("Berhasil menyalin Tim B ke Tim C. Isi Tim C baru:");
        for (Pemain p : timC) System.out.println(p);
    }
}
