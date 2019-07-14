package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "subject")
class Subject (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @ManyToOne(
        cascade = [
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        ]
    )
    @JoinColumn(name = "semester_id")
    var semester: Semester

//    @OneToMany(mappedBy = "subject_id")
//    var attendances: MutableList<Attendance> = arrayListOf()
)
