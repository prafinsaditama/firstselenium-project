package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelRegistration {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/Prafinda Sutan A/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			// Buka halaman register
			try {
				driver.manage().window().maximize();
				driver.get("https://sauce-demo.myshopify.com/account/register");
				System.out.println("[✓] Website register dibuka");
			} catch (Exception e) {
				System.out.println("[✗] Gagal membuka website: " + e.getMessage());
			}

			// Tampilkan judul halaman
			try {
				System.out.println("[✓] Title is: " + driver.getTitle());
			} catch (Exception e) {
				System.out.println("[✗] Gagal mendapatkan title: " + e.getMessage());
			}

			// Tunggu sebentar agar elemen termuat
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("[!] Delay terganggu: " + e.getMessage());
			}

			// Isi First Name
			try {
				driver.findElement(By.xpath("//input[@type='text' and @name='customer[first_name]']")).sendKeys("John");
				System.out.println("[✓] First Name berhasil diisi");
			} catch (Exception e) {
				System.out.println("[✗] Gagal mengisi First Name: " + e.getMessage());
			}

			// Isi Last Name
			try {
				driver.findElement(By.name("customer[last_name]")).sendKeys("Doe");
				System.out.println("[✓] Last Name berhasil diisi");
			} catch (Exception e) {
				System.out.println("[✗] Gagal mengisi Last Name: " + e.getMessage());
			}

			// Isi Email
			try {
				driver.findElement(By.name("customer[email]")).sendKeys("johndoe@gmail.com");
				System.out.println("[✓] Email berhasil diisi");
			} catch (Exception e) {
				System.out.println("[✗] Gagal mengisi Email: " + e.getMessage());
			}

			// Isi Password
			try {
				driver.findElement(By.name("customer[password]")).sendKeys("password123");
				System.out.println("[✓] Password berhasil diisi");
			} catch (Exception e) {
				System.out.println("[✗] Gagal mengisi Password: " + e.getMessage());
			}

			// Klik tombol daftar
			try {
				driver.findElement(By.xpath("//input[@value='Create']")).click();
				System.out.println("[✓] Tombol Daftar berhasil diklik");
			} catch (Exception e) {
				System.out.println("[✗] Gagal klik tombol Daftar: " + e.getMessage());
			}
			
			/*
			// Klik tombol skip captcha
			try {
				driver.findElement(By.xpath("/html/body/div/div[3]/div[3]")).click();
				System.out.println("[✓] Tombol Capthca berhasil diklik");
			} catch (Exception e) {
				System.out.println("[✗] Gagal klik tombol Captcha: " + e.getMessage());
			}
			*/

		} catch (Exception e) {
			System.out.println("[✗] Terjadi kesalahan umum: " + e.getMessage());
		}
	}
}
