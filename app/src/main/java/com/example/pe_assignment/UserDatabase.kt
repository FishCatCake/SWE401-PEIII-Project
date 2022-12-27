package com.example.pe_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var userDao = database.userDao()

                    // Delete all content here.
                    userDao.deleteAll()

//                    // Add sample words.
                    var user = User(0,"Sample","Sample","Sample","Sample")
                    userDao.insert(user)
                }
            }
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): UserDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "u_database"
                )
                    .addCallback(UserDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}