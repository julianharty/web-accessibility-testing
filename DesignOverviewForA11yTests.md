# Introduction #

Overview of a11ytesting design concerns.


# Rule Interface #
The primary interface used for implementing a rule match is the org.a11ytesting.test.Rule. The intention is that a rule is applied to a single element to which it may pass or fail. For example an anchor link rule would return a filter that could be applied to a collection of elements and the rule will be called for all instances returned by the filter. The goal is that check(Element) should be run for a single element at a time and return null if there is no issue or an instance of issue that is collected by the evaluator.

Packages containing implementations of the rule interface are then loaded using the Evaluator addPackage method.

The rule interface returns a filter instance so that an anonymous implementation can be returned to allow a high degree of flexibility and decoupling of filter implementations from the rest of the package.

# Filter #
The filter interface defines the methods supported by a filter implementation. The filter analogy is a little strained in this context because the items being filtered are hirarchical html document elements. The result is that the filter implementation library was originally intended to use inheritance to specialise and nest filters but it currently only uses the jSoup document selector functionality.

# Package Loading #
The Evaluator supports loading arbitrary package combinations using the add method. The example class shows how easily it can be used to achieve application of a rule set to a given document.