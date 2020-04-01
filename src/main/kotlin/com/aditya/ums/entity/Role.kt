package com.aditya.ums.entity

import com.aditya.ums.enums.RoleType
import org.hibernate.annotations.NaturalId
import javax.persistence.*

@Entity
@Table(name = "roles")
class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @Enumerated(value = EnumType.STRING)
        @Column(length = 60)
        var name: RoleType?
)