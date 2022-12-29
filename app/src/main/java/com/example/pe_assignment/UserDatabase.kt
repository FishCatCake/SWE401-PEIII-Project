package com.example.pe_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class,UserCancerPhrase::class,CancerRecord::class], version = 5, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun usercancerphraseDao(): UserCancerPhraseDAO
    abstract fun usercancerrecordDao(): CancerRecordDAO

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var userDao = database.userDao()
                    var usercancerphraseDao = database.usercancerphraseDao()
                    var usercancerrecordDao = database.usercancerrecordDao()
                    // Delete all content here.
                    userDao.deleteAll()
                    usercancerphraseDao.deleteAll()
                    usercancerrecordDao.deleteAll()

//                    // Add sample words.
                    var user = User(0,"Sample","Sample","Sample","Sample")
                    userDao.insert(user)
                    var cuser = UserCancerPhrase(0,"Sample","1")
                    usercancerphraseDao.insert(cuser)
                    var crecord = CancerRecord(0,"Sample","Sample","Sample","Sample","Sample","Sample","1")
                    usercancerrecordDao.insert(crecord)

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
                    "x_database"
                )
                    .addCallback(UserDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
