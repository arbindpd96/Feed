package com.example.feed.networking

import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException


val networkModule = module {
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideGoFitApi(get()) }
    single { provideRetrofit(get(), get()) }
    single { providesMoshiConverter() }
}

val VOID_JSON_ADAPTER: Any = object : Any() {
    @FromJson
    @Throws(IOException::class)
    fun fromJson(reader: JsonReader): Void? {
        return reader.nextNull()
    }

    @ToJson
    @Throws(IOException::class)
    fun toJson(writer: JsonWriter, v: Void?) {
        writer.nullValue()
    }
}

class ArrayListMoshiAdapter {
    @ToJson
    fun arrayListToJson(list: ArrayList<Int>): List<Int> = list

    @FromJson
    fun arrayListFromJson(list: List<Int>): ArrayList<Int> = ArrayList(list)
}


fun providesMoshiConverter(): Moshi =
    Moshi.Builder().add(VOID_JSON_ADAPTER).add(KotlinJsonAdapterFactory())
        .add(ArrayListMoshiAdapter()).build()

fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
    Retrofit.Builder().baseUrl("https://gofit.fitness").client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    (OkHttpClient().newBuilder()).addInterceptor(loggingInterceptor).build()

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY
    return logger
}

fun provideGoFitApi(retrofit: Retrofit): FeedApi = retrofit.create(FeedApi::class.java)

