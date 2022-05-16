package day06_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class ElifPractice {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>(Arrays.asList("Ali","Veli","Deli","Java","ogrenmek" ,"guzel"));
        list.add("Ersin");
        lleriSil( list);
        System.out.println("     *****         ");
        ilkHarfi3kereYaz(list);
    }
    //S4: tüm l leri silip yazdiralim
    public static void lleriSil(List<String> list){
        list.stream().map(t->t.replaceAll("l","")).forEachOrdered(t->System.out.print(t +" "));
    }
    // s5 : icinde e olanlardan yeni bir list olustur


    // s6 :ilk harfini 3 kere tekrar edip yazdiralim örnegin jjjava
    public static void ilkHarfi3kereYaz(List<String> list){
        list.stream().map(t->t.substring(0,1).toLowerCase()+t.substring(0,1).
                toLowerCase()+t.toLowerCase()).forEach(t->System.out.println(t));
    }

        // s7: tüm elemanlarin ilk harfini büyük digerlerini kucuk yazdirin
        public static void timElemanlarinIlkHarfByk(List<String> list){
            list.stream().map(t->t.substring(0,1).toLowerCase()+t.substring(0,1).
                    toLowerCase()+t.toLowerCase()).forEach(t->System.out.println(t));
        }


// s8: uzunlugu 4 ve 6 olanlar haric  yazdiriniz



}
