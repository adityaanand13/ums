package com.aditya.ums.entity

import com.aditya.ums.enums.Blood
import com.aditya.ums.enums.Category
import com.aditya.ums.enums.Gender
import com.aditya.ums.enums.UserType
import javax.management.relation.Role
import javax.persistence.*

@Entity
@Table(name = "user")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "email")
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    var gender: Gender,

    @Column(name = "phone")
    var phone: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "blood")
    var blood: Blood,

    @Enumerated(EnumType.STRING)
    @Column(name = "religion")
    var religion : String,

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    var category : Category,

    @Column(name = "aadhar_number")
    var aadhar: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    var userType: UserType,

    @Column(name = "password")
    var password: String,

    //address
    @Column(name = "address")
    var address: String,

    @Column(name = "city")
    var city: String,

    @Column(name = "state")
    var state: String,

    @Column(name = "pin_code")
    var pinCode: String,

    @Column(name = "country")
    var country: String,

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    var role: Set<Role>
)