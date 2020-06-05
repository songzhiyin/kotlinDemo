package com.szy.kotlindemo.db

interface OnLoadLisetener<T> {
    fun onSucced(data: T)
}