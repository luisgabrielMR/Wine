// Caminho: com.example.wine.data.local/AppDatabase.java
package com.example.wine.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.wine.data.local.dao.AppUserDao;
import com.example.wine.data.local.dao.ClientDao;
import com.example.wine.data.local.dao.RegionDao;
import com.example.wine.data.local.dao.RepresentativeDao;
import com.example.wine.data.local.dao.SaleDao;
import com.example.wine.data.local.dao.SaleItemDao;
import com.example.wine.data.local.dao.WineDao;
import com.example.wine.data.local.dao.WineStockDao;
import com.example.wine.data.local.dao.WineryDao;
import com.example.wine.data.local.entity.AppUserEntity;
import com.example.wine.data.local.entity.ClientEntity;
import com.example.wine.data.local.entity.RegionEntity;
import com.example.wine.data.local.entity.RepresentativeEntity;
import com.example.wine.data.local.entity.SaleEntity;
import com.example.wine.data.local.entity.SaleItemEntity;
import com.example.wine.data.local.entity.WineEntity;
import com.example.wine.data.local.entity.WineStockEntity;
import com.example.wine.data.local.entity.WineryEntity;

// ATENÇÃO: A versão do banco de dados foi incrementada.
// Para produção, você precisaria implementar uma Migration.
@Database(entities = {WineryEntity.class, WineEntity.class, AppUserEntity.class, RepresentativeEntity.class, ClientEntity.class, SaleEntity.class, SaleItemEntity.class, RegionEntity.class, WineStockEntity.class}, version = 16) // VERSÃO ATUALIZADA
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract WineryDao wineryDao();
    public abstract WineDao wineDao();
    public abstract AppUserDao appUserDao();
    public abstract RepresentativeDao representativeDao();
    public abstract ClientDao clientDao();
    public abstract SaleDao saleDao();
    public abstract SaleItemDao saleItemDao();
    public abstract RegionDao regionDao();
    public abstract WineStockDao wineStockDao(); // NOVO MÉTODO

    public static synchronized AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "wine_app.db")
                    .fallbackToDestructiveMigration() // ATENÇÃO: Não use em produção sem Migrations
                    .build();
        }
        return INSTANCE;
    }
}