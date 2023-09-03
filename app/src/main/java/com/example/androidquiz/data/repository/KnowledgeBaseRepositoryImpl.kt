package com.example.androidquiz.data.repository

import com.example.androidquiz.data.mapper.toContents
import com.example.androidquiz.data.remote.KnowledeBaseApi
import com.example.androidquiz.domain.model.Contents
import com.example.androidquiz.domain.repository.KnowledgeBaseRepository
import com.example.androidquiz.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KnowledgeBaseRepositoryImpl @Inject constructor(
    private val api: KnowledeBaseApi
): KnowledgeBaseRepository {
    override suspend fun getKnowledgeBase(): Flow<Resource<Contents>> {
        return flow {
            emit(Resource.Loading(true))
            val remoteKnowledgeBaseContents = try {
                api.getKnowledgeBase()
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Remote gave no response."))
                null
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Remote gave no response."))
                null
            }  // end TRY-CATCH

            remoteKnowledgeBaseContents?.let { contents ->
                emit(Resource.Success(data=contents.toContents()))
                emit(Resource.Loading(isLoading = false))
            }
        }  // end RET FLOW
    }  // end FUN
}
