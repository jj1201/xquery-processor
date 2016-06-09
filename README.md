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
This processor is mainly based on the ANTLR4 parser and ANTLR4 visitor. Generated from the *XQuery.g4* grammar file, the parser would first parse the input query and generate a query tree. Out visitor then start to traverse the tree from the root. For each different type nodes, we define different actions, like opening target XML file or create new element.

### How To Run It
In order to run this java project, you need to have following libraries in your */usr/local/bin/* directory:
  - antlr4-4.5-complete.jar
  - saxon9-xqj.jar

Of course you can put them else where or use different versions, but then you may need to modify the *Makefile* by yourself to make sure it can be compiled correctly.
~~~~
make:           to make the project
make test:      to process the example query
make join-test: to rewrite the example query
make clean:     to remove all generated files
~~~~

### Reference

[UCSD CSE232B SP16](http://cseweb.ucsd.edu/classes/sp16/cse232B-a/)

### Author
Chang Li & Jiajia Chen @ UCSD
