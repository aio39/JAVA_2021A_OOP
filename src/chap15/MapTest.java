package chap15;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        /*
         * Map 인터페이스이고 요늠을 구현한 구현 클래스가 HashMap, TreeMap, LInkedHashMap 3개가 있다. 그래서 Map
         * 타입의 변수는 3개 타입의 객체를 수용 할 수 있다. Map은 값을 <key, value> 쌍으로 저장한다. Map은 Generic 이다.
         * 클래스나 메소드 내부에서 사용할 데이터 타입을 정하지 않고 실제로 그 클래스 객체를 만들거나 메소드를 호출 할 떄 사용할 데이터 타입을
         * 파라미터를 받아서 처리하는 것. 문자열 타입의 학번을 키로, Student 객체를 값으로 Map에 저장.
         */

        Map<String, Student> map = new HashMap<>();
        map.put("a", new Student(200000, "학생1"));
        map.put("b", new Student(200001, "학생2"));
        map.put("c", new Student(200002, "학생3"));
        map.put("d", new Student(200002, "학생4"));
        map.put("e", new Student(200002, "학생5"));
        // * Map에 entry를 넣을 떄는
        // * put 메소드를 사용
        // * Map에서 원소(엔트리)를 읽을 떄는 get(key) 메소드를 사용한다.
        // * 기존 key 값과 겹치면, replace로 작동한다.

        System.out.println(map.get("a"));

        Set<String> keyset = map.keySet();
        System.out.println(keyset);
        // [a, b, c, d, e]

        Iterator<String> iter = keyset.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Student std = map.get(key);
            System.out.println(std);
        }
        /*
         * Student [name=학생1number=200000] Student [name=학생2number=200001] Student
         * [name=학생3number=200002] Student [name=학생4number=200002] Student
         * [name=학생5number=200002]
         */

        for (Map.Entry<String, Student> s : map.entrySet()) {
            System.out.println(s);
            String key = s.getKey();
            Student value = s.getValue();
            System.out.println("key = " + key + ",value= " + value);
        }
    }

}

/**
 * Student
 */
class Student {
    int number;
    String name;

    /**
     * @param number
     * @param name
     */
    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Student [name=" + name + "number=" + number + "]";
    }

}