package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService service = new MemberServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService service = appConfig.memberService();

        // 멤버 신규 가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        service.join(member);

        // 해당 멤버 찾기
        Member findMember = service.findMember(1L);

        System.out.println("member: " + member.getName());
        System.out.println("findMember: " + findMember.getName());
    }
    // 하지만 이렇게 애플리케이션 로직으로 확인해보는 것은 좋은 방법이 아니다. Junit 을 이용하자
}