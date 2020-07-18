package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "college_principal")
class CollegePrincipal(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @OneToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "college_id", nullable = false)
        var college: College,

        @Column(name= "principal_id")
        var principal: Int? = null
)