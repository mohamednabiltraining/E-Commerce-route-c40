package com.example.e_commerce_route_c40.util

class ValidationUtils {

    companion object{
        fun isValidPassword(password:String?):Boolean{
    //        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()
            return  (password?.length ?: 0) >= 6
        }
        fun isValidEmail(email:String?):Boolean{
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
            return email?.matches(emailRegex) ?: false
        }
    }
}