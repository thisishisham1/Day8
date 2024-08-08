package klivvr.test.day8.data.models


import com.google.gson.annotations.SerializedName


data class Reviews(

    @SerializedName("rating") val rating: Int? ,
    @SerializedName("comment") val comment: String? ,
    @SerializedName("date") val date: String? ,
    @SerializedName("reviewerName") val reviewerName: String? ,
    @SerializedName("reviewerEmail") val reviewerEmail: String?

)