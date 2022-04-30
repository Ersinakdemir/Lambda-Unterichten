package Universite;

import java.util.*;
import java.util.stream.Collectors;

public class runner {
    public static void main(String[] args) {
        Universite bogazici =new Universite("bogazici","Matematik",571,89);
        Universite itu =new Universite("itu","Matematik",622,81);
        Universite istanbul =new Universite(" istanbul","Hukuk",1453,71);
        Universite marmara =new Universite("marmara","bilgisayar Muh",1071,77);
        Universite ytu =new Universite("yildiz teknik","gemi",333,74);

        List<Universite>unv = new ArrayList<>(Arrays.asList(bogazici,itu,istanbul,marmara,ytu));
        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n             ***********         ");
        System.out.println(ogrSayilarinin1000dan(unv));
        System.out.println("\n             ***********         ");
        System.out.println(herhangiBirMathe(unv));
        System.out.println("\n             ***********         ");
        herhangiBirMatheList(unv);
        System.out.println("\n             ***********         ");
        ogrSayiBykKckSrala(unv);
        System.out.println("\n             ***********         ");
        ogrSayiEnAzIkinci(unv);
        System.out.println("\n             ***********         ");
        notOrtBykcKSirala(unv);
        System.out.println("\n             ***********         ");
        System.out.println(ogrSayiEnAzIkinci2(unv));
        System.out.println("\n             ***********         ");
        System.out.println(notort63denByk( unv));
        System.out.println("\n             ***********         ");
        System.out.println(notort63denByk2(unv));
        System.out.println("\n             ***********         ");
        System.out.println(notort63denByk2(unv));
        System.out.println("\n             ***********         ");
        System.out.println("tas 08 calistik "+ogrSAyisi630BykNotOrtOrt( unv));
        System.out.println("\n             ***********         ");
        System.out.println(matheBolSayi(unv));
        System.out.println("\n             ***********         ");
        System.out.println(ogrSay630danFazEnBykNotOrt(unv));
        System.out.println("\n             ***********         ");
        System.out.println(ogrSay630danAzEnKucNotOrt( unv));
    }
    //task 01--> not ortalamasi 74 den buyuk olan universite varmi
    public static boolean notOrt74BykUnv( List<Universite>unv ){
       return unv.stream().anyMatch(t->t.getNotOrt()>74);
    }

//task 02-->ogrc sayilarinin   1000 den az olmadigini  kontrol eden pr create ediniz.
public static boolean ogrSayilarinin1000dan( List<Universite>unv ){
    return unv.stream().allMatch(t->t.getOgrSayisi()<1000);
}

//task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
public static boolean herhangiBirMathe(List<Universite>unv){
        return unv.
                stream().
                anyMatch(t->t.getBolum().
                        equalsIgnoreCase("matematik"));
}
    public static void herhangiBirMatheList(List<Universite>unv) {
        System.out.println(unv.
                stream().
                filter(t -> t.getBolum().
                        equalsIgnoreCase("matematik")).toList());
    }

//task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static void ogrSayiBykKckSrala(List<Universite>unv){
        System.out.println(unv.
                stream().
                sorted(Comparator.
                        comparing(Universite::getOgrSayisi).
                        reversed()).
                collect(Collectors.toList()));//collect()->akısdaki elamanları istenen sarta gore toplar
    }

//task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.

public static void notOrtBykcKSirala(List<Universite>unv){
    System.out.println(unv.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
            limit(3).toList());
}


//task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
public static void ogrSayiEnAzIkinci(List<Universite>unv){
    System.out.println(unv.
            stream().
            sorted(Comparator.
                    comparing(t->t.getOgrSayisi())).
            toList().get(1));
}
public static List<Universite> ogrSayiEnAzIkinci2(List<Universite>unv){
   return unv.
            stream().
            sorted(Comparator.
                    comparing(Universite::getOgrSayisi)).
            limit(2).skip(1).toList();
    }


//task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
public static Optional<Integer> notort63denByk(List<Universite>unv){
        return
        unv.
                stream().
                filter(t->t.
                        getNotOrt()>63).
                map(t->t.getOgrSayisi()).
                reduce(Integer::sum);
}
public static int notort63denBykToInt(List<Universite>unv) {
    return
            unv.
                    stream().
                    filter(t -> t.
                            getNotOrt() > 63).
                    mapToInt(t -> t.getOgrSayisi()).sum();// mapToInt() --> bu method akısdaki elemanların data type'nı
// parameterisindeki() degere göre Int data type update eder
// mapToInt() --> bu method akısdaki elemanların data type'nı
// parameterisindeki() degere göre Int data type update eder

}
public static int notort63denByk2(List<Universite>unv){
        return
        unv.stream().
                filter(t->t.getNotOrt()>63).
                map(t->t.getOgrSayisi()).
                reduce(0,(t,u)->t+u);
   }

//task 08--> Ogrenci sayisi 630'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

public static double ogrSAyisi630BykNotOrtOrt(List<Universite>unv) {
    return
            unv.
                    stream().
                    filter(t -> t.
                            getOgrSayisi() > 630).
                    mapToDouble(t -> t.getNotOrt()).average().getAsDouble();// mapToDouble() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki degere göre dooble data type update eder
}


//task 09-->"matematik" bolumlerinin sayisini  print ediniz.

public static int matheBolSayi(List<Universite>unv){
       return
               (int) unv.
                       stream().
                       filter(t->t.getBolum().
                               equalsIgnoreCase("matematik")).
                       count();
}

//task 10-->Ogrenci sayilari 630'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz

public static int ogrSay630danFazEnBykNotOrt(List<Universite>unv){
        return
                unv.
                        stream().
                        filter(t->t.getOgrSayisi()>630).
                        mapToInt(t-> (int) t.getNotOrt()).max().getAsInt();
}

//task 11-->Ogrenci sayilari 630'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

public static int ogrSay630danAzEnKucNotOrt(List<Universite>unv){
    return
            unv.
                    stream().
                    filter(t->t.getOgrSayisi()<630).
                    mapToInt(t-> (int) t.getNotOrt()).min().getAsInt();
    }
}
