package com.example.themoviesapp

import android.content.Context
import androidx.preference.PreferenceManager

class SaveShared {

    companion object {

        fun setFavorite(context: Context, key: String, value: Boolean) {
            val setFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            setFavoriteShared.edit().putBoolean(key, value).apply()
        }

        fun getFavorite(context: Context, key: String): Boolean {
            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
           return getFavoriteShared.getBoolean(key, false)
        }
    }
}