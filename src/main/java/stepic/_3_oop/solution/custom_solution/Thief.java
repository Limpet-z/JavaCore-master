package stepic._3_oop.solution.custom_solution;

import stepic._3_oop.solution.MailPackage;
import stepic._3_oop.solution.MailService;
import stepic._3_oop.solution.Package;
import stepic._3_oop.solution.Sendable;

//*
// Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную
// int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать
// метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство
// происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только с
// нулевой ценностью и содержимым посылки "stones instead of {content}"./


public class Thief implements MailService {

    int minPrice;
    int totalPrice = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return totalPrice;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            int price = mailPackage.getContent().getPrice();
            if (price >= minPrice) {
                totalPrice += price;
                Package emptyPackage = new Package(
                        String.format("stones instead of %s", mailPackage.getContent().getContent()), 0
                );
                return new MailPackage(
                        mailPackage.getFrom(),
                        mailPackage.getTo(),
                        emptyPackage
                );
            }
        }
        return mail;
    }
}