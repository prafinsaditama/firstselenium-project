package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LoginLockUser {
	
	// Path folder utama + subfolder nama class
    static String baseFolder = System.getProperty("user.dir") + File.separator + "screenshots";
    static String subFolderName = LoginLockUser.class.getSimpleName();
    static String fullFolderPath = baseFolder + File.separator + subFolderName;

    // Fungsi untuk mengambil screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Buat folder screenshots jika belum ada
            File directory = new File("fullFolderPath");
            if (!directory.exists()) {
                directory.mkdir();
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(fullFolderPath + File.separator + fileName + ".png"));
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
            driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
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
