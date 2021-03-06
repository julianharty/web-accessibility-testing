/* Copyright 2011 eBay Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.a11ytesting.test.wcag;

import org.a11ytesting.test.Rule;

/**
 * Abstract parent class of Web Content Accessibility Guidelines rule set.
 * 
 * @see http://www.w3.org/TR/WCAG20/ - Web Content Accessibility Guidelines.
 * 
 * @author dallison
 */
abstract class AbstractWcagRule implements Rule {

	/**
	 * Define the top level suite name for all WCAG rules.
	 * 
	 * @return suite name.
	 */
	@Override
	public String getSuiteName() {
		return AbstractWcagRule.class.getPackage().getName();
	}
}
