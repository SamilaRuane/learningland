package com.cursokotlin.storewars.repository

import android.content.Context
import com.cursokotlin.storewars.business.ApiHelperImpl
import com.cursokotlin.storewars.entity.StarWarsItem
import com.cursokotlin.storewars.entity.Transaction

/**
 * Created by samila on 15/10/17.
 */
class DataManagerImpl  : DataManager {


     var mDbHelper : TransactionRepository
     var mSharedPreferenceHelper : SharedPreferenceHelper

    constructor(ctx:Context){
        mDbHelper = TransactionRepositoryImpl (ctx)
        mSharedPreferenceHelper = SharedPreferencesHelperImpl (ctx)
    }



    override fun getAllItens(): List<StarWarsItem> {
        return ApiHelperImpl.getAllItens()
    }

    override fun save(transaction: Transaction) {
        mDbHelper.save(transaction)
    }

    override fun delete(transaction: Transaction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveShopping(itens: List<StarWarsItem>) {
        mSharedPreferenceHelper.saveShopping(itens)
    }

    override fun recoveryShoppingCart(): MutableList<StarWarsItem> {
        return mSharedPreferenceHelper.recoveryShoppingCart()
    }

    override fun select(query: String?): MutableList<Transaction> {
        return mDbHelper.select(query)
    }
}