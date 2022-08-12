package stepic._3_oop.solution.custom_solution;

import stepic._3_oop.solution.MailPackage;
import stepic._3_oop.solution.MailService;
import stepic._3_oop.solution.Sendable;

//
// 4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
// если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
// ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из
// камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны
// объявить самостоятельно в виде непроверяемых исключений.
// */

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail)  {

        if (mail instanceof MailPackage) {

            MailPackage mailPackage = (MailPackage) mail;
            var content = mailPackage.getContent();


            if (content.getContent().contains("weapons")) {
                throw new IllegalPackageException();
            }
            if (content.getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            }

            else {
                if (content.getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
        }
        return mail;
    }
}
