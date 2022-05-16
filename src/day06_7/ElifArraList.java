package day06_7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElifArraList {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
        // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
        // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1 [] ={1,5,-5,6,12,-8,9,3,4};


    }
    //S1: arrayin elemanlarini bir liste yazdiralim

public static List<Integer>listele(Integer[]arr){
        return Arrays.stream(arr).collect(Collectors.toList());
}

    //S2: Arrayin elemanlarini toplamini bulalim
    public static int toplam(Integer[]arr){
        Stream<Integer>arrYeni =Stream.of(arr);
        return arrYeni.reduce(0,(x,y)->x+y);
    }
    public static int toplam2(int[]arr){

        return Arrays.stream(arr).sum();
    }



    // S3: Array in elemanlarinin ortalamasini bulalim yazdir

}
