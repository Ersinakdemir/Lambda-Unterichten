package LambdaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StringList {
    public static void main(String[] args) {
        List<String>menu =new ArrayList<>(Arrays.asList("küsleme","adana","trilece","havucDilimi","trilece","buryan","trilece","yaglama",
                "kokorec","arabasi","guvec"));
        alfBuyukHarfTekrarsizPrint(menu);
        System.out.println("\n     *****          ");
    }
    //List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz.
    public static void alfBuyukHarfTekrarsizPrint( List<String>yemek ){
        //1- yol
        yemek.
                stream().                    //Akisa girdi
                map(t->t.toUpperCase(Locale.ROOT)).  //elemanlar buyuk harf yapildi
                sorted().                 //alfabetik natural siraya getirildi
                distinct().            //benzesir tekrarsiz hale getirildi
                forEach(t->System.out.print(t+" "));  //print edildi

        System.out.println("\n     *****          ");

        //2- yol
        yemek.
                stream().                    //Akisa girdi
                map(String::toUpperCase).  //elemanlar buyuk harf yapildi
                sorted().                 //alfabetik natural siraya getirildi
                distinct().            //benzesir tekrarsiz hale getirildi
                forEach(t->System.out.print(t+" "));  //print edildi
    }
}
