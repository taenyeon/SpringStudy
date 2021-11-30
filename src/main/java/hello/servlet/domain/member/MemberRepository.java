package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private Map<Long,Member> store = new HashMap<>();
    private long sequence = 0L;

    //싱글톤 패턴 사용
    private static final MemberRepository instance = new MemberRepository();
    // getInstance()메소드를 통해서만 호출하여 사용
    public static MemberRepository getInstance() {
        return instance;
    }
    // 싱글톤을 위해서 생성자 막음
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
