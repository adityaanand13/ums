package com.aditya.ums.entity

import javax.persistence.*
@Entity
@Table(name = "group_mentor")
class GroupMentor (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @OneToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "group_id", nullable = false)
        var group: Group,

        @Column(name= "head_mentor_id")
        var mentor: Int? = null
)