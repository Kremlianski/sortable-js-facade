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
__element__: _org.scalajs.dom.Element_ - an html element that contains a list of elements to be sorted

__options__: _js.Any_ - a plain javascript object of options. You can use _js.Dictionary_, _js.Dynamic.literal_. Or you can use the _SortableProps_ trait (see below). The full list of options is described [here](https://github.com/RubaXa/Sortable#options). Can be _null_. Then all options take their default values.

###Methods

__option(name: String): js.Dynamic__ - returns the value of the option

__option(name: String, value: js.Any): Unit__ - set a new value of the option

__closest(el: Node, selector: String): js.UndefOr[Node]__ or __closest(el: Node): js.UndefOr[Node]__ - for each element in the set, get the first element that matches the selector by testing the element itself and traversing up through its ancestors in the DOM tree.

__toArray(): js.Array[String]__ - serializes the sortable's item data-id's (dataIdAttr option) into an array of string.

__sort(order: js.Array[String]): Unit__ - sorts the elements according to the array

__save(): Unit__ - saves the current sorting

__destroy(): Unit__ - removes the sortable functionality completely


##Companion
It has only one but very useful method __apply__, which is a facade for native static __create__ method. It allows to do this:
```scala
Sortable(el1)
Sortable(el2, options)

```

##Events
See [example](http://projects.scalapro.net/sortable-js-facade/#example12)
###EventS (Sortable event)

+ to: HTMLElement — list, in which moved element.
+ from: HTMLElement — previous list
+ item: HTMLElement — dragged element
+ oldIndex: Number | undefined — old index within parent
+ newIndex: Number | undefined — new index within parent

###EventM (Move Event)

+ to: HTMLElement
+ from: HTMLElement
+ dragged: HTMLElement
+ draggedRect: TextRectangle
+ related: HTMLElement — element on which have guided
+ relatedRect: TextRectangle


##SortableProps trait

You can use this trait to define options:

```scala
val prop = new SortableProps {
      override val group = "bar"
      override val animation = 100
    }
Sortable(el, prop)

```
###Members
___group___: js.UndefOr[String | js.Any] - defines a group name or an object

__sort__: js.UndefOr[Boolean] - sorting inside list

__delay__: js.UndefOr[Int] - time in milliseconds to define when the sorting should start

__disable__: js.UndefOr[Boolean] - disables the sortable if set to true.

__store__: js.UndefOr[js.Any] = an object

__animation__: js.UndefOr[Int] -ms, animation speed moving items when sorting, `0` — without animation

__handle__: js.UndefOr[String] - drag handle selector within list items

__filter__: js.UndefOr[String] - selectors that do not lead to dragging (String or Function)

__draggable__: js.UndefOr[String] - specifies which items inside the element should be draggable

__ghostClass__: js.UndefOr[String] - class name for the drop placeholder

__chosenClass__: js.UndefOr[String] - class name for the chosen item

__dragClass__: js.UndefOr[String] - class name for the dragging item

__dataIdAttr__: js.UndefOr[String]

__forceFallback__: js.UndefOr[Boolean] - ignore the HTML5 DnD behaviour and force the fallback to kick in

__fallbackClass__: js.UndefOr[String] - class name for the cloned DOM Element when using forceFallback

__fallbackOnBody__: js.UndefOr[Boolean] - appends the cloned DOM Element into the Document's Body

__fallbackTolerance__: js.UndefOr[Int] - specifies in pixels how far the mouse should move before it's considered as a drag.

__scroll__: js.UndefOr[Boolean | Element] - HTMLElement

__scrollFn__: js.UndefOr[js.Function3[Int, Int, Event, Unit]] - function(offsetX, offsetY, originalEvent) { ... }, if you have custom scrollbar scrollFn may be used for autoscrolling

__scrollSensitivity__: js.UndefOr[Int] - px, how near the mouse must be to an edge to start scrolling.

__scrollSpeed__: js.UndefOr[Int] - px

__setData__: js.UndefOr[js.Function2[DataTransfer, Element,Unit]] - sets data to the DataTransfer object of HTML5 DragEvent

__onChoose__: js.UndefOr[js.Function1[EventS, Unit]] -  Element is chosen

__onStart__: js.UndefOr[js.Function1[EventS, Unit]] - Element dragging started
  
__onEnd__: js.UndefOr[js.Function1[EventS, Unit]] - Element dragging ended

__onAdd__: js.UndefOr[js.Function1[EventS, Unit]] - Element is dropped into the list from another list

__onUpdate__: js.UndefOr[js.Function1[EventS, Unit]] - Changed sorting within list

__onSort__: js.UndefOr[js.Function1[EventS, Unit]] - Called by any change to the list (add / update / remove)

__onRemove__: js.UndefOr[js.Function1[EventS, Unit]] - Element is removed from the list into another list

__onFilter__: js.UndefOr[js.Function1[EventS, Unit]] - Attempt to drag a filtered element

__onMove__: js.UndefOr[js.Function2[EventM, Event, Unit]] - Event when you move an item in the list or between lists

__onClone__: js.UndefOr[js.Function1[EventS, Unit]] - Called when creating a clone of element




      
###See [examples](https://github.com/Kremlianski/scalajs-sortable-demos)

###See [DEMO](http://projects.scalapro.net/sortable-js-facade/)

