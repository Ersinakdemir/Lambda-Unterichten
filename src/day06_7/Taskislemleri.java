package day06_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Taskislemleri {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a print ediniz.)
        System.out.println("\nTASK 01 --> haluk.txt dosyasini okuyunuz -->  ");

        Path haluk=Path.of("src/day06_7/haluk.txt");//path halukobj atamdi
        Stream<String> akis = Files.lines(haluk);//haluk txt datalari akis stream e atandi

        //1- Yol
        Files.lines(haluk);  //Path deki dosyanin datalari akisa alindi
        //Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).//path'deki dosyanın dataları akısa alındı
        // forEach(System.out::println);//akısdaki datalar(her satırdaki string) print edildi.

        //2.Yol
        akis.forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle print ediniz.)
        System.out.println("\nTASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files.lines(Paths.get("src/day06_7/haluk.txt")).
                map(String::toUpperCase).//akısdaki datalar buyuk harfe update edldi
                forEach(System.out::println);//akısadaki datalar(her satırdaki string)yazıldı)

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle print ediniz..

        System.out.println("\nTASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        //1-Yol Limit methoduyla
        System.out.println(Files.lines(Paths.get("src/day06_7/haluk.txt")).
                map(t -> t.
                        toLowerCase(Locale.ROOT)).//
                        findFirst());

        //2-Yol
        Files.lines(Paths.get("src/day06_7/haluk.txt")).
                limit(1).
                map(t->t.

                        toLowerCase(Locale.ROOT)).//
                forEach(System.out::println);


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz print ediniz.
        System.out.println("\nTASK 04 --> haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.
                lines(haluk).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..
        System.out.println("\nTASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        /*
Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
 fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
  Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

 */  //1-Yol Listing
        System.out.println(Files.
                lines(haluk).
                map(t -> t.split(" ")).//satirlardaki kelimeler array eatandi
                        flatMap(Arrays::stream).//2dArraydeki elemanlar akisa alindi
                        distinct().//benzersiz yapildi
                        collect(Collectors.toList()));
//2- Yoln toSet()
        System.out.println(Files.
                lines(haluk).
                map(t -> t.split(" ")).//satirlardaki kelimeler array eatandi
                        flatMap(Arrays::stream).
                collect(Collectors.toSet()));
        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..
        System.out.println("\nTASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.
                lines(haluk).
                map(t -> t.split(" ")).//satirlardaki kelimeler array eatandi
                flatMap(Arrays::stream).
                sorted().forEach(System.out::println);


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız print ediniz.
        System.out.println("\nTASK 07 --> haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(haluk).
                map(t -> t.split(" ")).//satirlardaki kelimeler array eatandi
                        flatMap(Arrays::stream).filter(t->t.equals("Basari")).count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini print eden  programi create ediniz.
        System.out.println("\nTASK 08 --> haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.
                lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).//a bulunduran kelimeler sayildi
                        count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri print ediniz.
        System.out.println("\nTASK 09 --> haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.
                lines(haluk).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).collect(Collectors.toList()));

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini print ediniz.
        System.out.println("\nTASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(haluk).
                map(t -> t.replaceAll("\\W", "").replaceAll("\\d", "").
                        replaceAll("\\d", "").
                        split("")).
                flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini print ediniz.
        System.out.println("\nTASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        Files.
                lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::println);

    }
}
