package Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnyMatch {
    public static void main(String[] args) {
        List<String> menu =new ArrayList<>(Arrays.asList("küsleme","adana","trilecex","havucDilimi","trilece","buryan","trilece","yaglama",
                "kokorec","arabasi","guvec"));
        wIleBaslayanElKont(menu);
        xIleBitenElKont(menu);
    }
    //Task : elemanöarin "w"ile baslamasini kontrol ediniz
    public static void wIleBaslayanElKont(List<String> menu){
        System.out.println(menu.
                stream().
                noneMatch(t->t.startsWith("w"))? "W ile baslayan yemek yok":"W ile baslayan var"); //noneMatch hic yok mu
    }
    public static void xIleBitenElKont(List<String> menu){
        System.out.println(menu.
                stream().
                anyMatch(t->t.endsWith("x"))? "x ile biten yemek var":"x ile biten yok"); //anyMatch hic var mi
    }


}
