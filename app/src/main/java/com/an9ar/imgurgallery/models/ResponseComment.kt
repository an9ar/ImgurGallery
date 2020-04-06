package com.an9ar.imgurgallery.models

open class ResponseComment {
    var success: Boolean = false
    var status: Int = 0
    private var data: List<Comment>? = null

    override fun toString(): String {
        return "CommentResponse{" +
                "success=" + success +
                ", status=" + status +
                ", data=" + data!![0] +
                '}'.toString()
    }

    fun getData(): List<Comment>? {
        return data
    }
}