package ph.stacktrek.novare.ecommerce.tuliao.sammuel.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import ph.stacktrek.novare.ecommerce.tuliao.sammuel.adapters.DatabaseHandler
import ph.stacktrek.novare.ecommerce.tuliao.sammuel.model.Product

interface ProductDAO {

    fun addProduct(product: Product)
    fun getProducts() : ArrayList<Product>
    fun updateProduct(product: Product)
    fun deleteProduct(product: Product)
}

class ProductDAOStubImplementation: ProductDAO{

    private var productList: ArrayList<Product> = ArrayList()
    init{
        productList.add(Product("Microphone"))
        productList.add(Product("Keyboard Wired"))
        productList.add(Product("Monitor"))
        productList.add(Product("Mouse Wireless"))
        productList.add(Product("Keyboard Wireless"))
        productList.add(Product("Mouse Wired"))
        productList.add(Product("Motherboard"))
        productList.add(Product("HDD"))
        productList.add(Product("SSD"))
        productList.add(Product("CPU"))
    }

    override fun addProduct(product: Product) {
        productList.add(product)
    }

    override fun getProducts(): ArrayList<Product> = productList

    override fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(product: Product) {
        TODO("Not yet implemented")
    }
}

class ProductDAOSQLLiteImplementation(var context: Context): ProductDAO{
    override fun addProduct(product: Product) {
        val databaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.TABLE_PRODUCT_NAME, product.name)
        var status = db.insert(DatabaseHandler.TABLE_PRODUCT,
        null,contentValues)
        db.close()
    }

    override fun getProducts(): ArrayList<Product> {
        val databaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase

        var result = ArrayList<Product>()
        var cursor: Cursor? = null

        val columns = arrayOf(DatabaseHandler.TABLE_PRODUCT_ID,DatabaseHandler.TABLE_PRODUCT_NAME)
        try {

            cursor = db.query(DatabaseHandler.TABLE_PRODUCT,
            columns,null,null,null,null,null)

        }catch (sqlException: SQLException){
            db.close()
            return result
        }

        if(cursor.moveToFirst()){
            do{
                var product = Product("")
                product.name = cursor.getString(1)
                product.id = cursor.getInt(0).toString()
                result.add(product)
            }while (cursor.moveToNext())
        }

        return result
    }

    override fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(product: Product) {
        TODO("Not yet implemented")
    }


}