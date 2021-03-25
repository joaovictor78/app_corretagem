package repositories

import android.content.Context

interface  IBrokersRepository{
    fun getBrokers()
}
class BrokersRepository(val context: Context): IBrokersRepository {
    override fun getBrokers() {

    }
}