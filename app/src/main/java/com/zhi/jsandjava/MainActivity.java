package com.zhi.jsandjava;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.zhi.Service.ContactService;
import com.zhi.domain.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends Activity {
	private WebView contentWebView = null;
	private ContactService contactService;
	private static String phone;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		contentWebView = (WebView) findViewById(R.id.webview);
		contentWebView.getSettings().setJavaScriptEnabled(true);
		contentWebView.loadUrl("file:///android_asset/index.html");

		contactService = new ContactService();
		contentWebView.addJavascriptInterface(this, "contact");
	}

	@JavascriptInterface
	public void call(final String phone){
		this.phone = phone;
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone));
				startActivity(intent);
			}
		});
	}

	@JavascriptInterface
	public void showcontacts(){
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					List<Contact> contacts = contactService.getContacts();
					JSONArray jsonArray = new JSONArray();
					for(Contact c : contacts){
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("name", c.getName());
						jsonObject.put("amount", c.getAmount());
						jsonObject.put("phone", c.getPhone());
						jsonArray.put(jsonObject);
					}
					String json = jsonArray.toString();
					contentWebView.loadUrl("javascript:show('"+ json + "')");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}