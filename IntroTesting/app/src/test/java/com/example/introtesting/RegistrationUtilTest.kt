package com.example.introtesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

// Bu kısımda ise tamamen oluşturduğumuz object üzerinden oluşturulan Test class'ımız.
class RegistrationUtilTest {

    // Buradaki test senaryomuzda eğer kullanıcı adı boşsa return olarak false döndermesini bekliyoruz.
    // Yani kullanıcı adı olmamasınının yanlış bir durum olduğunu test ettik.
    @Test
    fun `empty username returns false`(){
        // Burda RegistrationUtil objemiz içerisindeki validateRegistrationInput() fonksiyonumuzun parametrelerini doldurarak  registerInput değişekenimize atadık.
        val registrationInput = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        // Burda neden assertThat'i kullandık. Çünkü truth kütüphanesi;  daha okunaklı, daha anlaşılabilir ve kullanımı açısından daha gelişmiş bir kütüphane.
        // Burda ne yaptık: burda registrationInput değişkenimizi assertThat fonk. içerisine koyarak bir iddia oluşturduk. Bu iddiamızın kaynağı registrationInput değişkenimizdir.
        // ve sonrada isFalse() fonksiyonunu çağırdık ki bu test fonksiyonumuzun yanlış bir iddia olduğunu belirttik.
        assertThat(registrationInput).isFalse()

    }

    // Buradaki test senaryomuzda geçerli yeni bir username ve password durumunun doğru olduğu bir testtir.
    @Test
    fun `valid username and correctly repeated password returns true`() {
        val registrationInput = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "1234",
            "1234"
        )
        assertThat(registrationInput).isTrue()

    }

    // Buradaki test senaryomuzda geçerli var olan username'in olduğu bir testtir.
    @Test
    fun `username already exists returns false`() {
        val registrationInput = RegistrationUtil.validateRegistrationInput(
            "Ali",
            "123",
            "123"
        )
        assertThat(registrationInput).isFalse()
    }

    // Buradaki test senaryomuzda boş bir password'ün olduğu durumlarda false bir değer dönderildiği bir testtir.
    @Test
    fun `empty password return false`(){
        val registrationInput = RegistrationUtil.validateRegistrationInput(
            "Peter",
            "",
            ""
        )
        assertThat(registrationInput).isFalse()
    }

    // Buradaki test senaryomuzda password ile confirmPassword doğru şekilde eşleşmediği durumlarda false bir değer döndürülmesi durumu için yapılmış bir testtir.
    @Test
    fun `incorrectly confirmed password returns false`(){
        val registrationInput = RegistrationUtil.validateRegistrationInput(
            "Peter",
            "123",
            "123e"
        )
        assertThat(registrationInput).isFalse()
    }

    // Buradaki test senaryomuzda password'ümüzde en az 2 rakam olması şartını sağlayıp-sağlamadığı durumlar için yapılan testtir.
    // Burada tek bir rakam girildiği için false bir değerin döndürülmesi beklenmiştir.
    @Test
    fun `less than 2 digit password returns false`(){

        val registrationInput = RegistrationUtil.validateRegistrationInput(
            "Peter",
            "abcdfg5",
            "abcdfg5"
        )
        assertThat(registrationInput).isFalse()
    }

}