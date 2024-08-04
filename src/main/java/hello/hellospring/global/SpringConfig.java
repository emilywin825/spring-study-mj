package hello.hellospring.global;

import hello.hellospring.domain.Member.repository.MemberRepository;
import hello.hellospring.domain.Member.repository.MemoryMemberRepository;
import hello.hellospring.domain.Member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
