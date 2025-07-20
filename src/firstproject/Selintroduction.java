package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selintroduction {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/Prafinda Sutan A/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://sauce-demo.myshopify.com/");
			System.out.println("[✓] Website dibuka");
			System.out.println("[✓] Title is: " + driver.getTitle());
		} catch (Exception e) {
			System.out.println("[✗] Gagal membuka website: " + e.getMessage());
		}
		
		// Login user
		try {
			driver.findElement(By.xpath("//*[@id=\"customer_login_link\"]")).click();
			System.out.println("[✓] Tombol Login berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Login: " + e.getMessage());
		}

		try {
			driver.findElement(By.xpath("//*[@id=\"customer_email\"]")).sendKeys("prafindasutan@gmail.com");
			System.out.println("[✓] Username berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi username: " + e.getMessage());
		}

		try {
			driver.findElement(By.xpath("//*[@id=\"customer_password\"]")).sendKeys("okeberhasil");
			System.out.println("[✓] Password berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi password: " + e.getMessage());
		}

		try {
			driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[5]/input")).click();
			System.out.println("[✓] Tombol Login berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Login: " + e.getMessage());
		}

		try {
			System.out.println("[✓] Status Login URL: " + driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("[✗] Gagal mendapatkan status URL: " + e.getMessage());
		}

		driver.quit();
		System.out.println("[✓] Browser ditutup");

	}
}