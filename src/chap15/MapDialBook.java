package chap15;

import java.util.*;

public class MapDialBook {

    public static void main(String[] args) {
        Map<String, String> aBan = new TreeMap<>();
        aBan.put("학생A", "010-1234-1231");
        aBan.put("학생B", "010-1234-1232");
        aBan.put("학생C", "010-1234-1233");

        Map<String, String> bBan = new TreeMap<>();
        bBan.put("학생A", "010-1234-1231");
        bBan.put("학생B", "010-1234-1232");
        bBan.put("학생C", "010-1234-1233");

        Scanner input = new Scanner(System.in);
        Map<String, Map<String, String>> phoneBook = new HashMap<>();
        phoneBook.put("A", aBan);
        phoneBook.put("B", bBan);

        while (true) {
            String ban;
            String phone;
            Map banPB = null;
            boolean next = true;
            while (true) {
                System.out.println("어느반");
                for (String b : phoneBook.keySet()) {
                    System.out.print(b + " ");
                }

                ban = input.nextLine();
                if (ban.equalsIgnoreCase("Q")) {
                    next = false;
                    break;

                }
                System.out.println(ban);
                banPB = phoneBook.get(ban);
                System.out.println(banPB);
                if (banPB == null) {
                    System.out.println("그런 반은 없습니다.");
                    continue;
                } else {
                    break;
                }
            }
            if (!next)
                break;

            while (true) {
                System.out.println("누구");
                String who = input.nextLine();
                phone = banPB.get(who).toString();
                if (phone == null) {
                    System.out.println("그런 학생은 없습니다.");
                    continue;
                } else {
                    break;
                }
            }

            System.out.println(phone);

        }
    }
}
