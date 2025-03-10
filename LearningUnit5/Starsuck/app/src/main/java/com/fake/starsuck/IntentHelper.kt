package com.fake.starsuck

import android.content.Context
import android.content.Intent
import android.os.Bundle

fun openIntent(context: Context, order: String, activityToOpen: Class<*>) {
    val intent = Intent(context, activityToOpen)
    intent.putExtra("order", order)
    context.startActivity(intent)
}

fun shareIntent(context: Context, productName: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, "Check out this drink: $productName")
    }
    context.startActivity(Intent.createChooser(intent, "Share via"))
}

