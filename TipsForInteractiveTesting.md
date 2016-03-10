# Introduction #

This site contains code to enable automated testing to discover potential accessibility and usability issues. Many of these issues can be found be testing interactively. This page contains some tips to help you perform the interactive tests.


# Details #
Many of the modern desktop web browsers enable users to specify a custom css stylesheet See http://www.squarefree.com/userstyles/user-style-sheets.html for a dated, but useful, overview of how to add stylesheets to Internet Explorer, Firefox and Opera.

## Firefox ##
An example userContent.css is available on this site at http://code.google.com/p/web-accessibility-testing/source/browse/trunk/assets/userContent.css The key setting is the one that tracks the current element selected by the keyboard. The relevant code fragment is:
```
:focus {
background-color: green ! important;
}
```

Note: this code can also be injected into an arbitrary web page using Firebug (one of my favourite Add-ons for Firefox).

# Links of interest #
  * http://www.squarefree.com/userstyles/user-style-sheets.html dated, but still relevant information about how to configure user style sheets for Firefox, Internet Explorer and Opera web browsers.
  * http://msdn.microsoft.com/en-us/library/bb158570.aspx Customizing IE with User Stylesheets.
  * http://www.curlewcommunications.co.uk/c-style2.html with several example css files for accessibility.
  * http://www.electrictoolbox.com/firefox-custom-user-styles/ some practical details of how to find your firefox profile in various operating systems.