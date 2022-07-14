package workout;

public class TextPerRoleUpdated {

    private static final String[] ROLES = new String[] {
            "Городничий",
            "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"
    };

    private static final String[] REPLICAS = new String [] {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };

    public static void main(String[] args) {

        for (String role: ROLES) {
            System.out.println(findAndPrintAllReplicasForRole(role));
        }
    }

    private static String findAndPrintAllReplicasForRole(String role) {

        StringBuilder preparedString = new StringBuilder(role + ":\n");

        for (int i = 0; i < REPLICAS.length; i++) {
            String replica = REPLICAS[i];
            if (replica.startsWith(role)) {
                String replicaWithoutRole = replica.replaceFirst(role + ":", "");
                preparedString.append(String.format("%d) %s%n", i+1, replicaWithoutRole));
            }
        }
        return preparedString.toString();
    }

}