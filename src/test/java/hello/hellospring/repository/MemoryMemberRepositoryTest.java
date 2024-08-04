package hello.hellospring.repository;

import hello.hellospring.domain.Member.entity.Member;
import hello.hellospring.domain.Member.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //메소드 끝날 때마다 리셋
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    @DisplayName("새로운 멤버를 save를 통해 추가하고 아이디 번호를 이용해 다시 찾으면 일치할 것이다.")
    public void save() {
        //given : 테스트를 위해 주어질 데이터
        Member member = new Member();
        member.setName("spring");
        //when : 테스트 실제 상황
        repository.save(member);
        //then : 테스트 결과 확인
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member); //result가 member와 같은지를 테스트
    }
    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }
}