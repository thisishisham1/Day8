package klivvr.test.day8.data.models


import com.google.gson.annotations.SerializedName


data class Meta (

    @SerializedName("createdAt" ) val createdAt : String?,
    @SerializedName("updatedAt" ) val updatedAt : String?,
    @SerializedName("barcode"   ) val barcode   : String?,
    @SerializedName("qrCode"    ) val qrCode    : String?

)