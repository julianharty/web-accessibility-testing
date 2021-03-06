/*
Copyright 2009 web-accessibility-testing committers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

/**
 * Simple example of tabbing through Google Search Results.
 */
package org.julianharty.accessibility.automation;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchResults extends TestCase {

	private static final int MAXIMUM_TAB_COUNT = 300;
	private static final int MINIMUM_TAB_COUNT = 20;

	public void testTabbingThroughGoogleSearchResults() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		  
		driver.get("http://www.google.co.uk/search?q=cheese");
		int maxTabsToEnter = MAXIMUM_TAB_COUNT;
		int tabs = KeyboardHelpers.tabThroughWebPage(driver, maxTabsToEnter);
		assertTrue(
			String.format("Expected at least %02d tabs, only needed " + tabs, MINIMUM_TAB_COUNT),
			tabs > MINIMUM_TAB_COUNT);
	}
}
