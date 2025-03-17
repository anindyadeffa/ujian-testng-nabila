package com.juaracoding.ujian2;

/*
Note: TestNG saat menggunakan anotasi IllegalArgument Exception hanya memverifikasi bahwa
pengecualian (exception) terjadi, tetapi tidak menampilkan pesan pengecualian secara otomatis.
 */

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    private ATM saldoATM; // Defined variabel saldoATM dari ATM

    @BeforeMethod
    public void setSaldoATM() {
        saldoATM = new ATM(1000); // Set saldoATM sebesar 1000
    }

    /*
    Menguji melihat saldoATM telah mengembalikan saldo yang benar
     */
    @Test
    public void testLihatSaldo() {
        Assert.assertEquals(saldoATM.lihatSaldo(), 1000); // expected: 1000
    }

    /*
    Menguji metode setorUang dengan benar ketika jumlah yang valid disetor
     */
    @Test
    public void testSetorUang() {
        saldoATM.setorUang(4500); // 4500 + 1000 (Saldo Awal)
        Assert.assertEquals(saldoATM.lihatSaldo(), 5500); // expected: 5500

    }

    /*
    Menguji metode setorUang melempar pengecualian ke IllegalArgumentException
    ketika jumlah yang negatif di setor
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        saldoATM.setorUang(-50); // setorUang dengan jumlah negatif -50 (karena jumlah > 0)
    }

    /*
    Menguji metode TarikUang dengan benar ketika jumlah yang valid disetor
     */
    @Test
    public void testTarikUang() {
        saldoATM.tarikUang(200); // 1000 (Saldo Awal) - 200
        Assert.assertEquals(saldoATM.lihatSaldo(), 800); // expected: 800
    }

    /*
    Menguji metode tarikUang melempar pengecualian ke IllegalArgumentException
    ketika jumlah yang di tarik melebihi saldo awal
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        saldoATM.tarikUang(3000); // 1000 (Saldo Awal) - 3000 = "Saldo tidak mencukupi"
    }

    /*
    Menguji metode tarikUang melempar pengecualian ke IllegalArgumentException
    ketika jumlah yang negatif di setor
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        saldoATM.tarikUang(-150); // tarikUang dengan jumlah negatif -150 (karena jumlah > 0 && jumlah <= saldo)
    }

}
