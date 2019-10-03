package com.aditya.ums.security

import org.springframework.security.core.annotation.AuthenticationPrincipal

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.FILE)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@AuthenticationPrincipal
annotation class CurrentUser
