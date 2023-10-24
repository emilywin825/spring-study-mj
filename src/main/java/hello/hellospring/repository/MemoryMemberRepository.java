package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 반환 될 가능성이 있다면 이렇게 처리 -> 클라에서 처리 가능
    }
    @Override
    public List<Member> findAll() { //자바 실무에서 List 많이 사용
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //끝까지 돌렸는데 null이면 Optional에 감싸져서 return 됨
    }
    public void clearStore() {
        store.clear();
    }
}
