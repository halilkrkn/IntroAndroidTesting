package com.example.introtesting

// object kullandık çünkü test senaryolarımızda Class'lar için bir örnek oluşturmamak için kullanıldı. Ve bu sayede içindeki fonksiyonları doğrudan kullanabildik.(Zorunlu bir durum değil.)
object RegistrationUtil {

    // Varolan Kullanıcıların olduğunu düşünüp bu kullanıcıları listeye ekledik.
    private val existingUser = listOf("Ali","Ahmet")

    /*** TEST CASES
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits

     *** TEST SENARYOSU
     * ...Kullanıcı adı ve şifre boşsa,
     * ...Kullanıcı adi zaten varsa,
     * ...Sifre ile onaylama şifresi aynı değilse,
     * ...Şifre 2'den daha az rakam varsa,
     * ...GİRİŞ İŞLEMİ GEÇERLİ OLAMAZ.
    ***/

    // Test Senaryomuz için gereken fonksiyonumuz.
    fun validateRegistrationInput (
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        // Eğer username veya password boşsa bu iki durumla ilgili oluşturduğumuz 'empty username ve empty password 'testlerimiz çalışacak.
        if (username.isEmpty() || password.isEmpty()){
            return false
        }
        // Eğer username olarak zaten var olan bir username kullanıldıysa bu durumla ilgili olan 'username already exist' testi çalışacak.
        if (username in existingUser){
            return false
        }
        // Eğer password'ümüz confirmPassword ile eşleşmiyorsa ilgili test olan 'incorrectly confirmed password' testi çalışacak.
        if (password != confirmPassword){
            return false
        }
        // Eğer password'ümüz en az iki rakam içermiyorssa ilgili test olan 'less than 2 digit password' testi kullanılacak.
        if (password.count{it.isDigit()} < 2){
            return false
        }
        // Bu durum ise yukarıdaki tüm durumların dışında olan ve zaten olması gereken; kayıt olan yeni bir username ve password oluşacağı için doğru senaryo olan 'valid username and correctly repeated password' testi çalışacak.
        return true
    }


}