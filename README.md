wicket-console
==============

Wicket Console for JVM 1.6+

Key features:

1. Very small size (<25Kb)
2. Ajax enabled
3. Contextual
  * ScriptContext has been stored on server side: you can write function and then call from subsequent commands
4. Embeddedable into your wicket pages
5. Available throught Wicket DebugBar panel
  * Dependency to wicket-devutils is optional

Installation
------------
To use wicket console library in your code add following into your pom.xml
```xml
		<dependency>
		      <groupId>ru.ydn.wicket.wicket-console</groupId>
		      <artifactId>wicket-console</artifactId>
		      <version>1.0</version>
		</dependency>
```

Then you should either enable Wicket DebugBar in your code. 
```java
public class MyPage extends WebPage {

	public MyPage(final PageParameters parameters) {
		super(parameters);
...
		add(new DebugBar("debugBar"));
    }
}

```

or you can add WicketConsolePanel on a required page
```java
public class MyPage extends WebPage {

	public MyPage(final PageParameters parameters) {
		super(parameters);
...
    add(new WicketConsolePanel("console"));
    }
}

```

Demo
----

Build project:
```bash
cd wicket-console
mvn clean install
```
Run demo:
```bash
cd wicket-console-demo
mvn jetty:run
```
Then goto http://localhost:8081/

Examples
--------
Print all properties of application
```javascript
for(var p in org.apache.wicket.Application.get())
{
   println(p);
}
```

Math calculation
```javascript
1+Math.sin(1)*2
```

