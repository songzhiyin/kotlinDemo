package com.szy.lib.network.Retrofit.factory;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 版权：易金 版权所有
 * <p>
 * 作者：suntinghui
 * <p>
 * 创建日期：2018/11/21 0021 11:24
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 */
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(value.string());
//        } catch (Exception e) {
//            e.printStackTrace();
//            value.close();
//        }

        Reader reader = new StringReader(value.string());
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            T result = adapter.read(jsonReader);
            if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            return result;
        } finally {
            value.close();
        }
    }
}
