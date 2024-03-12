import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import netscape.javascript.JSObject;
import okhttp3.*;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SmilesAut {

    AndroidDriver driver ;

    @BeforeTest
    public void setUp () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","13");
        caps.setCapability("app","C:\\Users\\saraa\\Downloads\\Smiles.apk");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appwaitPacakge","ae.etisalat.smiles");
        caps.setCapability("appwaitAtivity","ae.etisalat.smiles.login.ui.login.LoginActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

    }

    public void waitSeconds(AndroidElement w){
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.visibilityOf(w));

    }

    public void scrollDown(AndroidElement element){
//        Dimension screenDimension = driver.manage().window().getSize();
//        int screenSize = screenDimension.getHeight();
//        int screenStart = (int) (screenSize*0.8);
//        int screenEnd = (int)(screenSize*0.2);
//
//        AndroidTouchAction actions = new AndroidTouchAction(driver);
//        actions.press(PointOption.point(0,screenStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).
//                moveTo(PointOption.point(0,screenEnd)).release().perform();
        int startX = element.getLocation().getX();
        int startY = element.getLocation().getY();

        int endX = startX;
        int endY= startY - 4500;
        AndroidTouchAction action = new AndroidTouchAction( driver);
        action.press(ElementOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(ElementOption.point(endX, endY))
                .release()
                .perform();
    }

//    public void clickAction(AndroidElement a){
//        a.click();
//    }

    public void enterKeys(AndroidElement k , String a){
        k.click();
        Actions action = new Actions(driver);
        action.sendKeys(a).perform();
    }

    @Test(priority = 1)
    public void clickSkipLogin() throws InterruptedException {
        Thread.sleep(3000);
        waitSeconds((AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Skip to login\"]"));
        driver.findElementByXPath("//android.widget.TextView[@text=\"Skip to login\"]").click();
    }

    @Test (priority =2)
        public void enterAccount(){
        waitSeconds((AndroidElement) driver.findElementByClassName("android.widget.EditText"));
           AndroidElement account= (AndroidElement) driver.findElementByClassName("android.widget.EditText");
           enterKeys(account,"543938266");
        }

        @Test(priority=3)
        public void clickOtpBtn(){
        waitSeconds((AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Send Code\"]"));
        driver.findElementByXPath("//android.widget.TextView[@text=\"Send Code\"]").click();
        }

        @Test(priority = 4)
    public void enterOTP() throws InterruptedException {
        Thread.sleep(3000);
        waitSeconds((AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[1]"));
            AndroidElement otp1= (AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[1]");
            enterKeys(otp1,"7");
            AndroidElement otp2= (AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[2]");
            enterKeys(otp2,"8");
            AndroidElement otp3= (AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[3]");
            enterKeys(otp3,"6");
            AndroidElement otp4= (AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[4]");
            enterKeys(otp4,"7");
            AndroidElement otp5= (AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[5]");
            enterKeys(otp5,"8");
            AndroidElement otp6= (AndroidElement) driver.findElementByXPath("//android.widget.EditText/android.widget.TextView[6]");
            enterKeys(otp5,"6");
            Thread.sleep(5000);

        }

        @Test(priority = 5)
        public void exploreAll(){
        waitSeconds((AndroidElement) driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"ae.etisalat.smiles:id/navigation_bar_item_icon_view\"])[3]"));
        driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"ae.etisalat.smiles:id/navigation_bar_item_icon_view\"])[3]").click();

        }

        @Test (priority = 6)
    public void scrollTelecom() throws InterruptedException {
        Thread.sleep(3000);
        waitSeconds((AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Food Pickup\"]"));
        scrollDown((AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Food Pickup\"]"));
            AndroidTouchAction touchAction = new AndroidTouchAction( driver);
            touchAction.tap(ElementOption.element(driver.findElementByXPath("//android.widget.TextView[@text=\"Telecom\"]"))).perform();
            Thread.sleep(2000);

        }

        @Test (priority = 7)
    public void selectDevices(){
        waitSeconds((AndroidElement) driver.findElementByXPath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]"));
        driver.findElementByXPath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]").click();
        }

        @Test (priority = 8)
    public void selectSamsumngDevice(){

        driver.findElementByXPath("(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ae.etisalat.smiles:id/rv_colors\"])[1]").click();
        }

        @Test (priority = 9)
        public void selectColor(){
        waitSeconds((AndroidElement) driver.findElementById("ae.etisalat.smiles:id/circle_color"));
        driver.findElementById("ae.etisalat.smiles:id/circle_color").click();
        }

        @Test (priority = 10)
        public void selectStorage(){
        driver.findElementById("ae.etisalat.smiles:id/tv_internal_storage").click();
        }
        @Test (priority = 11)
        public void clickBuyNow(){
        driver.findElementById("ae.etisalat.smiles:id/tv_buy_now").click();
        }
        @Test (priority =12)
        public void selectOneTimePayment(){
        driver.findElementById("ae.etisalat.smiles:id/checkedText").click();
        }
    @Test (priority = 13)
    public void assertPriceAPIS() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://www.etisalat.ae/b2c/eshop/getDeviceSku/bgSku3804197268' /")
                .get()
                .addHeader("Cookie", "CMS-cookie=2702428056.47873.0000")
                .build();
         Response response = client.newCall(request).execute();
         String responseBody = response.body().string();
        JSONObject jsonValue = new JSONObject(responseBody);
       String price = jsonValue.optString("listPriceIncVat");
       String expectedValue= "4725";
       Assert.assertEquals(expectedValue,price);


    }
}




