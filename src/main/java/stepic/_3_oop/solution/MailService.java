package stepic._3_oop.solution;

import stepic._3_oop.solution.custom_solution.IllegalPackageException;
import stepic._3_oop.solution.custom_solution.StolenPackageException;

/*
Интерфейс, который задает класс, который может каким-либо
 образом обработать почтовый объект.
*/
public  interface MailService {
    Sendable processMail(Sendable mail) throws IllegalPackageException, StolenPackageException;
}