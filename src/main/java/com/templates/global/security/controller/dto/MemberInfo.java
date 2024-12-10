package com.templates.global.security.controller.dto;

import com.templates.global.security.service.CustomUserDetailsService.CustomUserDetails;

public record MemberInfo(
    Long seq,
    String loginId,
    String name
) {

  public static MemberInfo of(CustomUserDetails member) {
    return new MemberInfo(member.getSeq(), member.getUsername(), member.getName());
  }
}
