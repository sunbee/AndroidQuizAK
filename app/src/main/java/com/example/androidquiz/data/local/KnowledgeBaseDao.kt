package com.example.androidquiz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidquiz.domain.model.KnowledgeBaseItem


@Dao
interface KnowledgeBaseDao {

    /* (C)RUD */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun populateKnowledgeBase(knowledgeBaseEntities: List<KnowledgeBaseEntity>)

    /* C(R)UD */
    @Query(
        """
            SELECT * 
            FROM KnowledgeBaseEntity
            WHERE LOWER(category) LIKE '%' || LOWER(:category) || '%'
        """
    )
    fun searchKnowledgeBase(category: String): List<KnowledgeBaseEntity>

    /* CRU(D) */
    @Query("DELETE FROM KnowledgeBaseEntity")
    fun clearKnowledgeBase()
}