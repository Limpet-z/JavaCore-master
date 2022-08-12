package stepic._3_oop.solution;

import stepic._3_oop.solution.custom_solution.*;
import java.util.logging.*;

public class Solution {

    private static final Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) {
        MailMessage mailMessageTest = new MailMessage("Ivan", AUSTIN_POWERS, "Hello World message");
        MailPackage mailPackageTest = new MailPackage("Ivan", "Anton", new Package("My Package with sweets", 300));
        Spy spy = new Spy(LOGGER);
        Thief thief = new Thief(200);
        Inspector inspector = new Inspector();
        UntrustworthyMailWorker untrustworthyMailWorker =
                new UntrustworthyMailWorker(new MailService[] {spy, thief, inspector});
        untrustworthyMailWorker.processMail(mailMessageTest);

    }
}