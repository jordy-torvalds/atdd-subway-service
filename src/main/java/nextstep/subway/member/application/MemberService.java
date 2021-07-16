package nextstep.subway.member.application;

import nextstep.subway.member.domain.Member;
import nextstep.subway.member.domain.MemberRepository;
import nextstep.subway.member.dto.MemberRequest;
import nextstep.subway.member.dto.MemberResponse;
import nextstep.subway.member.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse createMember(MemberRequest request) {
        Member member = memberRepository.save(request.toMember());
        return MemberResponse.of(member);
    }

    @Transactional(readOnly = true)
    public MemberResponse findMember(Long id) {
        return MemberResponse.of(findMemberById(id));
    }

    public void updateMember(Long id, MemberRequest param) {
        Member member = findMemberById(id);
        member.update(param.toMember());

    }

    private Member findMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
