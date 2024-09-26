package com.example.ownnotes.ownNotesDomain.model

enum class ColorNote {
    YELLOW, RED, GREEN, BLUE;

    fun toHex(): String {
        return when (this) {
            RED -> "#e09591"
            GREEN -> "#d8dcba"
            BLUE -> "#CCE3DE"
            YELLOW -> "#fff5d9"
        }
    }
}