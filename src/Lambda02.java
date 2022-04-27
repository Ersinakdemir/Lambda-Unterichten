import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
        List<Integer> sayi =new ArrayList<>(Arrays.asList(3,2,6,11,-5,20,6,21,-8,8,15));
        ciftKarePrint(sayi);
        System.out.println("\n");
        teksayilarinKübü(sayi);
        System.out.println("\n");
        ciftKareKokPrint(sayi);
        System.out.println("\n");
        maxEleman(sayi);
        System.out.println("\n");
        ciftKareMax(sayi);
        System.out.println("\n");
        elTop(sayi);
        System.out.println("\n");
        ciftCarpim( sayi);

    }
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftSayiBul).
                map(t->t*t).                 //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak
                                              // (update) için Map kullanılmaktadır.
                forEach(Lambda01::yazdir);//1156 484 256 400 64 1444

        //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak
        // (update) için Map kullanılmaktadır.
    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda
    // aralarina bosluk birakarak print edi
    public static void teksayilarinKübü(List<Integer> sayi){
        sayi.
                stream().//sayilar akisa alindi
                filter(t->t%2!=0).//tek elemanlar filtrelendi
                map(t->(t*t*t)).//teklerin küplerinin 1 fazlasina update edildi
                forEach(Lambda01::yazdir);//print edildi
    }
// Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokPrint(List<Integer> sayi){
        sayi
              .stream().
                filter(Lambda01::ciftSayiBul).
                map(Math::sqrt). //meth ref
                //forEach(Lamda01::yazdir)
                forEach(t-> System.out.print(t +" "));
    }
    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxEleman(List<Integer> sayi){
        Optional<Integer> maxSayi=sayi.
                stream().
                reduce(Math::max);//Akisa giren elemanlari tek eleman haline getirir
        System.out.println(maxSayi);
        System.out.println("atama yapmadan : "+ sayi.stream().reduce(Math::max));
        /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }
    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMax(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftSayiBul).
                map(t -> t * t).
                reduce(Math::max));//400
        System.out.println("daha hizli specifik Integer class : "+sayi.
                stream().
                filter(Lambda01::ciftSayiBul).
                map(t -> t * t).
                reduce(Integer::max));//400 specific class daha hizli run olur

    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...pu
    public static void elTop(List<Integer> sayi){
        //Lamda expression
       int toplam= sayi.stream().reduce(0,(a,b)->a+b);//Lamda Expression
        System.out.println(toplam);

        //method ref
        System.out.println(sayi.stream().reduce(Integer::sum));//method ref

        /*
        a ilk degerini her zaman atanan degerden(indentity) alir
        b degerini her zaman stream() 'dan alir
        a ilk derindern sonraki her degeri action(islem dan alir)
         */
    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarpim(List<Integer> sayi){

        //Method Ref
        System.out.println("method ref : "+sayi.
                stream().
                filter(Lambda01::ciftSayiBul).
                reduce(Math::multiplyExact));

        //Lambda Expression
        System.out.println("Lambda Expression : "+sayi.
                stream().
                filter(Lambda01::ciftSayiBul).
                reduce(1, (a, b) -> (a * b)));
    }
}
