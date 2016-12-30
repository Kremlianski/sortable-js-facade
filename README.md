# sortable-js-facade
##a scala.js facade for the [Sortable.js](https://github.com/RubaXa/Sortable)

Add to **build.sbt**:

```scala
libraryDependencies ++= Seq(
  "net.scalapro" %%% "sortable-js-facade" % "0.1.1-SNAPSHOT"
)

//you can't add sortable.js 1.5.0 yet. If you need it, add it to html of the page manually
jsDependencies ++= Seq(
  "org.webjars.bower" % "github-com-RubaXa-Sortable" % "1.4.2"
    / "1.4.2/Sortable.js" minified "Sortable.min.js"
)
resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
```  
  
**Simple usage**:
```scala
new Sortable(dom.document.getElementById("items"), null)
```

**With options**:
```scala
val put: js.Function1[Sortable, js.Any] = {(to:Sortable ) => to.el.children.length < 4}

new Sortable(dom.document.getElementById("qux1"), js.Dictionary(
      "group" -> js.Dictionary(
        "name" -> "qux1",
        "put" -> put),
      "animation" -> 100

    )
 )
```

###See [examples](https://github.com/Kremlianski/scalajs-sortable-demos)

###See [DEMO](http://projects.scalapro.net/sortable-js-facade/)

