package com.example.popsa_clone.ui.utils


import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun formatPrice(
    price: Double,
    locale: Locale = Locale.UK
): String {
    val formatter = NumberFormat.getCurrencyInstance(locale)

    if (price % 1.0 == 0.0) {
        // Whole number → no decimals
        formatter.maximumFractionDigits = 0
    } else {
        // Has decimals → keep currency defaults (usually 2)
        formatter.minimumFractionDigits = 2
        formatter.maximumFractionDigits = 2
    }

    return formatter.format(BigDecimal.valueOf(price))
}