
JAVAFILES = src/main/java/xquery/*.java src/main/java/xquery/antlr/*.java

JAVALIB = /usr/local/lib/antlr-4.5-complete.jar:/usr/local/lib/saxon9-xqj.jar

.PHONY: all
all:
	mkdir -p bin
	javac -d bin/ -nowarn -Xlint -cp $(JAVALIB) $(JAVAFILES)

.PHONY:	test
test:
	mkdir -p out
	java -cp $(JAVALIB):bin/ xquery.QueryProcessor test/test1.xql out/output.xml

.PHONY: rewrite-test
rewrite-test:
	mkdir -p out
	java -cp $(JAVALIB):bin/ xquery.QueryRewriter test/test2.xql out/rewritten.xql

.PHONY: clean
clean:
	rm -rf bin out
