package Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class allMatch {
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("küsleme", "adana", "trilece", "havucDilimi", "trilece", "buryan", "trilece", "yaglama",
                "kokorec", "arabasi", "guvec"));

// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    }
        public static void harfSayisi7denAzKontrol( List<String>menu) {
//amele code
            System.out.println("amele code");
            boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
            if (kontrol) {
                System.out.println("list elemanları 7 ve daha az harften olusuyor");
            } else System.out.println("list elemanları 7 harften  buyuk");
//cincix code
            System.out.println("cincix code");
            System.out.println(menu.
                    stream().
                    allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" :
                    "list elemanları 7 harften  buyuk");
    }

}

