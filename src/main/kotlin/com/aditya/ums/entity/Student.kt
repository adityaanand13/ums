package com.aditya.ums.entity

import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

    //@MapsId tells Hibernate to use the id column of address as both primary key and foreign key. Also, notice that the @Id column of the Address entity no longer uses the @GeneratedValue annotation.
    @OneToOne
    @MapsId
    var user: User,

    @Column(name = "roll_no")
    var rollNo : Int,

    //todo refactoring
    @Column(name = "batch")
    var batch : String,

    @Column(name = "local_address")
    var localAddress: String,

    //todo refactoring nationality
    @Column(name = "nationality")
    var nationality: String,

    //todo add ESM : Ex-Serviceman
    //todo add PHC : Physically handicapped

    //student family details
    @Column(name = "fathers_name")
    var fathersName: String,

    @Column(name = "fathers_phone")
    var fathersPhone: String,

    @Column(name = "fathers_income")
    var fathersIncome: Int,

    @Column(name = "fathers_occupation")
    var fathersOccupation: String,

    @Column(name = "mothers_name")
    var mothersName: String,

    @Column(name = "mothers_phone")
    var mothersPhone: String,

    @Column(name = "mothers_income")
    var mothersIncome: Int? = 0,

    @Column(name = "mothers_occupation")
    var mothersOccupation: String,

    @Column(name = "family_income")
    var familyIncome: Int,

    // many students can have many courses
    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
        ]
    )
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    private var courses: MutableList<Course>? = null
)