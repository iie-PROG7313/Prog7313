package com.fake.starsuck

import androidx.room.*

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<Product>

    @Delete
    suspend fun delete(product: Product)
}
