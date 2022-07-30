package kata.review3.solution.custom_solution;

import kata.review3.solution.MailMessage;
import kata.review3.solution.MailService;
import kata.review3.solution.Sendable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {

    private static Logger logger = Logger.getLogger(Spy.class.getName());
    @Override
    public Sendable processMail(Sendable mail) {

        return mail;
    }

    public Spy(MailMessage mailMessage) {

        if (mailMessage.getFrom().equals("Austin Powers")) {
            logger.log(Level.WARNING, "Detected target mail correspondence: " +
                    "from" + mailMessage.getFrom() +  "to" + mailMessage.getTo() + mailMessage.getMessage());
        } else {
            logger.log(Level.INFO, "Usual correspondence: from" + mailMessage.getFrom() +  "to" + mailMessage.getTo());
        }
    }
}
