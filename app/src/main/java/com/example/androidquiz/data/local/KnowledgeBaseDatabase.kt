package com.example.androidquiz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [KnowledgeBaseEntity::class],
    version = 1
)
abstract class KnowledgeBaseDatabase: RoomDatabase() {
    abstract val dao: KnowledgeBaseDao
}