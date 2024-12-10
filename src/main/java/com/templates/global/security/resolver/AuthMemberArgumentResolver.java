package com.templates.global.security.resolver;

import com.templates.domains.member.domain.Member;
import com.templates.domains.member.repository.MemberRepository;
import com.templates.global.security.annotation.Auth;
import com.templates.global.security.controller.dto.MemberInfo;
import com.templates.global.security.service.CustomUserDetailsService.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
public class AuthMemberArgumentResolver implements HandlerMethodArgumentResolver {

  private final MemberRepository memberRepository;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType().equals(MemberInfo.class) &&
        parameter.hasParameterAnnotation(Auth.class);

  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (isAuthed(authentication)) {
      throw new AuthenticationCredentialsNotFoundException("");
    }

    Long memberSeq = ((CustomUserDetails) authentication.getPrincipal()).getSeq();
    Member member = memberRepository.findById(memberSeq)
        .orElseThrow(() -> new AuthenticationCredentialsNotFoundException(""));

    return MemberInfo.of(member);
  }

  private static boolean isAuthed(Authentication authentication) {
    return authentication == null
        || !authentication.isAuthenticated()
        || "anonymousUser".equals(authentication.getPrincipal());
  }
}