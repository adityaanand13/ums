package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "section_head_mentor")
class SectionHeadMentor (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @OneToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "section_id", nullable = false)
        var section: Section,

        @Column(name= "head_mentor_id")
        var headMentor: Int? = null
)