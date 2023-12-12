# sortable-js-facade

### See [DEMO](http://projects.scalapro.net/sortable-js-facade/)

## a scala.js facade for the [Sortable.js](https://github.com/RubaXa/Sortable)


+ [Quick Start](https://github.com/Kremlianski/sortable-js-facade/blob/master/README.md#quick-start)
+ [class Sortable](https://github.com/Kremlianski/sortable-js-facade/blob/master/README.md#class-sortable)
+ [Companion](https://github.com/Kremlianski/sortable-js-facade/blob/master/README.md#companion)
+ [Events](https://github.com/Kremlianski/sortable-js-facade/blob/master/README.md#events)
+ [SortableProps trait](https://github.com/Kremlianski/sortable-js-facade/blob/master/README.md#sortableprops-trait)
+ [Utils object](https://github.com/Kremlianski/sortable-js-facade/blob/master/README.md#utils-object)



## Quick Start
Add to **build.sbt**:

```scala
libraryDependencies ++= Seq(
  "net.scalapro" %%% "sortable-js-facade" % "1.0.0"
)

```  

You should also get sortablejs lib:

```
   npm i sortablejs
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


## Companion
It has only one but very useful method __apply__, which is a facade for native static __create__ method. It allows to do this:
```scala
Sortable(el1)
Sortable(el2, options)

```

## Events
See [example](http://exxo.ru/projects_scalapro/sortable-js-facade/#example12)
### EventS (Sortable event)

+ to: HTMLElement — list, in which moved element.
+ from: HTMLElement — previous list
+ item: HTMLElement — dragged element
+ oldIndex: Number | undefined — old index within parent
+ newIndex: Number | undefined — new index within parent

### EventM (Move Event)

+ to: HTMLElement
+ from: HTMLElement
+ dragged: HTMLElement
+ draggedRect: TextRectangle
+ related: HTMLElement — element on which have guided
+ relatedRect: TextRectangle


## SortableProps trait

You can use this trait to define options:

```scala
val prop = new SortableProps {
      override val group = "bar"
      override val animation = 100
    }
Sortable(el, prop)

```
### Members
___group___: _js.UndefOr[String | js.Any]_ - defines a group name or an object

__sort__: _js.UndefOr[Boolean]_ - sorting inside list

__delay__: _js.UndefOr[Int]_ - time in milliseconds to define when the sorting should start

__disable__: _js.UndefOr[Boolean]_ - disables the sortable if set to true.

__store__: _js.UndefOr[js.Any]_ - an object

__animation__: _js.UndefOr[Int]_ - ms, animation speed moving items when sorting, `0` — without animation

__handle__: _js.UndefOr[String]_ - drag handle selector within list items

__filter__: _js.UndefOr[String]_ - selectors that do not lead to dragging (String or Function)

__draggable__: _js.UndefOr[String]_ - specifies which items inside the element should be draggable

__ghostClass__: _js.UndefOr[String]_ - class name for the drop placeholder

__chosenClass__: _js.UndefOr[String]_ - class name for the chosen item

__dragClass__: _js.UndefOr[String]_ - class name for the dragging item

__dataIdAttr__: _js.UndefOr[String]_

__forceFallback__: _js.UndefOr[Boolean]_ - ignore the HTML5 DnD behaviour and force the fallback to kick in

__fallbackClass__: _js.UndefOr[String]_ - class name for the cloned DOM Element when using forceFallback

__fallbackOnBody__: _js.UndefOr[Boolean]_ - appends the cloned DOM Element into the Document's Body

__fallbackTolerance__: _js.UndefOr[Int]_ - specifies in pixels how far the mouse should move before it's considered as a drag.

__scroll__: _js.UndefOr[Boolean | Element]_ - HTMLElement

__scrollFn__: _js.UndefOr[js.Function3[Int, Int, Event, Unit]]_ - function(offsetX, offsetY, originalEvent) { ... }, if you have custom scrollbar scrollFn may be used for autoscrolling

__scrollSensitivity__: _js.UndefOr[Int]_ - px, how near the mouse must be to an edge to start scrolling.

__scrollSpeed__: _js.UndefOr[Int]_ - px

__setData__: _js.UndefOr[js.Function2[DataTransfer, Element,Unit]]_ - sets data to the DataTransfer object of HTML5 DragEvent

__onChoose__: _js.UndefOr[js.Function1[EventS, Unit]]_ -  Element is chosen

__onStart__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Element dragging started
  
__onEnd__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Element dragging ended

__onAdd__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Element is dropped into the list from another list

__onUpdate__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Changed sorting within list

__onSort__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Called by any change to the list (add / update / remove)

__onRemove__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Element is removed from the list into another list

__onFilter__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Attempt to drag a filtered element

__onMove__: _js.UndefOr[js.Function2[EventM, Event, Unit]]_ - Event when you move an item in the list or between lists

__onClone__: _js.UndefOr[js.Function1[EventS, Unit]]_ - Called when creating a clone of element


## Utils object
A set of useful static methods.

__on(el: Node, event: String, fn: js.Function1[Event, Unit]): Unit__ - attaches an event handler function

__off(el: Node, event: String, fn: js.Function1[Event, Unit]): Unit__ - removes an event handler

__css(el: Node): js.Object__ - gets the values of all the CSS properties

__css(el: Node, prop: String): js.Any__ - get the value of style properties

__css(el: Node, prop: String, value: String): Unit__ - sets one CSS property

__find(ctx: Node, tagName: String): js.Array[Node]__ - gets elements by tag name

__find(ctx: Node, tagName: String, iterator: js.Function2[Node, Int, Unit]): js.Array[Node]__ - gets elements by tag name

__bind(ctx: js.Any, fn: js.Function): js.Function__ - takes a function and returns a new one that will always have a particular context

__is(el: Node, selector: String): Boolean__ - check the current matched set of elements against a selector

__closest(el: Node, selector: String, ctx: Node): js.UndefOr[Node]__  or 
__closest(el: Node, selector: String): js.UndefOr[Node]__ - for each element in the set, gets the first element that matches the selector by testing the element itself and traversing up through its ancestors in the DOM tree

__clone(el:Node): Node__ -  creates a deep copy of the set of matched elements

__toggleClass(el: Node, name: String, state: Boolean): Uni__ - adds or removes a class from each element






### See [DEMO](http://exxo.ru/projects_scalapro/sortable-js-facade/)      
### See code of [examples](https://github.com/Kremlianski/scalajs-sortable-demos)


### See also an [example with scalajs-react](https://github.com/Kremlianski/monix-react-sortable)



