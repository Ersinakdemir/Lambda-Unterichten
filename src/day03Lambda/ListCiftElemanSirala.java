package day03Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListCiftElemanSirala {
    public static void main(String[] args) {
        List<Integer> sayi =new ArrayList<>(Arrays.asList(3,2,6,11,-5,20,6,21,-8,8,15));
        ciftKareKucuktenBuyugesirala(sayi);
        System.out.println("\n     *****          ");
        tekKareBuyukKucukSirala(sayi);
    }
    //List'in cift elemanlarinin karelerini kucukten buyuge print ediniz
    public static void ciftKareKucuktenBuyugesirala(List<Integer> sayi){
        sayi.
                stream().
                filter(ListCiftElemanSirala::ciftSayiBul).
                map(t->t*t).
                sorted().forEach(ListCiftElemanSirala::yazdir);//karesi alinan elemanlar dogal(K->B) siralandi
    }
    public static boolean ciftSayiBul(int a){
        return a%2==0;
    }

    public static void yazdir(int a){//Yazdirma actionu yapan seed(tohum)
        System.out.print(a+" ");
    }
    //Listen tek elemanlarinin karelerini büyükten kücüge siralayiniz
    public static void tekKareBuyukKucukSirala(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t % 2 == 1).
                map(t -> t * t).
                sorted(Comparator.reverseOrder()).////karesi alinan elemanlar dogal degil ters(B->K) siralandi
                forEach(ListCiftElemanSirala::yazdir);//yazdirilmis
    }
}
