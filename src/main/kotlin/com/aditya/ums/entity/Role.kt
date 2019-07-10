package com.aditya.ums.entity

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    var id: Int,

    @Column(name = "role_name")
    var role:String,

    @Column(name = "role_desc")
    var desc: String
)