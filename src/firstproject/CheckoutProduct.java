package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutProduct {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/Prafinda Sutan A/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			System.out.println("[✓] Website dibuka");
			System.out.println("[✓] Title is: " + driver.getTitle());
		} catch (Exception e) {
			System.out.println("[✗] Gagal membuka website: " + e.getMessage());
		}

		// Login user
		try {
			driver.findElement(By.xpath("//input[@id='user-name' and @placeholder='Username']\r\n" + ""))
					.sendKeys("standard_user");
			System.out.println("[✓] Username berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi username: " + e.getMessage());
		}

		try {
			driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']\r\n" + ""))
					.sendKeys("secret_sauce");
			System.out.println("[✓] Password berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi password: " + e.getMessage());
		}

		try {
			driver.findElement(By.xpath("//input[@type='submit' and @value='Login' and @id='login-button']\r\n" + ""))
					.click();
			System.out.println("[✓] Tombol Login berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Login: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//div[@data-test='inventory-item-name']\r\n" + "")).click();
			System.out.println("[✓] Tombol Klik Product berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Klik Product: " + e.getMessage());
		}

		// Klik detail produk
		try {
			driver.findElement(By.xpath("//div[@data-test='inventory-item-name']\r\n" + "")).click();
			System.out.println("[✓] Tombol Klik Product berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Klik Product: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//button[@data-test='add-to-cart']\r\n" + "")).click();
			System.out.println("[✓] Tombol Klik Add Product berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Klik Add Product: " + e.getMessage());
		}

		// Keranjang
		try {
			driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']\r\n" + "")).click();
			System.out.println("[✓] Tombol Klik Keranjang berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Keranjang Product: " + e.getMessage());
		}

		// Checkout
		try {
			driver.findElement(By.xpath("//button[normalize-space(text())='Checkout']\r\n" + "")).click();
			System.out.println("[✓] Tombol Klik checkout product berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol checkout Product: " + e.getMessage());
		}

		// Information Checkout
		try {
			driver.findElement(By.xpath("//input[@id='first-name' and @placeholder='First Name']\r\n" + ""))
					.sendKeys("Prafins");
			System.out.println("[✓] First name berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi First name: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//input[@id='last-name' and @placeholder='Last Name']\r\n" + ""))
					.sendKeys("Aditama");
			System.out.println("[✓] Last name berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi Last name: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//input[@id='postal-code' and @data-test='postalCode']\r\n" + ""))
					.sendKeys("11480");
			System.out.println("[✓] Zip Code berhasil diisi");
		} catch (Exception e) {
			System.out.println("[✗] Gagal mengisi Zip Code: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//input[@type='submit' and @id='continue' and @value='Continue']\r\n" + ""))
					.click();
			System.out.println("[✓] Tombol Continue berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Continue: " + e.getMessage());
		}
		// Payment
		try {
			driver.findElement(
					By.xpath("//button[@class='btn btn_action btn_medium cart_button' and @id='finish']\r\n" + ""))
					.click();
			System.out.println("[✓] Tombol Finish berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Finish: " + e.getMessage());
		}
		try {
			driver.findElement(
					By.xpath("//button[@class='btn btn_primary btn_small' and @id='back-to-products']\r\n" + ""))
					.click();
			System.out.println("[✓] Tombol Back to Home berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Back to Home: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn' and text()='Open Menu']\r\n" + ""))
					.click();
			System.out.println("[✓] Tombol Menu berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Menu: " + e.getMessage());
		}
		// Tunggu sebentar agar elemen termuat
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("[!] Delay terganggu: " + e.getMessage());
		}
		try {
			driver.findElement(By.xpath("//a[@data-test='logout-sidebar-link']\r\n" + "")).click();
			System.out.println("[✓] Tombol Logout berhasil diklik");
		} catch (Exception e) {
			System.out.println("[✗] Gagal klik tombol Logout: " + e.getMessage());
		}

		try {
			System.out.println("[✓] Status Login URL: " + driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("[✗] Gagal mendapatkan status URL: " + e.getMessage());
		}
		//Close browser
		driver.quit();
		System.out.println("[✓] Browser ditutup");
	}

}
