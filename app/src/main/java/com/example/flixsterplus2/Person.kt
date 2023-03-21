package com.example.flixsterplus2

    import com.google.gson.annotations.SerializedName

    data class Person(
        @SerializedName("name")
        var name: String? = null,

        @SerializedName("profile_path")
        val profilePath: String? = null,

        @SerializedName("overview")
        var overview: String? = null,

        @SerializedName("poster_path")
        var posterPath: String? = null,

        @SerializedName("original_title")
        var originalTitle: String? = null

    ) : java.io.Serializable {
    }
