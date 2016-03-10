# Introduction #
This is the initial draft of how to create new Accessibility Rules for the automated Accessibility Checker code. We need to refine the documentation, relevant comments are welcome.

# Steps required #
  * Create the implementation for the rule as another new class in ` src/main/org/a11ytesting/test/wcag `

If the filter doesn't exist you will also need to do
  * Create a new Filter. Optionally you may choose to extend one of the Abstract classes.
  * Add an enum value for the new filter to Filter.java

Here's an example of creating a new Rule for `aria-activedescendant` (This is from git which I'm using locally).

```
#       modified:   src/main/org/a11ytesting/test/Filter.java
#
# Untracked files:
#   (use "git add <file>..." to include in what will be committed)
#
#       src/main/org/a11ytesting/filter/AriaActiveDescendantFilter.java
#       src/main/org/a11ytesting/test/wcag/AriaActiveDescendant.java
```

# Tips #
  * Name the new classes consistently e.g. AriaActiveDescendantFilter and AriaActiveDescendant
  * Add the enum in alphabetical order to `Filter.java`
  * Find an example web page that contains examples of the code you want to test e.g. http://test.cita.uiuc.edu/aria/radio/radio2.php for `aria-activedescendant`
  * Remember to write a unit test for your new Rule :)