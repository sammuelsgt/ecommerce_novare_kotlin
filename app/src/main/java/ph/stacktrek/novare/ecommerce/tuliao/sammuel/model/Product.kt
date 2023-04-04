package ph.stacktrek.novare.ecommerce.tuliao.sammuel.model

import java.math.BigDecimal

class Product(var name: String) {
    lateinit var id: String
    lateinit var price: BigDecimal
    lateinit var brand: String
    lateinit var measurement: String
    lateinit var description : String
    var measurementUnit: MeasurementUnit = MeasurementUnit.NOT_SET
    var quantity: Int = 0
}

enum class MeasurementUnit{
    KILOGRAMS,
    GRAMS,
    METER,
    TONS,
    NOT_SET
}