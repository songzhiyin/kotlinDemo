package com.szy.kotlindemo.db.dao

interface OnLoadLisetener<T> {
    fun onSucced(data: T)
}