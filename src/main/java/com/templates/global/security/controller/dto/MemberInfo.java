package com.templates.global.security.controller.dto;

import com.templates.domains.member.domain.Member;

public record MemberInfo(
    Long seq,
    String loginId,
    String name
) {

  public static MemberInfo of(Member member) {
    return new MemberInfo(member.getSeq(), member.getLoginId(), member.getName());
  }
}
