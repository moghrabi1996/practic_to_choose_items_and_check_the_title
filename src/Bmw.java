import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bmw {
	
	
	public WebDriver driver;
	
	String carName = "Ford";
	
	SoftAssert softassert = new SoftAssert();
	

	@BeforeTest
	public void this_is_before_test() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://jo.opensooq.com/en");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[6]/div/div[2]/ul/li[1]/div[2]/h3[1]/a")).click();
		
		
		
	}
	
	@Test(testName = "1")
	public void chose_the_car() {
		driver.findElement(By.xpath("//*[@id=\"Brand\"]/div")).click();
		List <WebElement> typesOfCars =  driver.findElements(By.className("bgSizeBrand"));
		for(int i=0 ; i<typesOfCars.size();i++) {
		if(typesOfCars.get(i).getText().contains(carName)) {
			typesOfCars.get(i).click();
		}
		}
		driver.findElement(By.xpath("//*[@id=\"landingPostDynamicField\"]/div/button")).click();
		driver.findElement(By.className("postLink")).click();
		String title_Of_First_Item=	driver.findElement(By.className("noEmojiText")).getText();
		//System.out.println(title_Of_First_Item);		
		driver.findElement(By.xpath("//*[@id=\"searchBox\"]")).sendKeys(title_Of_First_Item);
		driver.findElement(By.xpath("//*[@id=\"searchNavBar\"]")).click();
		
//		
//		
//		driver.findElement(By.xpath("//*[@id=\"landingPostDynamicField\"]/div/button")).click();
		
	}
	@Test()
	public void check_all_contains_char() {
	List <WebElement> title=	driver.findElements(By.className("notEg"));
	for(int i=0 ; i<title.size();i++) {
	String result =  title.get(i).getText();
	softassert.assertEquals(result.contains(carName), true);
	softassert.assertAll();
	}
	}
	
	
//	@Test()
//	public void Get_The_Title_of_First_Items(){
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
//	String title_Of_First_Item=	driver.findElement(By.className("postLink")).getText();
//		System.out.println(title_Of_First_Item);
//	}
	
//	@Test()
//	public void check_class_name () {
//		//driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("bmw" + Keys.ENTER);
//        List <WebElement> bmwNameResult = 	 driver.findElements(By.className("Z26q7c"));
//	    for(int i=0 ; i<bmwNameResult.size();i++) {
//		String result = bmwNameResult.get(i).getText();
//		System.out.println(result);
//	}
//	}

}
