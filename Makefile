
JAVAFILES = src/main/java/xquery/*.java src/main/java/xquery/antlr/*.java

JAVALIB = /usr/local/lib/antlr-4.5-complete.jar:/usr/local/lib/saxon9-xqj.jar:/usr/local/lib/javax.xml-1.3.4.jar

.PHONY: all
all:
	mkdir -p bin
	javac -d bin/ -nowarn -Xlint -cp $(JAVALIB) $(JAVAFILES)

.PHONY:	test
test:
	java -cp $(JAVALIB):bin/ xquery.QueryProcessor test/test.xql output.xml

.PHONY: clean
clean:
	rm -rf bin output.xml
