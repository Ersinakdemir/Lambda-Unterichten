package day03Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C01EnKucuk4FarkliSekil {
    public static void main(String[] args) {
        List<Integer> sayi =new ArrayList<>(Arrays.asList(3,2,6,11,-5,20,6,21,-8,8,15));
        enKucukMethodRefIntiger(sayi);
        enKucukMethodRefMathe( sayi );
    }
    //Task Listedeki elemanlardan en kücügünü 4 farkli yöntem kullanarak print ediniz

    //1 - Method refere Intiger class
    public static void enKucukMethodRefIntiger(List<Integer> sayi ){
        Optional<Integer>minSayiMethRefIntiger =sayi.stream().reduce(Integer::min);
    }
    //2 - Method refere Mathe class
    public static void enKucukMethodRefMathe(List<Integer> sayi ){
        Optional<Integer> minSayiMethodRefMathe=sayi.stream().reduce(Math::min);
    }
    //3 - Lambda Expression
    public static void enKucukLambdaExpres(List<Integer> sayi ){
        int minLamdaExpres= sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);//  Optional<Integer> yazamamizin
                                                                                           // sebebi baslangic olarak max degerini atamamaiz
    }
    //4- Method Reference cagirma
    public static void enkucukMethodRef(List<Integer> sayi){
        Optional<Integer> minMethodRef =sayi.stream().reduce(C01EnKucuk4FarkliSekil::minBul);
    }

    public static int minBul(int a, int b){
        return a<b ?a:b;
    }


}
