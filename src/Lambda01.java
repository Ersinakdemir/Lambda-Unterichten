import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/
        List<Integer> sayi =new ArrayList<>(Arrays.asList(34,22,16,35,20,63,21,65,44,66,64,81,38,15));
        prinElStructured(sayi);
        System.out.println("\n          ***************           ");
        prinElFunctional(sayi);
        System.out.println("\n          ***************           ");
        prinElFunctional1(sayi);
        System.out.println("\n          ***************           ");
        printCiftElFunctional(sayi);
        System.out.println("\n          ***************           ");
        printCiftElFunctional1(sayi);
        System.out.println("\n          ***************           ");
        printCiftElSturctured(sayi);
        System.out.println("\n          ***************           ");
        printCiftElFunctional3(sayi);
        System.out.println("\n          ***************           ");
        printCiftElFunctional4(sayi);
    }
    //Task: Structured programin kullanara List elemanlar ayni satirda aralarinda bosluk olacak sekilde print ediniz.
    public static void prinElStructured( List<Integer> sayi){
        for (Integer w:sayi
             ) {
            System.out.print(w+" ");
        }
    }
    //Task: functional programin kullanara List elemanlar ayni satirda aralarinda bosluk olacak sekilde print ediniz.
    public static void prinElFunctional( List<Integer> sayi){
        sayi.stream().forEach(t-> System.out.print(t +" "));
    }/*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */
    public static void prinElFunctional1( List<Integer> sayi){
        sayi.stream().forEach(System.out::print);//method reference-->System.outyapisinda prin tmethodu refere et
                                                //Bu aksiyon task daki ayni satira bosluk ile yazdirmayi karsilamaz
                                                //seed() tohum method creat edip refere edilmeli
    }
    public static void yazdir(int a){//Yazdirma actionu yapan seed(tohum)
        System.out.print(a+" ");
    }

    public static void prinElFunctional2( List<Integer> sayi){
        sayi.stream().forEach(Lambda01::yazdir);//method reference-->System.outyapisinda prin tmethodu refere et
    }
    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElSturctured( List<Integer> sayi){
        for (Integer w :sayi) {
            if (w%2==0){
                System.out.print(w);
            }
        }
    }
    //functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.stream().
                filter(t->t%2==0).
                forEach(Lambda01::yazdir);
    }
    public static boolean ciftSayiBul(int a){
        return a%2==0;
    }

    //functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().              //List elemanlari akisa alindi
                filter(Lambda01::ciftSayiBul).   //ciftbull method refere edilerek akisdaki elememntler filitrelendi(cift)
                forEach(Lambda01::yazdir);   //filtreden gelen elemanlar yardir() method refer edilerek print edildi
    }

    //functional Programming ile list elemanlarinin 34 kücük cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional3(List<Integer> sayi){
        sayi.stream().
                filter(Lambda01::ciftSayiBul).  //method refere
                filter(t->t<34).   //lambda exp
                forEach(Lambda01::yazdir);
    }
    //functional Programming ile list elemanlarinin 34 kücük yada cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional4(List<Integer> sayi){
        sayi.stream().
                filter(t->t>34||t%2==0).//exp lambda e
                forEach(Lambda01::yazdir);
    }

}
