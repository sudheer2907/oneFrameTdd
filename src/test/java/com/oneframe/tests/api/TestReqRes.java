package com.oneframe.tests.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.oneframe.helper.ReqResHelper;
import com.oneframe.testnglistener.TestNGListeners;
import com.oneframe.utils.LogPrinter;

import junit.framework.Assert;

public class TestReqRes {

  @Test(priority = 1, enabled = false)
  public void testGetUserDetailsApi() throws JSONException {
    JSONObject getUserDetailsApiRes = ReqResHelper.getUserDetails();
    LogPrinter.printLog("Get user details api response:" + getUserDetailsApiRes);
    Assert.assertTrue(Integer.parseInt(getUserDetailsApiRes.getString("page")) == 2);
    Reporter.log("per_page count is correct");
    Assert.assertTrue(Integer.parseInt(getUserDetailsApiRes.getString("per_page")) == 6);
    Reporter.log("Page count is correct");
    Assert.assertTrue(Integer.parseInt(getUserDetailsApiRes.getString("total")) == 12);
    Reporter.log("total count is correct");
    Assert.assertTrue(Integer.parseInt(getUserDetailsApiRes.getString("total_pages")) == 2);
    Reporter.log("total_pages count is correct");
    int dataArrLen = getUserDetailsApiRes.getJSONArray("data").length();
    JSONArray dataJsonArr = getUserDetailsApiRes.getJSONArray("data");
    for (int i = 0; i < dataArrLen; i++) {
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("id") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("email") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("first_name") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("last_name") != null);
      Assert.assertTrue(dataJsonArr.getJSONObject(i).get("avatar") != null);
    }
  }

  @Test(priority = 1, enabled = true)
  public void readXml() {

  }

  @Test(priority = 1, enabled = false, retryAnalyzer = TestNGListeners.class)
  public void testGetUserDetailsApi2() throws JSONException {
    Assert.fail();
  }

  @AfterClass
  public static void endTest() {}

}
