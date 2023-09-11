package com.example.androidquiz.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [KnowledgeBaseEntity::class],
    version = 2,
    exportSchema = true
)
abstract class KnowledgeBaseDatabase: RoomDatabase() {
    abstract val dao: KnowledgeBaseDao
}
