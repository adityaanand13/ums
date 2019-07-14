package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "Teacher_group_subject_entitlement")
class TeacherGroupSubjectEntitlement (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        var id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "subject_id")
        var subject: Subject,

        @ManyToOne
        @JoinColumn(name = "instructor_id")
        var instructor: Instructor,

        @ManyToOne
        @JoinColumn(name = "group_id")
        var group: Group
)