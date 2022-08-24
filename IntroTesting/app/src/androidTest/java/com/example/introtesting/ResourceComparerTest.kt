package com.example.introtesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest{

    // Buradaki test senaryolarımız bir android compenetlerinden bir bağlamı yani context'i içerdiğinden dolayı bu testimiz androidTest klasörümüzün içerisinde olması gerekir.
    // Ve buradaki test senaryoları da Emülatör üzerinden çalışmaktadır.


// Test senaryoları birbirinden bağımsız çalışmalıdır.
// Çünkü, bir sınıfın örneğini oluştururken Test class'ının içerisinde lateinit var ile initialize edip sonra da herbir test senaryosu içerisinde örneğini oluşturmalıyız.

    private lateinit var resourceComparer: ResourceComparer

    // Bu fonksiyona her test senaryosunun çalıştırılmasından önce yürütmek istediğimiz işlevi yazıyoruz.
    // Yani test senaryolarımızdan önce bu kod parçağı çalışacak.
    // Bunu da junit'in @Before Annotation'unu kullanıyoruz.
    @Before
    fun setup(){
        resourceComparer = ResourceComparer() // Mesela burda yukarda lateinit var ile Class'ı çağırdık ve bu test senaryolarına özel de örneğini oluşturduk.
    }


    // Tüm Test Senaryolarından sonra da @After annotation'u kullanılarak ilgili fonksiyonlar yazılabilir.
    // Örneğin;  Bir Room Database'i test edildiğinde, kapatmak isterseniz, her test durumundan sonra database bu şekilde @After annotation altına yazılan fonksiyon ile database'i tüm test senaryolarından sonra kapatabiliriz.
    @After
    fun teardown(){
    }

    // Burdaki Test senaryomuzda String kaynağına verilen String değerinin aynı olması durumunda true olarak dönderilmesi testtirdir.
    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context,R.string.app_name,"IntroTesting")
        assertThat(result).isTrue()
    }

    // Burdaki Test senaryomuzda String kaynağına verilen String değerinin farklı olması durumunda false olarak dönderilmesi testtirdir.
    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context,R.string.app_name,"Hello")
        assertThat(result).isFalse()
    }

}