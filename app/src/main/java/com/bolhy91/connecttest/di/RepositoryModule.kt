package com.bolhy91.connecttest.di

import com.bolhy91.connecttest.data.repository.CommentRepositoryImpl
import com.bolhy91.connecttest.data.repository.FormRepositoryImpl
import com.bolhy91.connecttest.domain.repository.CommentRepository
import com.bolhy91.connecttest.domain.repository.FormRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCommentRepository(commentRepositoryImpl: CommentRepositoryImpl): CommentRepository

    @Binds
    @Singleton
    abstract fun bindFormRepository(formRepositoryImpl: FormRepositoryImpl): FormRepository
}