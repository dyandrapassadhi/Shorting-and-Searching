import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Futsal2 {
    public static void main(String[] args) {
        List<Integer> tinggiTimB = new ArrayList<>(Arrays.asList(170, 167, 165, 166, 168, 172, 172, 171, 171, 166));
        List<Integer> beratTimA = new ArrayList<>(Arrays.asList(50, 60, 56, 55, 60, 70, 66, 56, 72, 56));

        System.out.println("=== BINARY SEARCH ===");

        Collections.sort(tinggiTimB);
        Collections.sort(beratTimA);

        cariJumlahPemain(tinggiTimB, 168, "Tinggi Badan (Tim B)");
        cariJumlahPemain(tinggiTimB, 160, "Tinggi Badan (Tim B)");

        cariJumlahPemain(beratTimA, 56, "Berat Badan (Tim A)");
        cariJumlahPemain(beratTimA, 53, "Berat Badan (Tim A)");


        System.out.println("\n=== DISJOINT CHECK ===");

        List<String> atributTimA = Arrays.asList(
            "168_50", "170_60", "165_56", "168_55", "175_60", "170_70", "169_66", "165_56", "168_72", "169_56"
        );
        List<String> atributTimB = Arrays.asList(
            "170_66", "167_60", "165_59", "166_58", "168_58", "172_71", "172_68", "171_68", "171_65", "166_60"
        );

        boolean tidakAdaYangSama = Collections.disjoint(atributTimA, atributTimB);

        if (tidakAdaYangSama) {
            System.out.println("Hasil: Tidak ada pemain di Tim A yang memiliki tinggi DAN berat badan yang sama dengan pemain di Tim B.");
        } else {
            System.out.println("Hasil: Ada pemain yang memiliki kesamaan data di antara kedua tim!");
        }
    }

    private static void cariJumlahPemain(List<Integer> list, int key, String label) {
        int index = Collections.binarySearch(list, key);
        
        if (index >= 0) {
            int jumlah = Collections.frequency(list, key);
            System.out.printf("Pencarian %s untuk nilai %d: Ditemukan! Jumlah pemain = %d\n", label, key, jumlah);
        } else {
            System.out.printf("Pencarian %s untuk nilai %d: Tidak Ditemukan (Hasil pencarian: %d)\n", label, key, index);
        }
    }
}