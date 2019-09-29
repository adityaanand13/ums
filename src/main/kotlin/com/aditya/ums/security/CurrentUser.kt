package com.aditya.ums.security

import org.springframework.security.core.annotation.AuthenticationPrincipal
import java.lang.annotation.RetentionPolicy.RUNTIME

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(RUNTIME)
@MustBeDocumented
@AuthenticationPrincipal
annotation class CurrentUser
