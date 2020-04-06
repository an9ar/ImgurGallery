package com.an9ar.imgurgallery.models

open class Comment {
    var id: Long? = 0.toLong()
    var image_id: String? = null
    var comment: String? = null
    var author: String? = null
    var author_id: Long? = 0.toLong()
    var on_album: Boolean = false
    var album_cover: String? = null
    var ups: Long = 0.toLong()
    var downs: Long = 0.toLong()
    var points: Long = 0.toLong()
    var datetime: String? = null
    var parent_id: String? = null
    var deleted: Boolean = false

    override fun toString(): String {
        return "Comment{" +
                "id='" + id + '\'' +
                ", image_id='" + image_id + '\''.toString() +
                ", comment='" + comment + '\''.toString() +
                ", author='" + author + '\''.toString() +
                ", author_id=" + author_id +
                ", on_album=" + on_album +
                ", album_cover=" + album_cover + '\''.toString() +
                ", ups=" + ups +
                ", downs=" + downs +
                ", points=" + points +
                ", datetime='" + datetime + '\''.toString() +
                ", parent_id=" + parent_id + '\''.toString() +
                ", deleted='" + deleted
    }
}