package stepic._3_oop.solution.custom_solution;

import stepic._3_oop.solution.MailService;
import stepic._3_oop.solution.RealMailService;
import stepic._3_oop.solution.Sendable;

/*
    У класса должен быть конструктор от массива MailService
    (результат вызова processMail первого элемента массива передается на вход processMail второго элемента,
    и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService,
    он не приходит массивом в конструкторе и не настраивается извне класса.
 */


public class UntrustworthyMailWorker implements MailService {

    public RealMailService realMailService = new RealMailService();
    public MailService[] mailService;


    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailService = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        Sendable i = null;
        for (MailService array : mailService) {
            i = array.processMail(i);

        }

        return getRealMailService().processMail(i);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}