package firstproject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutProduct {

    static String baseFolder = System.getProperty("user.dir") + File.separator + "screenshots";
    static String subFolderName = CheckoutProduct.class.getSimpleName();
    static String fullFolderPath = baseFolder + File.separator + subFolderName;

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File folder = new File(fullFolderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(fullFolderPath + File.separator + fileName + ".png"));
            System.out.println("[✓] Screenshot diambil: " + fileName);
            Thread.sleep(1000); // Delay sedikit agar stabil
        } catch (IOException | InterruptedException e) {
            System.out.println("[✗] Gagal mengambil screenshot: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("[✗] Gagal membuka website: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            System.out.println("[✓] Username berhasil diisi");
            takeScreenshot(driver, "02_Username");
        } catch (Exception e) {
            System.out.println("[✗] Username error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            System.out.println("[✓] Password berhasil diisi");
            takeScreenshot(driver, "03_Password");
        } catch (Exception e) {
            System.out.println("[✗] Password error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("login-button")).click();
            System.out.println("[✓] Login diklik");
            takeScreenshot(driver, "04_Login");
        } catch (Exception e) {
            System.out.println("[✗] Login error: " + e.getMessage());
        }

        try {
            driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).click();
            System.out.println("[✓] Klik Produk");
            takeScreenshot(driver, "05_Pilih_Produk");
        } catch (Exception e) {
            System.out.println("[✗] Klik produk error: " + e.getMessage());
        }

        try {
            driver.findElement(By.xpath("//button[@data-test='add-to-cart']")).click();
            System.out.println("[✓] Tambah ke Keranjang");
            takeScreenshot(driver, "06_Add_To_Cart");
        } catch (Exception e) {
            System.out.println("[✗] Add to cart error: " + e.getMessage());
        }

        try {
            driver.findElement(By.className("shopping_cart_link")).click();
            System.out.println("[✓] Buka Keranjang");
            takeScreenshot(driver, "07_Keranjang");
        } catch (Exception e) {
            System.out.println("[✗] Buka keranjang error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("checkout")).click();
            System.out.println("[✓] Checkout diklik");
            takeScreenshot(driver, "08_Checkout");
        } catch (Exception e) {
            System.out.println("[✗] Checkout error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("first-name")).sendKeys("Prafins");
            driver.findElement(By.id("last-name")).sendKeys("Aditama");
            driver.findElement(By.id("postal-code")).sendKeys("11480");
            System.out.println("[✓] Data checkout diisi");
            takeScreenshot(driver, "09_Form_Checkout");
        } catch (Exception e) {
            System.out.println("[✗] Form checkout error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("continue")).click();
            System.out.println("[✓] Lanjutkan Checkout");
            takeScreenshot(driver, "10_Lanjutkan_Checkout");
        } catch (Exception e) {
            System.out.println("[✗] Lanjutkan error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("finish")).click();
            System.out.println("[✓] Pembayaran selesai");
            takeScreenshot(driver, "11_Finish");
        } catch (Exception e) {
            System.out.println("[✗] Finish error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("back-to-products")).click();
            System.out.println("[✓] Kembali ke produk");
            takeScreenshot(driver, "12_Back_To_Home");
        } catch (Exception e) {
            System.out.println("[✗] Back error: " + e.getMessage());
        }

        try {
            driver.findElement(By.id("react-burger-menu-btn")).click();
            Thread.sleep(1000);
            takeScreenshot(driver, "13_Open_Menu");
            driver.findElement(By.id("logout_sidebar_link")).click();
            System.out.println("[✓] Logout");
            takeScreenshot(driver, "14_Logout");
        } catch (Exception e) {
            System.out.println("[✗] Logout error: " + e.getMessage());
        }

        try {
            System.out.println("[✓] Status URL: " + driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("[✗] Cek URL error: " + e.getMessage());
        }

        driver.quit();
        System.out.println("[✓] Browser ditutup");
    }
}
