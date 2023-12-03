package com.jejetrue.skillshiftapp.data.payload

data class dataRegister(
    var options: String,
    var fullName: String,
    var email: String,
    var username: String,
    var password: String,
    var confirmPassword: String
)

data class dataLogin(
    var email: String,
    var password: String,
    var options: String,
    var method: String
)

data class dataVerif(
    var email: String,
    var userVerificationCode: String
)