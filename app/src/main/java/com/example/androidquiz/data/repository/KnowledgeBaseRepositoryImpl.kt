package com.example.androidquiz.data.repository

import com.example.androidquiz.data.local.KnowledgeBaseDatabase
import com.example.androidquiz.data.mapper.toContents
import com.example.androidquiz.data.mapper.toKnowledgeBaseEntity
import com.example.androidquiz.data.mapper.toKnowledgeBaseItem
import com.example.androidquiz.data.mapper.toKnowledgeBaseItemEntity
import com.example.androidquiz.data.mapper.toRecords
import com.example.androidquiz.data.remote.KnowledeBaseApi
import com.example.androidquiz.domain.model.Contents
import com.example.androidquiz.domain.model.KnowledgeBaseItem
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
    private val db: KnowledgeBaseDatabase,
    private val api: KnowledeBaseApi
): KnowledgeBaseRepository {

    val dao = db.dao

    override suspend fun getKnowledgeBase(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<KnowledgeBaseItem>>> {
        return flow {
            emit(Resource.Loading(true))
            val knowledge = dao.searchKnowledgeBase(query)
            emit(Resource.Success(
                data = knowledge.map {
                    it.toKnowledgeBaseItem()
                })
            )
            val isDBempty = knowledge.isEmpty() && query.isBlank()
            val shouldJustFetchFromCache = !isDBempty && !fetchFromRemote
            if (shouldJustFetchFromCache) {  // We got cached data and sent it,
                emit(Resource.Loading(isLoading = false))
                return@flow  // ..we're done here!
            }
            /*
            * Continue onward to refresh cache.
            * */
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

            remoteKnowledgeBaseContents?.records?.let { records_dto_list ->
                dao.clearKnowledgeBase()
                dao.populateKnowledgeBase(
                    records_dto_list.map { records_dto ->
                        records_dto.toRecords().toKnowledgeBaseEntity()
                    }
                )
                emit(Resource.Success(
                    data = dao.searchKnowledgeBase("").map {
                        it.toKnowledgeBaseItem()
                    }
                ))
                emit(Resource.Loading(isLoading = false))
            }

            /*
            remoteKnowledgeBaseContents?.let { contents ->
                emit(Resource.Success(data=contents.toContents()))
                emit(Resource.Loading(isLoading = false))
            }
            */
        }  // end RET FLOW
    }  // end FUN
}
