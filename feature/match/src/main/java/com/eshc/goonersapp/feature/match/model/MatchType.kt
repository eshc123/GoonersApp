package com.eshc.goonersapp.feature.match.model

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

val MatchType: NavType<MatchUiModel> = object : NavType<MatchUiModel>(true) {

    override val name: String
        get() = "MatchType"

    override fun put(bundle: Bundle, key: String, value: MatchUiModel) {
        bundle.putParcelable(key, value as Parcelable?)
    }

    override fun get(bundle: Bundle, key: String): MatchUiModel? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): MatchUiModel {
        return Json.decodeFromString(URLDecoder.decode(value, StandardCharsets.UTF_8.toString()))
    }
}