package edu.illinois.cs.cogcomp.saulexamples.nlp.DataModelTests
import edu.illinois.cs.cogcomp.core.datastructures.textannotation._
import edu.illinois.cs.cogcomp.saul.datamodel.DataModel
import edu.illinois.cs.cogcomp.saul.datamodel.edge.Edge
import edu.illinois.cs.cogcomp.saulexamples.data.Document

import scala.collection.mutable.{ Map => MutableMap }

/** Created by Parisa on 10/1/15.
  */
object modelWithSensors extends DataModel {

  /** Node Types
    */
  val rawDocument = node[Document]
  val document = node[TextAnnotation]
  val sentence = node[Sentence]

  /** Property Types
    */

  val label = discreteAttributeOf[Constituent]('label) {
    x =>
      {
        x.getLabel
      }
  }

  val docFeatureExample = discreteAttributeOf[TextAnnotation]('doc) {
    x: TextAnnotation =>
      {
        x.getNumberOfSentences.toString
      }
  }
  val sentenceFeatureExample = discreteAttributeOf[Sentence]('sentnce) {
    x: Sentence =>
      {
        x.getText
      }
  }

  /** Edge Types
    */

  val docTosen = edge[TextAnnotation, Sentence]('dTos)
  val SenToCons = edge[TextAnnotation, Constituent]('tToc)

}
