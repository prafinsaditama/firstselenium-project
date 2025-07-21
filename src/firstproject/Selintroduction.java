package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Selintroduction {

    // Fungsi untuk mengambil screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Buat folder screenshots jika belum ada
            File directory = new File("screenshots");
            if (!directory.exists()) {
                directory.mkdir();
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("screenshots/" + fileName + ".png"));
            System.out.println("[✓] Screenshot diambil: " + fileName);

            Thread.sleep(1000); // Delay agar tampilan stabil sebelum lanjut
        } catch (IOException e) {
            System.out.println("[✗] Gagal mengambil screenshot: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("[✗] Gagal delay screenshot: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/Prafinda Sutan A/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
            System.out.println("[✓] Website dibuka");
            takeScreenshot(driver, "01_Website_Dibuka");
            System.out.println("[✓] Title is: " + driver.getTitle());
        } catch (Exception e) {
            System.out.println("[✗] Gagal membuka website: " + e.getMessage());
        }

        // Username
        try {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            System.out.println("[✓] Username berhasil diisi");
            takeScreenshot(driver, "02_Username_Diisi");
        } catch (Exception e) {
            System.out.println("[✗] Gagal mengisi username: " + e.getMessage());
        }

        // Password
        try {
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            System.out.println("[✓] Password berhasil diisi");
            takeScreenshot(driver, "03_Password_Diisi");
        } catch (Exception e) {
            System.out.println("[✗] Gagal mengisi password: " + e.getMessage());
        }

        // Klik Login
        try {
            driver.findElement(By.id("login-button")).click();
            System.out.println("[✓] Tombol Login berhasil diklik");
            takeScreenshot(driver, "04_Login_Berhasil");
        } catch (Exception e) {
            System.out.println("[✗] Gagal klik tombol Login: " + e.getMessage());
        }

        // Klik Menu
        try {
            Thread.sleep(2000); // Pastikan halaman selesai render
            driver.findElement(By.id("react-burger-menu-btn")).click();
            System.out.println("[✓] Tombol Menu berhasil diklik");
            Thread.sleep(2000); // Pastikan halaman selesai render
            takeScreenshot(driver, "05_Menu_Dibuka");
        } catch (Exception e) {
            System.out.println("[✗] Gagal klik tombol Menu: " + e.getMessage());
        }

        // Logout
        try {
            Thread.sleep(1000); // Delay agar menu tampil sepenuhnya
            driver.findElement(By.id("logout_sidebar_link")).click();
            System.out.println("[✓] Tombol Logout berhasil diklik");
            takeScreenshot(driver, "06_Logout_Berhasil");
        } catch (Exception e) {
            System.out.println("[✗] Gagal klik tombol Logout: " + e.getMessage());
        }

        // Cek URL akhir
        try {
            System.out.println("[✓] Status Login URL: " + driver.getCurrentUrl());
            takeScreenshot(driver, "07_Status_URL");
        } catch (Exception e) {
            System.out.println("[✗] Gagal mendapatkan status URL: " + e.getMessage());
        }

        // Tutup browser
        driver.quit();
        System.out.println("[✓] Browser ditutup");
    }
}
