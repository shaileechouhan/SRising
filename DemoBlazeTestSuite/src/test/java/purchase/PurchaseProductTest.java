package purchase;

import com.aventstack.extentreports.Status;
import conf.BaseTest;
import demoBlaze.helpers.jsonDataHelper.JsonTestDataHelper;
import demoBlaze.helpers.reportHelper.ReportManager;
import demoBlaze.models.OrderData;
import demoBlaze.models.Product;
import demoBlaze.models.testData.ProductSelection;
import demoBlaze.models.PurchaseData;
import demoBlaze.tasks.cart.GetOrder;
import demoBlaze.tasks.cart.Order;
import demoBlaze.tasks.home.SaveProduct;
import demoBlaze.tasks.home.SelectCategory;
import demoBlaze.tasks.home.SelectProduct;
import demoBlaze.tasks.navBar.SelectNav;
import demoBlaze.tasks.orderModal.FillOrder;
import demoBlaze.tasks.orderModal.IsOrderModalDisplayed;
import demoBlaze.tasks.orderModal.Purchase;
import demoBlaze.tasks.product.AddProduct;
import demoBlaze.tasks.product.GetProduct;
import demoBlaze.tasks.purchaseDoneModal.AcceptPurchase;
import demoBlaze.tasks.purchaseDoneModal.GetPurchase;
import demoBlaze.tasks.purchaseDoneModal.GetThankPurchase;
import demoBlaze.tasks.purchaseDoneModal.IsPurchaseDoneDisplayed;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PurchaseProductTest extends BaseTest {

    public static String purchaseTestDataPath = "resources/testdata/purchase/";

    @Test(description = "Verify product purchase by product name", dataProvider = "ProductPurchaseDataProvider")
    public void purchaseProductByName(ProductSelection product) throws IOException {
        ReportManager.getInstance().getTest().log(Status.INFO, "Test data:\nCategory:"+product.getCategory()+"\tProduct Name:"+ product.getName());
        SelectCategory.byName(driver, product.getCategory());
        int selectedProductPrice = SaveProduct.price(driver,product.getName());
        SelectProduct.byName(driver, product.getName());
        Product chosenProduct = GetProduct.info(driver);

        Assert.assertEquals(chosenProduct.getName(), product.getName(), "Name of product is not as selected previously");
        Assert.assertEquals(chosenProduct.getPrice(), selectedProductPrice, "Price of product is not as selected previously");
        AddProduct.toCart(driver);
        SelectNav.cart(driver);

        Product productInCar = GetOrder.info(driver);
        Assert.assertEquals(productInCar.getName(), product.getName(), "Name of product is not as selected previously");
        Assert.assertEquals(productInCar.getPrice(), selectedProductPrice, "Price of product is not as selected previously");
        Order.place(driver);

        OrderData orderData = new OrderData();
        Assert.assertTrue(IsOrderModalDisplayed.inView(driver), "Order modal is not visible as expected");
        FillOrder.withData(driver, orderData);
        Purchase.complete(driver);

        Assert.assertTrue(IsPurchaseDoneDisplayed.inView(driver), "Purchase done modal is not visible as expected");
        Assert.assertEquals(GetThankPurchase.text(driver), "Thank you for your purchase!", "Purchase thank is not visible");

        PurchaseData purchaseData = GetPurchase.info(driver);
        Assert.assertEquals(purchaseData.getName(), orderData.getName(), "Buyer name is not as set previously");
        Assert.assertEquals(purchaseData.getAmount(), selectedProductPrice, "Product price is not equal as the amount gotten previously");

        AcceptPurchase.done(driver);
    }

    @DataProvider(name="ProductPurchaseDataProvider")
    public Object[] productPurchaseDP() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(purchaseTestDataPath + "purchaseProduct.json", ProductSelection.class);
    }
}
