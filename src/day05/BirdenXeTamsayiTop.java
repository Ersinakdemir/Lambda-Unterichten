package day05;

import java.util.stream.IntStream;

public class BirdenXeTamsayiTop {
    public static void main(String[] args) {

        System.out.println("Task 01 amele topla--> : "+toplaAmele(10));
        System.out.println("          ****       ");

        System.out.println("Task 01 Lambda topla--> : "+toplaLambda(10));
        System.out.println("          ****       ");


        System.out.println("Task 02 1 de x ekadar cift sayilar--> : "+ birdeXeCiftTopla(10));
        System.out.println("          ****       ");

        System.out.println("Task 03-->  :  "+ IlkXCiftTopla(10));
        System.out.println("          ****       ");

        System.out.println("Task 04-->  :  "+ IlkXTektTopla(10));
        System.out.println("          ****       ");

        System.out.println("Task 05-->");
        System.out.println("          ****       ");
        ikininIlkXkuvvetiniprint(5);

        System.out.println("Task 06-->");
        System.out.println("          ****       ");
        birSayininIlkXkuvvetiniprint(5,3);
        birSayininIlkXkuvvetiniprint(7,4);

        System.out.println("Task 07-->  :  "+ birSayininVaktorielprint(5));
        System.out.println("          ****       ");

        System.out.println("Task 08-->  :  "+ xKuvveti(4,3));
        System.out.println("          ****       " );
        System.out.println("Task 08--> 2. Yol :  "+ + xKuvveti2(5,4));
    }
    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int toplaAmele(int x){
        int top=0;
        for (int i = 0; i <= x; i++) {
            top +=i;
        }
        return top;
    }

    //Functional(cincix Programming

    public static int toplaLambda(int x){
      return IntStream.//Int degerler akisa alindi
              range(0,x+1).//araligi belirlendi
              sum();//akisda ki int degerler toplandi
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int birdeXeCiftTopla(int x){
        return IntStream.
                rangeClosed(1,x).//kapali aralik
                filter(t->t%2==0).//ciftsayilar filitrelendi
                sum();//toplam

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int IlkXCiftTopla(int x) {
        return IntStream.
                iterate(2, t -> t + 2).  //kapali aralik
                        limit(x).
                sum();  //toplam
        //iterate(seed , intUpartoinn) verilen baslangic degerinden sonzuza kadar o islemi yapar
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int IlkXTektTopla(int x) {
        return IntStream.
                iterate(1, t -> t + 2).  //kapali aralik
                        limit(x).
                sum();  //toplam
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXkuvvetiniprint(int x) {
         IntStream.
              iterate(2, t -> t * 2).  //kapali aralik
                     limit(x).
              forEach(System.out::println);  //toplam
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void birSayininIlkXkuvvetiniprint(int istenenSayi,int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).  //kapali aralik
                limit(x).
                forEach(System.out::println);  //toplam
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int birSayininVaktorielprint(int x) {
        return IntStream.rangeClosed(1,x).//reduce(Math::multiplyExact)
                reduce(1,(t,u)->t*u);

    }


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int xKuvveti(int istenenSayi, int x){
        return IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).reduce(0,(t,u)->u);
    }
     //2.Yol
    public static double xKuvveti2(int istenenSayi,int x){
        return Math.pow(istenenSayi,x);
    }
}
