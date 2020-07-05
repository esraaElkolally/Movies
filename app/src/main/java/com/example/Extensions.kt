package com.example

class ProtectedProperty<T>(var value: T) {
    // You can even make your logs look cooler by using the UTF-8 Full Block character (U+2588) instead. or use any string
    override fun toString() = "U+2588"
}