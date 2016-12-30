# sortable-js-facade
##a scala.js facade for the [Sortable.js](https://github.com/RubaXa/Sortable)

Add to **build.sbt**:

```scala
libraryDependencies ++= Seq(
  "net.scalapro" %%% "sortable-js-facade" % "0.2-SNAPSHOT"
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

or using the companion object:
```scala
Sortable(dom.document.getElementById("items"))
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
## class Sortable
### Constructor

```scala
new Sortable(element, options)
```
__element__:org.scalajs.dom.Element - an html element that contains a list of elements to be sorted

__options__: js.Any - a plain javascript object of options. You can use js.Dictionary, js.Dynamic.literal. Or you can use the SortableProps trait (see below). The full list of options is described [here](https://github.com/RubaXa/Sortable#options). Can be _null_. Then all options take their default values.

###Methods


      
      
      
###See [examples](https://github.com/Kremlianski/scalajs-sortable-demos)

###See [DEMO](http://projects.scalapro.net/sortable-js-facade/)

