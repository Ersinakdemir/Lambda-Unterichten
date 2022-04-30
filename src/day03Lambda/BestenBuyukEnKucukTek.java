package day03Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BestenBuyukEnKucukTek {
    public static void main(String[] args) {
        List<Integer> sayi =new ArrayList<>(Arrays.asList(3,2,6,11,-5,20,6,21,-8,8,15));
        bestenBuyukEnKucukTek(sayi);
    }
    //Task: Listede 5 ten buyuk En kucuk Tek sayiyi print ediniz
    public static void bestenBuyukEnKucukTek(List<Integer> sayi){
       int bestenBuyukEnKucukTek= sayi.stream().filter(t->t>5).filter(t->t%2==1).reduce(Integer.MAX_VALUE,(x, y)->x<y?x:y);
        System.out.println(bestenBuyukEnKucukTek);
       Optional<Integer> bestenBuyukEnKucukTekMetRef= sayi.stream().filter(t->t>5).filter(t->t%2==1).reduce(C01EnKucuk4FarkliSekil::minBul);
        System.out.println(bestenBuyukEnKucukTekMetRef);
    }
}
