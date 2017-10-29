/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Open Website button is clicked. It will open the website
     * specified by the URL represented by the variable urlAsString using implicit Intents.
     *
     * @param v Button that was clicked.
     */
    public void onClickOpenWebpageButton(View v) {
        // TODO (5) Create a String that contains a URL ( make sure it starts with http:// or https:// )]
        String URL = "http://google.com";

        // TODO (6) Replace the Toast with a call to openWebPage, passing in the URL String from the previous step
        openWebPage(URL);
    }

    /**
     * This method is called when the Open Location in Map button is clicked. It will open the
     * a map to the location represented by the variable addressString using implicit Intents.
     *
     * @param v Button that was clicked.
     */
    public void onClickOpenAddressButton(View v) {
        Uri gmmIntentUri = Uri.parse("geo:43.3039993,76.9233602?q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    /**
     * This method is called when the Share Text Content button is clicked. It will simply share
     * the text contained within the String textThatYouWantToShare.
     *
     * @param v Button that was clicked.
     */
    public void onClickShareTextButton(View v) {
        Toast.makeText(this, "TODO: Share text when this is clicked", Toast.LENGTH_LONG).show();
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Here some text");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    /**
     * This is where you will create and fire off your own implicit Intent. Yours will be very
     * similar to what I've done above. You can view a list of implicit Intents on the Common
     * Intents page from the developer documentation.
     *
     * @see <http://developer.android.com/guide/components/intents-common.html/>
     *
     * @param v Button that was clicked.
     */
    public void createYourOwn(View v) {
        Intent intent = new Intent(MainActivity.this, MyActivity.class);
        startActivity(intent);
    }

    // TODO (1) Create a method called openWebPage that accepts a String as a parameter
    // Do steps 2 - 4 within openWebPage
    public void openWebPage(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "You can not open this website", Toast.LENGTH_LONG).show();
        }
    }

        // TODO (2) Use Uri.parse to parse the String into a Uri

        // TODO (3) Create an Intent with Intent.ACTION_VIEW and the webpage Uri as parameters

        // TODO (4) Verify that this Intent can be launched and then call startActivity
}