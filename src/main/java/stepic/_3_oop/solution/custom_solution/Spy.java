package stepic._3_oop.solution.custom_solution;

import stepic._3_oop.solution.MailMessage;
import stepic._3_oop.solution.MailService;
import stepic._3_oop.solution.Sendable;


import java.util.logging.*;

import static stepic._3_oop.solution.Solution.AUSTIN_POWERS;

//
// 2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
// Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
// Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях
// нужно заменить части в фигурных скобках на значения полей почты):
//2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
// уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
//2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
// */

public class Spy implements MailService {

    public Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailMessage) {
            if (mail.getFrom().contains(AUSTIN_POWERS) || mail.getTo().contains(AUSTIN_POWERS)) {
                MailMessage mailMessage = (MailMessage) mail;
                logger.warning(
                        String.format(
                                "Detected target mail correspondence: from %s to %s \"%s\"",
                                mailMessage.getFrom(),
                                mailMessage.getTo(),
                                mailMessage.getMessage()));
            } else {
                logger.info(
                        String.format(
                                "Usual correspondence: from %s to %s",
                                mail.getFrom(),
                                mail.getTo()));
            }
        }
        return mail;
    }
}