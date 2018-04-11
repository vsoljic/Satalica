package tvz.android.satalica.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import tvz.android.satalica.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
