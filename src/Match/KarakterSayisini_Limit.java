package Match;

import java.util.*;

public class KarakterSayisini_Limit {
    public static void main(String[] args) {
        List<String> menu =new ArrayList<>(Arrays.asList("küsleme","adana","trilecex","havucDilimi","trilece","buryan","trilece","yaglama",
                "kokorec","arabasi","guvec"));
        ilkElHarcSonHrfSiraliPrint(menu);
        System.out.println("\n             ***********         ");
        charSayisiBykElPrint(menu);
    }
    public static void charSayisiBykElPrint(List<String> menu){
        System.out.println(menu.stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                length()).reversed()).
                //findFirst());    //ilk eleman alindi
                limit(3).toList());  //Limit bir akis verir onu alip arr veya List gibi bir depoya atmamiz gerekir
        // limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.
//limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder.
        // akıs cıktısını bir veriable assaign edilebilir

        Optional<String>enByukChrEl=menu.stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                length()).reversed()).
                findFirst();   //ilk eleman alindi
    }
    // List elemanlari son harfine göre siralayipilk eleman haric kalan harfleri print

    public static void ilkElHarcSonHrfSiraliPrint(List<String>menu){
        menu.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).  //son harfe göre siralandi
                skip(1).forEach(t-> System.out.print(t+ " "));   //ilk eleman(adana) atlandi ve print

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }

}
