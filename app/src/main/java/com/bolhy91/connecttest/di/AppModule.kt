package com.bolhy91.connecttest.di

import android.app.Application
import androidx.room.Room
import com.bolhy91.connecttest.data.local.ConnectDatabase
import com.bolhy91.connecttest.data.local.PersonDao
import com.bolhy91.connecttest.data.remote.CommentApi
import com.bolhy91.connecttest.utils.Api.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
    }

    @Provides
    @Singleton
    fun provideCommentApi(retrofit: Retrofit): CommentApi {
        return retrofit.create(CommentApi::class.java)
    }

    @Provides
    @Singleton
    fun provideConnectDatabase(app: Application): ConnectDatabase {
        return Room.databaseBuilder(
            app, ConnectDatabase::class.java, "connect.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePersonDao(appDatabase: ConnectDatabase): PersonDao {
        return appDatabase.personDao()
    }
}