package hello.springcore.singleton;

public class SingletonService {
    // 1. 미리 static 영역에 객체를 딱 1개 생성해둠
    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 내부에 private static 으로 가지고 있음

    // 2. public -> 객체 인스터스가 필요할 때, 이 메서드를 통해서만 조회할 수 있도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. private 생성자를 선언 -> 외부에서 new 키워드를 사용한 객체 생성을 막음
    private SingletonService(){
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}