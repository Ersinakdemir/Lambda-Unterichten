package LambdaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KarakterSayisinaGöreKucukBuyuk {
    public static void main(String[] args) {
        List<String> menu =new ArrayList<>(Arrays.asList("küsleme","adana","trilece","havucDilimi","trilece","buryan","trilece","yaglama",
                "kokorec","arabasi","guvec"));
        KarakterSayisinaGöreKucukBuyuk(menu);
        System.out.println("\n     *****          ");
        charSayiskucukBuy(menu);
        System.out.println("\n     *****          ");
        sonHarfineGoreTers(menu);
    }
    //Listenin elemanlarini karakter sayisina göre kücük ten büyüge tekrarsiz siralayin
    public static void KarakterSayisinaGöreKucukBuyuk(List<String> yemek){
        yemek.
                stream().   //Akis
               // map(t->t.length()).    //karakter sayisi
                map(String::length).    // karakter sayisi
                sorted(Comparator.reverseOrder()).   //tersten sirala
                distinct().        //Benzersiz yap
                forEach(t->System.out.print(t+" "));  //yazdir
    }
    //List elemanlarini charekter sayisina göre kücükten büyüge siralayin
    public static void charSayiskucukBuy(List<String> menu){
        menu.
                stream().    //akis
                sorted(Comparator.    //siralar methodunun icin de karsilastirma sinifindan
                        comparing(String::length)).     //uzunluga göre siralayan siraladik
                forEach(t->System.out.print(t +" "));  //
    }
    //List elemanlarinin son harfine göre ters sirali print edinitz
    public static void sonHarfineGoreTers(List<String> menu){
        menu.
                stream().
                sorted(Comparator.
                        comparing(t->t.toString().
                            charAt(t.toString().length()-1)).
                        reversed()).
                forEach(t->System.out.print(t+" "));
    }
}
