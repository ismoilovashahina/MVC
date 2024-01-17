package com.example.myapplication

import java.util.Scanner
import kotlin.system.exitProcess

fun main(){
//    var user1 = User("Ismoilova Shahina", 17)
//    var user2 = User("Rashidova Arjumandbonu", 5)
//    var user3 = User("Khudoyberdieva Jasmine", 15)

//    var manager = Manager()
//
//    manager.addUser(user1)
//    manager.addUser(user2)
//    manager.addUser(user3)
//
//    manager.showUser(user2)
//
//    manager.removeUser(user3)

    var controller = UserController()
    controller.onCreate()
}

//class Manager{
//    var users = mutableListOf<User>()
//    fun addUser(user:User){
//       users.add(user)
//    }
//    fun removeUser(user: User){
//        users.remove(user)
//    }
//    fun showUser(user: User){
//        if (users.size>0){
//            for (i in 0 until users.size){
//                println("Name: ${user.name}; Age: ${user.age}")
//            }
//        } else{
//            print("Ro'yxatda mavjud emas")
//        }
//    }
//
//}

class UserModel{
    var users = mutableListOf<User>()

    fun addUser(user: User){
        users.add(user)
    }

    fun showUser():MutableList<User>{
        return users
    }
}
class UserView{
    fun show(m:String){
        print(m)
    }
}

class UserController{
    var userModel = UserModel()
    var userView = UserView()
    var init = Scanner(System.`in`)

    fun onCreate(){
        var menuItem = init.nextInt()
        when(menuItem){
            1-> addUser()
            2-> showUser()
            3-> exitProcess(0)
        }
    }

    fun addUser(){
        userView.show("Ismingizni kiriting")
        var init = Scanner(System.`in`)

        val name = init.nextLine()
        userView.show("Yoshingizni kiriting: ")
        val age = init.nextInt()
        userModel.addUser(User(name, age))
    }

    fun showUser(){
        if (userModel.showUser().size>0){
            userView.show("Foydalanuvchilar ro'yxati")
            for (i in 0 until userModel.showUser().size){
                userView.show(userModel.showUser()[i].name)
            }
        } else {
            userView.show("Foydalanuvchilar ro'yxatiga qo'shilmagan")
        }
    }
}
