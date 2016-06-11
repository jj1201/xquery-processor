## XQuery Processor

### Overview
This is a simple XQuery processor implemented with *ANTLR4*, which has following features:
 - Only support a subset of XQuery grammar
 - Introduce a new "join" operator
 - Has a *XQuery rewriter*, which can rewrite some *for* clause with the *join* operator and improve the performance

### Supported XQuery Grammar
~~~~
XQ -> Var | StringConstant | ap | (XQ1) | XQ1, XQ2
    | XQ1/rp | XQ1//rp | <tagName>{XQ1}</tagName>
    | forClause letClause whereClause returnClause
    | letClause XQ1

forClause -> for Var1 in XQ1, Var2 in XQ2, ..., Varn in XQn

letClause -> empty | let Var1:=XQ1, ..., Varn:=XQn

whereClause -> empty | where Cond

returnClause -> return XQ

Cond -> XQ1 = XQ2 | XQ1 eq XQ2 | XQ1 == XQ2 | XQ1 is XQ2
      | empty(XQ) | some Var1 in XQ1, ..., staisfies XQ
      | (Cond) | Cond1 and Cond2 | Cond1 or Cond2 | not Cond
~~~~

### Join Operator and Query Rewriter
Consider the following query:
~~~~
for $b in doc("input")/book
    $a in doc("input")/entry
    $tb in $b/title
    $ta in $a/title
where $tb eq $ta
return <book-with-price>{
          $tb,
          <review>{ $a/price/text() }</review>
          <price>{ $b/price/text() }</price>
       }</book-with-price>
~~~~
Assume the query is evaluated on an input file with 10^5 books and 10^5 reviews. Then in the brute force evaluation, the *where* clause will be evaluated 10^10 times. which is unacceptable from a performance point of view. Here we use one more efficient way to evaluate the query:
  - collect a tuple set B, consisting of all tuples (b, tb) of books and their titles
  - collect a tuple set E, consisting of all tuples (a, ta) of entries and their titles
  - join the tuple sets B and E on the titles and derive a new tuple set R consisting of tuples (b, tb, a, ta)
  - produce a *book-with-price* element for each tuple of R

Following this idea, we can first rewrite the query like this:
~~~~
for $tuple in join(for $b in doc("input")/book,
                       $tb in $b/title
                    return <tuple>
                              <b>{ $b }</b>
                              <tb>{ $tb }</tb>
                           </tuple>,

                    for $a in doc("input")/entry,
                        $ta in $ta/title
                    return <tuple>
                              <a>{ $a }</a>
                              <ta>{ $ta }</ta>
                           </tuple>,

                    [tb], [ta]
                    )
return <book-with-price>{
          $tuple/tb/*,
          <review>{ $tuple/a/*/price/text() }</review>
          <price>{ $tuple/b/*/price/text() }</price>
       }</book-with-price>
~~~~
Then, we need to let the processor support the following grammer:
~~~~
XQ -> joinCluse
joinCluse -> join(XQ1, XQ2, attrList1, attrList2)
attrList  -> [tagName1, tagName2, ..., tagNameN]
~~~~
With all those done, we can now first rewrite the input and query and then process the rewritten query with the join operator.

### Implementation Details
- **XQuery and XML Parsing**: With the given g4 file, ANTLR4 can parse the query sentences and generate a parsed grammar tree; for the target XML file, we use the standard library to parse;
- **Query Evaluate**: Override each method of the generated parse tree visitor, then the whole evaluating process becomes a DFS traverse on the parse tree;
- **Variable Binding**: Use a global *```Stack<HashMap<Var, Value>>```* to store the binded variables. Every time we meet new var definition, we construct a new HashMap to store it and push it into the stack. Every time we leave the var defined environment, we pop it. To get the value of one variable, we just need to search from the stack's top to its bottom. This method makes it really easy to override the definition of one variable. Also, as the depth of the stack is generally small, this method is also efficient;
- **Join Algorithm**: We used the *Hash Join* in this project;
- **Query Rewriter**: We wrote a separate simplified g4 grammar file and corresponded visitor class as the rewriter. When doing the rewriting, the rewriter would first construct a *partition graph* for the variables in *for clause*, then cut the separately from the root and finally rewrite them as a nested join statement.

### How To Run It
In order to run this java project, you need to have following libraries in your */usr/local/bin/* directory:
  - antlr4-4.5-complete.jar
  - saxon9-xqj.jar

Of course you can put them else where or use different versions, but then you may need to modify the *Makefile* by yourself to make sure it can be compiled correctly.
~~~~
make:               to make the project
make test:          to process the example query
make rewrite-test:  to rewrite the example query
make clean:         to remove all generated files
~~~~

### Reference

[UCSD CSE232B SP16](http://cseweb.ucsd.edu/classes/sp16/cse232B-a/)

### Author
Chang Li & Jiajia Chen @ UCSD
