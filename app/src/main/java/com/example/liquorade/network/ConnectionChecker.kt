package com.example.liquorade.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import javax.inject.Inject

class ConnectionChecker @Inject constructor(private val connectivityManager: ConnectivityManager) {
    /**
     * Checks if there is an internet connection
     *
     * @return Boolean, true if there is an internet connection, false if not
     */
    fun isInternetAvailable(): Boolean {
        var result = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        return result
    }
}