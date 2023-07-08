package com.eurotech.tests.day_01_automation_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;

public class _3_javaFakerDemo {
    public static void main(String[] args) {
        //mock data uretmek ivcin kullanilir ...sahte data
        Faker faker=new Faker();

        //sahte isim uretelim
        String fullName=faker.name().fullName();
        System.out.println(fullName);

        //sahte bir sehir uretelim
       String city= faker.address().city();
        System.out.println(city);


        //kredi kartı no
        String creditCard = faker.finance().creditCard();
        System.out.println("creditCard = " + creditCard);

        //american express kredi cart no
        String creditCard1 = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        System.out.println("creditCard1 = " + creditCard1);

        //sifre uretimi
       String password= faker.internet().password() ;
        System.out.println(password);


        //rakam harf ozel isaret vb icren sifre
      String password1=  faker.internet().password(8,16,true,true,true);
        System.out.println(password1);

        //belli bir degerle baslayan sifre "AB123*"

       String password3="AB123*" + faker.internet().password();
        System.out.println(password3);

      


    }
}
