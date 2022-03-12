package com.example.sharepreferences.behaviour

import android.content.SharedPreferences
import com.example.sharepreferences.utils.Constant

fun SharedPreferences.writeToken(accessToken: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.HA_TOKEN, "Bearer $accessToken").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeBaseUrl(accessToken: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.BASE_URL, accessToken).apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeUserName(userName: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.USER_NAME, "$userName").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeUser(userInFo: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.USER, "$userInFo").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeUserId(userId: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.USER_ID, "$userId").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeTimeZoneName(timeZone: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.TIME_ZONE_NAME, "$timeZone").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeTimeZone(timeZone: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.TIME_ZONE, "$timeZone").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeIsManager(isManager: Boolean, isWriteSynchronized: Boolean = false) {
    edit().putBoolean(Constant.IS_MANAGER, isManager).apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeIsLogout(logout: Boolean, isWriteSynchronized: Boolean = false) {
    edit().putBoolean(Constant.LOG_OUT, logout).apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeSeenSplash(seenSplash: Boolean, isWriteSynchronized: Boolean = false) {
    edit().putBoolean(Constant.SPLASH, seenSplash).apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeUserImg(userImg: String?, isWriteSynchronized: Boolean = false) {
    edit().putString(Constant.USER_IMG, "$userImg").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}


fun SharedPreferences.readBaseUrl(): String? {
    return getString(Constant.BASE_URL, null)
}

fun SharedPreferences.readToken(): String? {
    return getString(Constant.HA_TOKEN, null)
}

fun SharedPreferences.readUserInfo(): String? {
    return getString(Constant.USER, null)
}

fun SharedPreferences.readUserId(): String? {
    return getString(Constant.USER_ID, null)
}

fun SharedPreferences.readUserName(): String? {
    return getString(Constant.USER_NAME, null)
}

fun SharedPreferences.readTimeZone(): String? {
    return getString(Constant.TIME_ZONE, null)
}

fun SharedPreferences.readTimeZoneName(): String? {
    return getString(Constant.TIME_ZONE_NAME, null)
}

fun SharedPreferences.readLogOut(): Boolean {
    return getBoolean(Constant.LOG_OUT, false)
}

fun SharedPreferences.readIsManager(): Boolean {
    return getBoolean(Constant.IS_MANAGER, false)
}

fun SharedPreferences.readIsSeenSplash(): Boolean {
    return getBoolean(Constant.SPLASH, false)
}

fun SharedPreferences.readUserImg(): String? {
    return getString(Constant.USER_IMG, null)
}

fun SharedPreferences.deleteToken(isWriteSynchronized: Boolean = false) {
    edit().remove(Constant.HA_TOKEN).apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
}

fun SharedPreferences.writeAndReadToken(
    accessToken: String,
    isWriteSynchronized: Boolean = false,
): String? {
    edit().putString(Constant.HA_TOKEN, "Bearer $accessToken").apply {
        if (isWriteSynchronized) {
            commit()
        } else {
            apply()
        }
    }
    return getString(Constant.HA_TOKEN, null)
}

fun SharedPreferences.cleanAll() {
    edit().clear().apply()
}