package listeners;

import io.qameta.allure.Allure;
import org.testng.*;
import utils.LogsManager;
import utils.ScreenShot;

public class TestNGListeners implements ITestListener, IExecutionListener, IInvokedMethodListener {


    @Override
    public void onExecutionStart(){
        LogsManager.info("test execution started ");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        LogsManager.info("test case passed " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result){
        LogsManager.info("test case failed " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        LogsManager.info("test cases has skipped " + result.getName());
    }

    // this methode to attach groups to allure
    @Override
    public void beforeInvocation(IInvokedMethod method,ITestResult result){

        String[] groups = result.getMethod().getGroups();
        for (String group: groups){
            Allure.label("tag",group);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result){
        if (method.isTestMethod()){
            switch (result.getStatus()){
                case ITestResult.SUCCESS :
                    ScreenShot.takeScreenShot(result.getName());
                    break;

                case ITestResult.FAILURE:
                    ScreenShot.takeScreenShot("test case failed" + result.getName());
                    break;
                case ITestResult.SKIP:
                    ScreenShot.takeScreenShot("test case skipped" + result.getName());
                    break;

                default:
                    LogsManager.info("test methode" + method.getTestMethod().getMethodName() + " has no status");

            }
        }
    }
}
