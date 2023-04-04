package ph.stacktrek.novare.ecommerce.tuliao.sammuel.model;

import java.time.LocalDateTime

open class User(val username:String, val password:String) {
    lateinit var email: String
        private set
    lateinit var mobileNumber: String
        private set
    lateinit var userID: String
        private set
    lateinit var accountCreated: LocalDateTime
        private set
    lateinit var lastLogin: LocalDateTime
        private set
    constructor(): this("", "")

    init{
        println("init called")
    }
}



class ShopOwner(): User(){
    lateinit var shopName: String
        private set
    lateinit var rating: ArrayList<String>

}


class Buyer(): User(){
    lateinit var cart: ArrayList<String>

}




//
//fun add() = 0
//fun add(value1: Int, value2: Int) = value1 + value2
//fun add(value1: Float, value2:Float):Float {
//    return value1 + value2
//}
//fun Int.add(value1: Int, value2: Int) = value1 + value2
//fun add(value1: Double , value2:Double = 0.0) = value1 + value2
//
//fun compute (vararg numbers:Int): Int {
//    var result : Int = 0
//    return result
//}