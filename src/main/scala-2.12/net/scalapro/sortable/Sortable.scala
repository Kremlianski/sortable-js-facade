package net.scalapro.sortable

import org.scalajs.dom._
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|


@ScalaJSDefined
trait EventS extends js.Object {
  val `type`: js.Any
  val to: js.Any
  val from: js.Any
  val item: js.Any
//  val clone: js.Any
  val oldIndex: js.Any
  val newIndex: js.Any
}

@ScalaJSDefined //move event
trait EventM extends js.Object {
  val `type`: js.Any
  val to: js.Any
  val from: js.Any
  val dragged: js.Any
  val draggedRect: js.Any
  val related: js.Any
  val relatedRect: js.Any
}


//this trait is very optional
@ScalaJSDefined
trait SortableProps extends js.Object {

  val group: js.UndefOr[String | js.Any] = js.undefined // or { name: "...", pull: [true, false, clone], put: [true, false, array] }
  val sort: js.UndefOr[Boolean] = js.undefined // sorting inside list
  val delay: js.UndefOr[Int] = js.undefined // time in milliseconds to define when the sorting should start
  val disable: js.UndefOr[Boolean] = js.undefined // Disables the sortable if set to true.
  val store: js.UndefOr[js.Any] = js.undefined // @see Store
  val animation: js.UndefOr[Int] = js.undefined // ms, animation speed moving items when sorting, `0` — without animation
  val handle: js.UndefOr[String] = js.undefined // Drag handle selector within list items
  val filter: js.UndefOr[String] = js.undefined // Selectors that do not lead to dragging (String or Function)
  val draggable: js.UndefOr[String] = js.undefined // Specifies which items inside the element should be draggable
  val ghostClass: js.UndefOr[String] = js.undefined // Class name for the drop placeholder
  val chosenClass: js.UndefOr[String] = js.undefined // Class name for the chosen item
  val dragClass: js.UndefOr[String] = js.undefined // Class name for the dragging item
  val dataIdAttr: js.UndefOr[String] = js.undefined
  val forceFallback: js.UndefOr[Boolean] = js.undefined // ignore the HTML5 DnD behaviour and force the fallback to kick in

  val fallbackClass: js.UndefOr[String] = js.undefined // Class name for the cloned DOM Element when using forceFallback
  val fallbackOnBody: js.UndefOr[Boolean] = js.undefined // Appends the cloned DOM Element into the Document's Body
  val fallbackTolerance: js.UndefOr[Int] = js.undefined // Specify in pixels how far the mouse should move before it's considered as a drag.

  val scroll: js.UndefOr[Boolean | Element] = js.undefined // or HTMLElement
  val scrollFn: js.UndefOr[js.Function3[Int, Int, Event, Unit]] = js.undefined //function(offsetX, offsetY, originalEvent) { ... }, if you have custom scrollbar scrollFn may be used for autoscrolling
  val scrollSensitivity: js.UndefOr[Int] = js.undefined // px, how near the mouse must be to an edge to start scrolling.
  val scrollSpeed: js.UndefOr[Int] = js.undefined // px

  /* DataTransfer dataTransfer, /** HTMLElement */dragEl) {
   *dataTransfer.setData('Text', dragEl.textContent); // `dataTransfer` object of HTML5 DragEvent
   * }, */
  val setData: js.UndefOr[js.Function2[DataTransfer, Element,Unit]] = js.undefined


  // Element is chosen
  /*function (/**Event*/evt) {
    evt.oldIndex;  // element index within parent
  } */
  val onChoose: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  // Element dragging started

  /*
  function (/**Event*/evt) {
  evt.oldIndex;  // element index within parent
  },
   */
  val onStart: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined

  /*
  function (/**Event*/evt) {
  evt.oldIndex;  // element's old index within parent
  evt.newIndex;  // element's new index within parent
  },
  */
  // Element dragging ended
  val onEnd: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  /*
   function (/**Event*/evt) {
   var itemEl = evt.item;  // dragged HTMLElement
   evt.from;  // previous list
   // + indexes from onEnd
  },
  */
  // Element is dropped into the list from another list
  val onAdd: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  /*
   function (/**Event*/evt) {
   var itemEl = evt.item;  // dragged HTMLElement
   // + indexes from onEnd
   },
   */
  // Changed sorting within list
  val onUpdate: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  /*
  function (/**Event*/evt) {
  // same properties as onUpdate
  },
  */
  // Called by any change to the list (add / update / remove)
  val onSort: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  /*
  function (/**Event*/evt) {
  // same properties as onUpdate
  },
  */
  // Element is removed from the list into another list
  val onRemove: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  /*
  function (/**Event*/evt) {
   var itemEl = evt.item;  // HTMLElement receiving the `mousedown|tapstart` event.
   },
   */
  // Attempt to drag a filtered element
  val onFilter: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined


  /*
  function (/**Event*/evt, /**Event*/originalEvent) {
  // Example: http://jsbin.com/tuyafe/1/edit?js,output
  evt.dragged; // dragged HTMLElement
  evt.draggedRect; // TextRectangle {left, top, right и bottom}
  evt.related; // HTMLElement on which have guided
  evt.relatedRect; // TextRectangle
  originalEvent.clientY; // mouse position
  // return false; — for cancel
  },
  */
  // Event when you move an item in the list or between lists
  val onMove: js.UndefOr[js.Function2[EventM, Event, Unit]] = js.undefined


  /*
  function (/**Event*/evt) {
  var origEl = evt.item;
  var cloneEl = evt.clone;
  }
  */
  // Called when creating a clone of element
  val onClone: js.UndefOr[js.Function1[EventS, Unit]] = js.undefined
}


@js.native
class Sortable(element: Element, props: js.Any) extends js.Any {
  val el: Element = js.native
  def option(name:String):js.Dynamic = js.native
  def option(name:String, value: js.Any):Unit = js.native
  def closest(el:Node, selector:String):js.UndefOr[Node] = js.native
  def closest(el:Node):js.UndefOr[Node] = js.native
  def toArray(): js.Array[String] = js.native
  def sort(order:js.Array[String]):Unit = js.native
  def save(): Unit = js.native
  def destroy(): Unit = js.native
}

@JSName("Sortable.utils")
@js.native
object Utils extends js.Object {
  def on(el:Node, event:String, fn: js.Function1[Event, Unit]):Unit = js.native
  def off(el:Node, event:String, fn: js.Function1[Event, Unit]):Unit = js.native
  def css(el:Node):js.Object = js.native
  def css(el:Node, prop:String):js.Any = js.native
  def css(el:Node, prop:String, value:String):Unit = js.native
  def find(ctx:Node, tagName:String):js.Array[Node] = js.native
  def find(ctx:Node, tagName:String, iterator:js.Function2[Node, Int, Unit]):js.Array[Node] = js.native
  def bind(ctx:js.Any, fn:js.Function):js.Function = js.native
  def is(el:Node, selector:String):Boolean = js.native
  def closest(el:Node, selector:String, ctx:Node):js.UndefOr[Node] = js.native
  def closest(el:Node, selector:String):js.UndefOr[Node] = js.native
  def clone(el:Node):Node = js.native
  def toggleClass(el:Node, name:String, state:Boolean):Unit = js.native
}

@js.native
object Sortable extends js.Object {
  @JSName("create")
  def apply(element:Element):Sortable = js.native
  @JSName("create")
  def apply(element:Element, props:js.Any):Sortable = js.native
}

