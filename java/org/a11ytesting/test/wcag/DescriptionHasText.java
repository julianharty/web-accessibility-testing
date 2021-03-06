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

import org.a11ytesting.filter.SummaryFilter;
import org.a11ytesting.test.Filter;
import org.a11ytesting.test.Issue;
import org.a11ytesting.test.Issue.Severity;
import org.jsoup.nodes.Element;

/**
 * Rule for description element has text.
 * 
 * @author dallison
 */
public class DescriptionHasText extends AbstractUnderstandableRule {

	@Override
	public String getRuleName() {
		return "checkDescriptionHasText";
	}

	@Override
	public Filter getFilter() {
		return new SummaryFilter();
	}
	
	/**
	 * Check that text summary elements have text content
	 * 
	 * @see http://openajax-dev.jongund.webfactional.com/wcag20/rule/80/
	 * @see http://openajax-dev.jongund.webfactional.com/wcag20/rule/81/
	 * 
	 * @param label to check
	 * @return issue or null
	 */
	@Override
	public Issue check(Element label) {
		if (label.hasText() && !label.text().trim().isEmpty()) {
			return null;
		}
		return new Issue("checkDescriptionHasText",
				"Check that label or legend element has text content",
				Severity.ERROR, label);
	}
}