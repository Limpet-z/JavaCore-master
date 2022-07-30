package kata.review3.solution.custom_solution;

import kata.review3.solution.MailService;
import kata.review3.solution.RealMailService;
import kata.review3.solution.Sendable;

/*
    У класса должен быть конструктор от массива MailService
    (результат вызова processMail первого элемента массива передается на вход processMail второго элемента,
    и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService,
    он не приходит массивом в конструкторе и не настраивается извне класса.
 */

public class UntrustworthyMailWorker implements MailService {


    public UntrustworthyMailWorker(MailService[] mailServices) {


    }

    @Override
    public Sendable processMail(Sendable mail) {
        return mail;
    }

    public RealMailService getRealMailService () {
        return new RealMailService();
    }
}
